package edu.tecnilogica.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAFactory {

	private static EntityManagerFactory factory;
	
	static{
		new JPAFactory();
	}
	
	private JPAFactory(){
		
		try{
			
			
			factory = Persistence.createEntityManagerFactory("unit");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactori (){
		
		return factory;
	}
	
	
	
}
