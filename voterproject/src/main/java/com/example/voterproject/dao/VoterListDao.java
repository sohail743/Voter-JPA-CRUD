package com.example.voterproject.dao;

import com.example.voterproject.entity.Voter;

public interface VoterListDao {
	
	public void saveVoter(Voter voter);
	
	public Voter findVoterById(Integer id);
	
	public Voter findVoterByPhoneNumber(String phoneNumber);
	
	public void updateVoterPhoneNumber(Integer id,String newPhoneNumber);
	
	public void deleteVoter(Integer id);

}
