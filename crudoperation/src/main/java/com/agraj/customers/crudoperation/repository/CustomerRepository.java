package com.agraj.customers.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agraj.customers.crudoperation.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
