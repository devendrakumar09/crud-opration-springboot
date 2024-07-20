package com.backend.crud.services;

import com.backend.crud.entity.StudentEntity;

import java.util.List;

public interface StudentServices {

    public List<StudentEntity> getAll();
    public StudentEntity getById(int id);
    public String post(StudentEntity studentEntity);
    public String update(int id, StudentEntity studentEntity);
    public String deleteById(int id);
}
