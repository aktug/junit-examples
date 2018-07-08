package com.aktug.junitexamples.testDoubles;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class dummy3 {

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

        public void addCustomer(Customer customer) throws Exception {
            if (customer == null) {
                throw new Exception("Customer should be not null");
            }
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
    public void addCustomerWithDummyTest() throws Exception {
        Customer dummy = mock(Customer.class); // It is dummy, not a mock
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        Assert.assertEquals(1, addressBook.getNumberOfCustomers());
    }

}
