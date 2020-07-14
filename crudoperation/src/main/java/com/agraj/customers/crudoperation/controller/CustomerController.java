package com.agraj.customers.crudoperation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agraj.customers.crudoperation.exception.ResourceNotFoundException;
import com.agraj.customers.crudoperation.model.Customer;
import com.agraj.customers.crudoperation.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
 @Autowired
 private CustomerRepository customerRepository;
 
 @GetMapping("/customers")
 public List<Customer> getAllCustomers(){
	 return customerRepository.findAll();
 }
 
 @GetMapping("/customers/{id}")
 public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id")Long customerId)throws ResourceNotFoundException{
	 Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found ::" + customerId));
	 return ResponseEntity.ok().body(customer);
 }
 
 @PostMapping("/customers")
 public Customer createCustomer(@Valid @RequestBody Customer customer) {
	 return customerRepository.save(customer);
 }
 
 @PutMapping("/customer/{id}")
 public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId, @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException{
	 
	 Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer Not Found ::" + customerId));
	 
	 customer.setFirstName(customerDetails.getLastName());
	 customer.setLastName(customerDetails.getLastName());
	 customer.setDOB(customerDetails.getDOB());
	 customer.setEmailId(customerDetails.getEmailId());
	 
	 final Customer updateCustomer = customerRepository.save(customer);
	 return ResponseEntity.ok(updateCustomer);
 }
 
 @DeleteMapping("/customer/{id}")
 public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws ResourceNotFoundException{
	 Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer Not found :: " + customerId));
	 
	 customerRepository.delete(customer);
	 Map<String, Boolean> response = new HashMap<>();
	 response.put("Deleted", Boolean.TRUE);
	 return response;
 }
}
