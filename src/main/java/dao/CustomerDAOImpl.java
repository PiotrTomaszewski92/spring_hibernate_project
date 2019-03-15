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

    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        System.out.println("1");
            Session currentSession = sessionFactory.getCurrentSession();
        //create a query
        System.out.println("2");
            //Query<Customer> theQuery = currentSession.createQuery(" FROM Customer", Customer.class);
//                List<Customer> customers = (List<Customer>)currentSession.createQuery("from Customer").list();

        System.out.println("3");
        //execute query and get tesult list
            //List<Customer> customers = theQuery.getResultList();
        List<Customer> customers = currentSession.createQuery(" from Customer",Customer.class).list();
        System.out.println("===============");
        for (Customer c : customers){
            System.out.println(c.getFirstName());
        }
        //return the results
            return customers;
    }
}
