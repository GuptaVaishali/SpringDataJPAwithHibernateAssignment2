package com.springdatajpawithhibernatepart2.Assignment.inheritance.entities;

import javax.persistence.*;

@Entity
/******** Single table strategy ******************/
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)

/******** Table Per Class Strategy ******************/
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

/******** Joined strategy ******************/
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "payment1")
public class Payment {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
