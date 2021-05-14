package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.restcontroller.model.Admin;

@Repository
public interface UserRepository extends CrudRepository<Admin, Integer>{
	
	Admin findByUsername(String username);

}
