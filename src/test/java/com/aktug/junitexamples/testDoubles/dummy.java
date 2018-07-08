package com.aktug.junitexamples.testDoubles;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class dummy {

    private class Customer {
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    private class AddressBook {
        private ArrayList<Customer> list = new ArrayList<>();

        public void addCustomer(Customer customer) {
            this.list.add(customer);
        }

        public int getNumberOfCustomers() {
            return this.list.size();
        }
    }


    public Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setCountry("Turkey");
        return customer;
    }

    @Test
    public void addCustomerTest() {
        Customer dummy = createDummyCustomer();
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        assertEquals(1, addressBook.getNumberOfCustomers());
    }

}
