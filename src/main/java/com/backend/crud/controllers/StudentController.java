package com.backend.crud.controllers;

import com.backend.crud.entity.StudentEntity;
import com.backend.crud.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students/")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @GetMapping
    public List<StudentEntity> getAllData(){
        return this.studentServices.getAll();
    }

    @GetMapping("{id}")
    public StudentEntity getDataById(@PathVariable int id){
        return this.studentServices.getById(id);
    }
    @PostMapping
    public String postData(@RequestBody StudentEntity studentEntity){
        return this.studentServices.post(studentEntity);
    }
    @PutMapping("{id}")
    public String updateData(@PathVariable int id, @RequestBody StudentEntity studentEntity){
        return this.studentServices.update(id, studentEntity);
    }
    @DeleteMapping("{id}")
    public String deleteDataById(@PathVariable int id){
        return this.studentServices.deleteById(id);
    }


}
