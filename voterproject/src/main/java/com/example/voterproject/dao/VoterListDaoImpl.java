package com.example.voterproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.voterproject.entity.Voter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class VoterListDaoImpl implements VoterListDao {
    
	
	@Autowired
	private EntityManager entityManager;
	
	
	public VoterListDaoImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	@Transactional
	public void saveVoter(Voter voter) {
		// TODO Auto-generated method stub
		entityManager.persist(voter);
		
	}
	@Override
	public Voter findVoterById(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery theQuery=entityManager.createQuery("Select v from Voter v where v.id=:id", Voter.class);
		theQuery.setParameter("id", id);
		Voter voter=(Voter) theQuery.getSingleResult();
		return voter;
	}
	@Override
	public Voter findVoterByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		TypedQuery theQuery=entityManager.createQuery("Select v from Voter v where v.phoneNumber=:phonenumber", Voter.class);
		theQuery.setParameter("phonenumber", phoneNumber);
		Voter voter=(Voter) theQuery.getSingleResult();
		return voter;
	}
	@Override
	@Transactional
	public void updateVoterPhoneNumber(Integer id, String newPhoneNumber) {
		// TODO Auto-generated method stub
		Query theQuery=entityManager.createQuery("Update Voter v SET v.phoneNumber=:newphonenumber  where v.id=:id");
		theQuery.setParameter("id", id);
		theQuery.setParameter("newphonenumber", newPhoneNumber);
		theQuery.executeUpdate();
	}
	
	@Override
	@Transactional
	public void deleteVoter(Integer id) {
		// TODO Auto-generated method stub
		Voter voter = entityManager.find(Voter.class, id);
		entityManager.remove(voter);
		
	}

}
