package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Regions;

public class SelectCriteria2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactori();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<Regions> cq = cb.createQuery(Regions.class);
			Root<Regions> root = cq.from(Regions.class);
			
			cq.select(root);
			//cq.where(cb.equal(root.get("regionName"), "Azkoitia"));
			
			TypedQuery<Regions> tq = em.createQuery(cq);
			List<Regions> lnr = tq.getResultList(); //getSingleResult(); bakarra daola ziurtatu
			
			for (Regions reg : lnr){
				System.out.println(reg.getRegionName() + " "+ reg.getRegionId());
			}
			
			tx.commit();
			em.close();
			emf.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
