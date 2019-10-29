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
	public Bank getAccount(int Accountnumber) {

		return entityManager.find(Bank.class, Accountnumber);
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

		Bank BankFromDB = getAccount(id);
		//BankFromDB.setId(Bank.getId());
		BankFromDB.setAccountNumber(Bank.getAccountNumber());
		BankFromDB.setEmail(Bank.getEmail());
		BankFromDB.setFirstName(Bank.getFirstName());
		BankFromDB.setLastName(Bank.getLastName());
		BankFromDB.setAddress1(Bank.getAddress1());
		BankFromDB.setAddress2(Bank.getAddress2());
		BankFromDB.setPhone(Bank.getPhone());

		entityManager.flush();
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
}
