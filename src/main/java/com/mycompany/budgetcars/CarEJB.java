/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.budgetcars;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author BIBEK
 */

@Stateless
public class CarEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext (unitName = "carPU")
    private EntityManager em; // Instantiate the entity manager
    
    
     
    public List<Car> findCars(){
        TypedQuery<Car> query = em.createNamedQuery("findAllCars",Car.class); //named query defined in the customer entity is created and the result is requested
        return query.getResultList();
    }
    
  
       public Car createCar(Car car){ // persist the car
        em.persist(car);
        return car;
    }
    
   
    
     public void deleteCar(Car car){
       
    }
     
     
     public List<Customer> findAllCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomer", Customer.class);
        return query.getResultList();
    }
     
     public List<Customer> findByName(String name){// this will enable to search by customer name
         TypedQuery<Customer> query = em.createNamedQuery("findCustomerByName", Customer.class);
         query.setParameter("firstName", name);
         return query.getResultList();
         
     }
     
     public Customer createCustomer(Customer customer){ // customer is persisted
        em.persist(customer);
        return customer;
    }
     
      public Customer deleteCustomer(Customer customer){
        if (!em.contains(customer)) {
            customer = em.merge(customer); //the only requirement is to delete managed object hence we merge before deleting
        }
        em.remove(customer);
        return customer;
        
    }
      
        public List<Sales> findSales(){
        TypedQuery<Sales> query = em.createNamedQuery("findAllSales",Sales.class);
        return query.getResultList();
        
        
    }
        
       
        
      
    public Sales createSale(Sales sale){
        em.persist(sale);
        return sale;
    }
    
    
       
      public void deleteSales(Sales sale){
        em.remove(sale);
    }

    
}
