/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcars;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author BIBEK
 */

@Named(value = "carController") //this can be accessed on the JSF pages to call in the methods in carController
@RequestScoped
public class CarController {

    /**
     * Creates a new instance of CarController
     */
   
    public CarController() {
    }
    
   @Inject //Injectable contructors are defined by @Inject
   private CarEJB carEJB;
   
   
   private Customer customer = new Customer();                                                  //Instance of the entity classes are created which will be populated with data from the user
   private Car car = new Car();
   private Sales sale = new Sales();
   private List<Sales> saleList = new ArrayList<Sales>();
   private List<Car> carList = new ArrayList<Car>();
   private List<Customer> customerList = new ArrayList<Customer>();
   private String keyword;      //keyword for the search query will compare to the values of firstNames.
   private List<Customer> namedList = new ArrayList<Customer>();  //will hold the list of all the matching customer

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

   
   public String doCreateCustomer(){ //docreate method to interact with the EJB to create a customer
       customer = carEJB.createCustomer(customer);    //pass the object customer to the EJB to be persisted on the database
       return "car.xhtml";        //navigate after creation
   }
   
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {  // this method if called will find all customers
        customerList=carEJB.findAllCustomers();
        return customerList;
    }
    
  
    
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> searchByName(String name) { // searcfor customer via customer firstname
       namedList=carEJB.findByName(name);
       return namedList;
       
       
    }
    public List<Customer> getNamedList(){
        return namedList;
    }
    
     public String submit(){     // submit the keyword in the JSF and passed on to the method searchByName
        namedList=this.searchByName(keyword);
        return "listCustomer.xhtml";
       
    }
      

    public void setNamedList(List<Customer> namedList) {
        this.namedList = namedList;
    }
    
   
    
    public void doDeleteCustomer(Customer customer){ // delete the customer 
        customer = carEJB.deleteCustomer(customer);
        
  
    }
    
    public String doCreateCar(){
        car = carEJB.createCar(car);
        return "sales.xhtml";
   }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCarList() {
        carList=carEJB.findCars();
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
    
    public String doCreateSale(){
        customer.getOrders().add(sale);
        sale = carEJB.createSale(sale);
        return "search.xhtml";
        
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
       
    }

    public List<Sales> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sales> saleList) {
        this.saleList = saleList;
    }
    
   
    
 
}
