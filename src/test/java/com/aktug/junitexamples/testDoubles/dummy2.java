package com.aktug.junitexamples.testDoubles;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class dummy2 {

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

    //@Test(expected = Exception.class) // Return true if exception throws
    @Test
    public void addNullCustomerTest() throws Exception {
        Customer dummy = null;
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        assertEquals(1, addressBook.getNumberOfCustomers());
    }

}
