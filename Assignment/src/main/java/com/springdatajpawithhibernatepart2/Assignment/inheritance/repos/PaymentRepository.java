package com.springdatajpawithhibernatepart2.Assignment.inheritance.repos;

import com.springdatajpawithhibernatepart2.Assignment.inheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Long> {

}
