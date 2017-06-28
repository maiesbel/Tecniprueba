package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Employees;

public class SelectCriteria4 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactori();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try{
			
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			// EMPLOYEE_ID FIRSTNAME
			CriteriaQuery<MiniEmpleado> cq = cb.createQuery(MiniEmpleado.class);
			Root<Employees> root = cq.from(Employees.class);
			
			Path<Integer> pathId = root.get("employeeId");
			Path<String> pathfn = root.get("firstName");
			
			//cq.select(cb.array(pathId,pathfn));
			cq.select(cb.construct(MiniEmpleado.class, pathId, pathfn));
			
			TypedQuery<MiniEmpleado> tq = em.createQuery(cq);
			List<MiniEmpleado> lme = tq.getResultList(); 
			
			for (MiniEmpleado me : lme){
				System.out.println(me.getEmployeeId()+ " "+ me.getFirstName());//ID
				
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
