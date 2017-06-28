package edu.tecnilogica.main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import edu.tecnilogica.entity.Countries;
import edu.tecnilogica.entity.Regions;

public class MainJPA {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		
		try{
			
			emf = JPAFactory.getEntityManagerFactori();
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = null;
			
			try{//"Transaccion"
				
				tx = em.getTransaction();
				tx.begin();
				Regions rg = em.find(Regions.class, new BigDecimal(1));
				System.out.println("Región nombre = " + rg.getRegionName());
				System.out.println("Región id = " + rg.getRegionId());
				
				System.out.println("Mostrar paises");
				Set<Countries> cjto_paises = rg.getCountrieses();
				Iterator<Countries> it= cjto_paises.iterator();
				Countries caux = null;
				while (it.hasNext()){
					caux= it.next();
					System.out.println(caux.toString());
				}
				tx.commit();
				
				
				
			}catch (Exception e) {
				
				tx.rollback();
				e.printStackTrace();
			}finally {
				em.close();
			}
			
		}catch (Throwable t) {
			t.printStackTrace();
			
		}finally { //libero
			emf.close();
		}
	
		
		
	}

}
