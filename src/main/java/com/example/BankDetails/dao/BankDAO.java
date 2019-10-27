package com.example.BankDetails.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.BankDetails.entity.Bank;

@Transactional
@Repository
public class BankDAO implements BankDAOImpl{
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method is responsible to get all account details available in database and return it as List<Bank>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getAllAccountDetails(){
		String hql = "FROM Bank";
		return (List<Bank>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * This method is responsible to get a particular Bank detail by given id 
	 */
	@Override
	public Bank getAccount(int id) {
		
		return entityManager.find(Bank.class, id);
	}

	/**
	 * This method is responsible to create new account in database
	 */
	@Override
	public Bank createAccount(Bank Bank) {
		entityManager.persist(Bank);
		Bank b = getLastInsertedBank();
		return b;
	}

	/**
	 * This method is responsible to update account details in database
	 */
	@Override
	public Bank updateAccount(int id, Bank Bank) {
		
		//First We are taking Bank detail from database by given Bank id and 
		// then updating detail with provided Bank object
		System.out.println("jk");
		Bank BankFromDB = getAccount(id);
		System.out.println("oy"+id);
		BankFromDB.setId(Bank.getId());
		BankFromDB.setAccountNumber(Bank.getAccountNumber());
		System.out.println("mk");
		BankFromDB.setEmail(Bank.getEmail());
		BankFromDB.setFirstName(Bank.getFirstName());
		BankFromDB.setLastName(Bank.getLastName());
		BankFromDB.setAddress1(Bank.getAddress1());
		BankFromDB.setAddress2(Bank.getAddress2());
		BankFromDB.setPhone(Bank.getPhone());
		
		entityManager.flush();
		
		//again i am taking updated result of Bank and returning the Bank object
		Bank updatedBank = getAccount(id);
		
		return updatedBank;
	}

	/**
	 * This method is responsible for deleting a particular 
	 * record from the database
	 */
	@Override
	public boolean deleteAccount(int id) {
		Bank Bank = getAccount(id);
		entityManager.remove(Bank);
		
		//we are checking here that whether entityManager contains earlier deleted Bank or not
		// if contains then Bank is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(Bank);
		if(status){
			return false;
		}
		return true;
	}
	
	/**
	 * This method will get the latest inserted record from the database and return the object of Bank class
	 * @return Bank
	 */
	private Bank getLastInsertedBank(){
		String hql = "from Bank order by Accountnumber DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		Bank Bank = (Bank)query.getSingleResult();
		return Bank;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getTotalamount() {
		String hql = "select bk.Firstname,bk.Lastname,bk.Email,bk.Phone, sum(Amountbalance) as Totalamount from Bank as bk group by bk.Email";
		return (List<Bank>) entityManager.createQuery(hql).getResultList();
	}

}
