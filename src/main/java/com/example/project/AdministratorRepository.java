package com.example.project;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called administratorRepository
// CRUD refers Create, Read, Update, Delete

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

}
