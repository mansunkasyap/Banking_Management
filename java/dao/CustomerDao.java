package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class CustomerDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager emgr = emf.createEntityManager();
	EntityTransaction etr = emgr.getTransaction();
	public void save(Customer customer)
	{
		etr.begin();
		emgr.persist(customer);
		etr.commit();
	}
	
	public List<Customer> fetch(long mobile) {
//		return  (emgr.find(Customer.class, mobile));
		List<Customer> list = emgr.createQuery("select x from Customer x where mob=?1").setParameter(1, mobile).getResultList();
		return list;
	}
	public List<Customer> fetch(String email) {
		List<Customer> list = emgr.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
		return list;
	}
	
	public Customer fetchById(Long custid) {
		Customer customer = emgr.find(Customer.class, custid);
		return customer;
	}
	
	public void update(Customer customer) {
		etr.begin();
		emgr.merge(customer);
		etr.commit();
	}
	
}
