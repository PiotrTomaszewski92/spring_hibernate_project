package dao;

import entity.Customer;
import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int customerId);
    void deleteCustomer(int customerId);
}

