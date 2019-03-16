package dao;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
            Session currentSession = sessionFactory.getCurrentSession();
        //create a query ... sort by last name
            Query<Customer> theQuery = currentSession.createQuery(" FROM Customer ORDER BY lastName", Customer.class);
        //execute query and get tesult list
            List<Customer> customers = theQuery.getResultList();
        //return the results
            return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class,customerId);
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("DELETE FROM Customer where id=:customerId");
        query.setParameter("customerId",customerId);
        query.executeUpdate();
    }
}
