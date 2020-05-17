package com.digitalacademy.customer.service;
import com.digitalacademy.customer.model.Customer;
import com.digitalacademy.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomerList() {
        //return getCustomerDemo();
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        //return getCustomerDemo().get(id)
        return customerRepository.findAllById(id);
    }

    public List<Customer> getCustomerName(String name){
        return customerRepository.findByFirstName(name);
    }

    public Customer createCustomer(Customer body){
        return customerRepository.save(body);
    }
    //edit data
    public Customer updateCustomer(Long id,Customer customerReq){
        return customerRepository.findAllById(id) != null ?
                customerRepository.save(customerReq) : null;
    }

    public boolean deleteById(Long id){
        try{
            customerRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        } finally {
            //ใส่ก้อได้ไม่ใส่ก้อได้เป้นการ force ทำ
        }
    }
}