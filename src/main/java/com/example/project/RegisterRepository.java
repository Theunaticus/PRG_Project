package com.example.project;

import org.springframework.data.repository.CrudRepository;

import com.example.project.Register;

// This will be AUTO IMPLEMENTED by Spring into a Bean called registerRepository
// CRUD refers Create, Read, Update, Delete
// Cool

public interface RegisterRepository extends CrudRepository<Register, Integer> {

}
