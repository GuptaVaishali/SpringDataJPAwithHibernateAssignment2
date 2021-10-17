package com.springdatajpawithhibernatepart2.Assignment.inheritance.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/******** Single table strategy ******************/
//@DiscriminatorValue("cc")

/******** Table Per Class Strategy ******************/
//@Table(name = "card")

/******** Joined strategy ******************/
@Table(name = "card1")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
