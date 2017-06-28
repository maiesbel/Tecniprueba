package edu.tecnilogica.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;

import edu.tecnilogica.entity.Departments;

public class SelectCriteria5 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactori();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			
			tx.begin();
			
			TypedQuery<Departments> query = em.createNamedQuery("Departments.pornombre", Departments.class);
			query.setParameter("name", "Operations");
			
			Departments d = query.getSingleResult();
			System.out.println(d.getDepartmentId() + " " + d.getDepartmentName());
			
			query.setFlushMode(FlushModeType.AUTO);
			query.setFlushMode(FlushModeType.COMMIT);
			
			TypedQuery<Departments> query1 = em.createNamedQuery("Departments.todos", Departments.class);
			
			
			List<Departments> ld = query1.getResultList();
			for(Departments d1 : ld ){
				System.out.println(d1.getDepartmentId() + " " + d1.getDepartmentName());
			}
			
			
			
			
			tx.commit();
			em.close();
			emf.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
