package com.example.voterproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.voterproject.dao.VoterListDao;
import com.example.voterproject.entity.Voter;

@SpringBootApplication
public class VoterprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoterprojectApplication.class, args);
		
	}

    @Bean
    CommandLineRunner commandLineRunner(VoterListDao voterListDao) {

		return runner -> {
//			saveVoter(voterListDao);
//			findVoterById(voterListDao,4);
//			findVoterByPhoneNumber(voterListDao,"1234567890");
		//	updatePhoneNumber(voterListDao,2,"123456789");
			deleteVoter(voterListDao,2);
		};
	}

	private void deleteVoter(VoterListDao voterListDao,Integer id) {
		// TODO Auto-generated method stub
		voterListDao.deleteVoter(id);
		System.out.println("The voter number is deleted");
		
		
	}

	private void updatePhoneNumber(VoterListDao voterListDao, Integer id, String newPhoneNumber) {
		// TODO Auto-generated method stub
		voterListDao.updateVoterPhoneNumber(id, newPhoneNumber);
		System.out.println("The voter number is updated");
		findVoterById(voterListDao,id);
		
	}

	private void findVoterByPhoneNumber(VoterListDao voterListDao,String phoneNumber) {
		// TODO Auto-generated method stub
		Voter voter=voterListDao.findVoterByPhoneNumber(phoneNumber);
		System.out.println("********************");
		System.out.println("The Voter Deatils by phone number");
		System.out.println("The Voter Id: "+voter.getId());
		System.out.println("The Voter name: "+voter.getFirstName()+" "+voter.getLastName());
		System.out.println("The Voter Father name: "+voter.getFatherName());
		System.out.println("The Voter email id : "+voter.getEmailId());
		System.out.println("The Voter Phone number: "+voter.getPhoneNumber());
		
	}

	private void findVoterById(VoterListDao voterListDao, Integer id) {
		// TODO Auto-generated method stub
		Voter voter=voterListDao.findVoterById(id);
		System.out.println("********************");
		System.out.println("The Voter Deatils by id");
		System.out.println("The Voter Id: "+voter.getId());
		System.out.println("The Voter name: "+voter.getFirstName()+" "+voter.getLastName());
		System.out.println("The Voter Father name: "+voter.getFatherName());
		System.out.println("The Voter email id : "+voter.getEmailId());
		System.out.println("The Voter Phone number: "+voter.getPhoneNumber());
		
	}

	private void saveVoter(VoterListDao voterListDao) {
		// TODO Auto-generated method stub
		Voter voter1=new Voter("Saleem","Mohammed","abc","saleem@gmail.com","1234567890");
		Voter voter2=new Voter("Salman","Khan","Salim Khan","salman@gmail.com","1234567890");
		Voter voter3=new Voter("Arbaaz","Khan","Salim Khan","arbaaz@gmail.com","1237894560");
		voterListDao.saveVoter(voter1);
		voterListDao.saveVoter(voter2);
		voterListDao.saveVoter(voter3);
	
	}
	
	

}
