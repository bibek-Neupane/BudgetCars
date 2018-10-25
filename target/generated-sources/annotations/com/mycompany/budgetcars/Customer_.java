package com.mycompany.budgetcars;

import com.mycompany.budgetcars.Sales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:49:12")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> phoneNumber;
    public static volatile SingularAttribute<Customer, String> streetAddress;
    public static volatile SingularAttribute<Customer, String> postcode;
    public static volatile SingularAttribute<Customer, String> suburb;
    public static volatile ListAttribute<Customer, Sales> orders;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile SingularAttribute<Customer, String> email;

}