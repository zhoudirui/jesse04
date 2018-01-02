package com.jesse04.case08.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jesse04.case08.mongodb.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

     Customer findByFirstName(String firstName);
     List<Customer> findByLastName(String lastName);

}