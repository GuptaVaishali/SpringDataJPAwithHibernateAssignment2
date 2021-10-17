package com.springdatajpawithhibernatepart2.Assignment.inheritance.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/******** Single table strategy ******************/
//@DiscriminatorValue("ch")

/******** Table Per Class Strategy ******************/
//@Table(name = "bankcheck")

/******** Joined strategy ******************/
@Table(name = "bankcheck1")
@PrimaryKeyJoinColumn(name = "id")
public class Check extends Payment{
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
