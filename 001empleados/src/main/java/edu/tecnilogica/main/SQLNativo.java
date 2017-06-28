package edu.tecnilogica.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;


public class SQLNativo {

	public static void main(String[] args) {

		Session session = HibernateFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		SQLQuery qnativa= session.createSQLQuery("select employee_id, email from employees");
		List<Object[]> empleados = qnativa.list();
		
		for(Object[] empleado : empleados){
			System.out.println(empleado[0] + " "+empleado[1]);
		}
		
		System.out.println("otro ejemplo");
		
		SQLQuery qnativa1= session.createSQLQuery("select * from employees");
		qnativa1.addEntity(Employees.class);
		List<Employees> empleados1 = qnativa1.list();
		
		for(Employees empleado1 : empleados1){
			System.out.println(empleado1.getEmail()+ " "+ empleado1.getEmployeeId());
		}
					
		
		tx.commit();
		session.close();
		HibernateFactory.getSessionFactory().close();
		
		
	}

}
