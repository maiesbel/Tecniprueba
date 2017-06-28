package edu.tecnilogica.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class MainHibernateEjemploTarde1 {
	
	public static void main(String[] args) {
		
		
		//Los empleados en el sistema van del 100 al 207
		//hacer un lgoritmo con la sesion de hibernate para subir un 7% a todos el sueldo
		SessionFactory sf = null;
		
		try{
			
			sf = HibernateFactory.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
			
			
			try{//"Transaccion
				
				tx = session.beginTransaction();
				Employees empleado = null;
				System.out.println("Mostrar sueldo");
				for (int i = 101; i <207; i++){
					empleado = session.get(Employees.class, i);
					BigDecimal salario_actual = empleado.getSalary();
					BigDecimal salario_nuevo = salario_actual.multiply(new BigDecimal(107)).
							divide(new BigDecimal(100));
					empleado.setSalary(salario_nuevo);
				}
				
				//session.save(empleado); berez ez ber new employe ez teulako ein ta persistance
				//egoeran daolako hola ein de				
				tx.commit();
				
			}catch (Exception e) {
				
				tx.rollback();
				e.printStackTrace();
			}finally {
				session.close();
			}
			
			//rg.setRegionName("Madrid");//finally kanpun daonez errorie emateu 
			
		}catch (Throwable t) {
			t.printStackTrace();
			
		}finally { //libero
			sf.close();
		}
	
		
		
	}

}
