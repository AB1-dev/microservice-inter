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


	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getTotalAmount() {
		String hql = "select sum(b.Amountbalance),b.Firstname,b.Lastname,b.Phone,b.Email FROM Bank b group by b.Email";
		return (List<Bank>) entityManager.createQuery(hql).getResultList();
	}
}
