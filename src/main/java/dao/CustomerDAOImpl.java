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


    public List<Customer> getCustomers() {
        //get the current hibernate session
            Session currentSession = sessionFactory.getCurrentSession();
        //create a query
            Query<Customer> theQuery = currentSession.createQuery(" FROM Customer", Customer.class);
        //execute query and get tesult list
            List<Customer> customers = theQuery.getResultList();
        //return the results
            return customers;
    }
}
