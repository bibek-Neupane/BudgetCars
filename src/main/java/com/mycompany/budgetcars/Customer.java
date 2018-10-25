/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcars;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author BIBEK
 */
/*
ENTITY class Customer will hold the reocrds all the sale
information from the web application
this class contains all the field members that define this 
entity and the getter and setter methods for the field members
*/
@Entity
@NamedQueries ({
@NamedQuery(name = "findAllCustomer" , query = "SELECT c FROM Customer c"),
@NamedQuery(name ="findCustomerByName", query = "SELECT c FROM Customer c where c.firstName=:firstName"),
})

//the @NamedQueries is used when we define multiple queries
// find all customer is used to obtain all the customers in the database
//findCustomerByName query will specifically match the search keyword provided by the user to search through firstnames

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String suburb;
    private String state;
    private String postcode;
    private String email;
    private String phoneNumber;
    
    @OneToMany  (cascade = CascadeType.MERGE)
    @JoinColumn(name="id", referencedColumnName ="id")
    private List <Sales> orders = new LinkedList<Sales>();
    
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Sales> getOrders() {
        return orders;
    }

    public void setOrders(List<Sales> orders) {
        this.orders = orders;
    }
    
    

    

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress + ", suburb=" + suburb + ", state=" + state + ", postcode=" + postcode + ", email=" + email + ", phoneNumber=" + phoneNumber +  '}';
    }
    
    

    
    
}
