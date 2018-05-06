/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhiraj
 */
@Entity
@XmlRootElement
public class Income implements Serializable{
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int ID;
    private String name;
    private long date;
    private double amount;
    private String particular;

    public Income() {
    }

    public Income(String name, long date, double amount, String particular) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.particular = particular;
    }

    public int getID() {
        return ID;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    
    
    
}
