package com.pratechgroup.demo.jpa.persistencia;

import org.springframework.data.repository.CrudRepository;

import com.pratechgroup.demo.jpa.entidades.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
