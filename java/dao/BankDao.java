package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Bankaccount;
import dto.Customer;

public class BankDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager emgr = emf.createEntityManager();
	EntityTransaction etr = emgr.getTransaction();
	public void save(Bankaccount bankaccount) {
		etr.begin();
		emgr.persist(bankaccount);
		etr.commit();
	}
	
	public List<Bankaccount> fetch_All_Bank_Details() {
		List<Bankaccount>list = emgr.createQuery("select x from Bankaccount x").getResultList();
		return list;
	}
	public Bankaccount fetchByAccno(long accno) {
		 Bankaccount bankaccount = emgr.find(Bankaccount.class, accno);
		 return bankaccount;
	}

	public void update(Bankaccount bankaccount) {
		etr.begin();
		emgr.merge(bankaccount);
		etr.commit();
	}
}