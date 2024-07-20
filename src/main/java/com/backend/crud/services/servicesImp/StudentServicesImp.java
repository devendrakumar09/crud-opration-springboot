package com.backend.crud.services.servicesImp;

import com.backend.crud.entity.StudentEntity;
import com.backend.crud.repo.StudentRepo;
import com.backend.crud.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImp implements StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentEntity> getAll() {
        return this.studentRepo.findAll();
    }

    @Override
    public StudentEntity getById(int id) {
        Optional<StudentEntity> student = this.studentRepo.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public String post(StudentEntity studentEntity) {
        this.studentRepo.save(studentEntity);
        return "1 Record Inserted";
    }

    @Override
    public String update(int id, StudentEntity studentEntity) {
        Optional<StudentEntity> student = this.studentRepo.findById(id);
        if (student.isPresent()){
            StudentEntity existStudent = student.get();
            existStudent.setName(studentEntity.getName());
            existStudent.setContact(studentEntity.getContact());
            this.studentRepo.save(existStudent);
            return existStudent.toString();
        }
        return "NO DATA FOUND";
    }

    @Override
    public String deleteById(int id) {
        Optional<StudentEntity> student = this.studentRepo.findById(id);
        if (student.isPresent()){
            this.studentRepo.deleteById(id);
            return "1 ROW DELETED";
        }
        return "NO DATA FOUND";
    }
}
