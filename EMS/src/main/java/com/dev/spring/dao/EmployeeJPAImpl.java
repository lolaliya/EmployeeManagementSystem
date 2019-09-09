package com.dev.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dev.spring.beans.Employee;

public class EmployeeJPAImpl implements EmployeeDAO{
	private final static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("MySQLUnit");

	
	public Employee createEmployee(Employee employee) {
		int empId = employee.getId();
		Employee state = null;;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			employee = em.find(Employee.class, empId);
			em.close();
			state = employee;
		} catch (Exception e) {
			//throw custom exception
			e.printStackTrace();
		}
		return state;
	}

	
	public Employee getEmployee(Integer empId) {
		EntityManager em = emf.createEntityManager();
		Employee employee = em.find(Employee.class, empId);
		em.close();
		return employee;
	}

	
	public List<Employee> getAllEmployees() {
		return null;
//		EntityManager em = emf.createEntityManager();
//		List<Employee> emps = new ArrayList<Employee>();
//		
//		emps.add(e);
//		
//	}
//	
//	
//	Set<Integer> empIdKeys = empData.keySet();
//	for(Integer i : empIdKeys){
//		emps.add(empData.get(i));
	}
	

	
	public Employee deleteEmployee(Integer empId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee employee = em.find(Employee.class, empId);
		em.remove(employee);
		em.getTransaction().commit();
		em.close();
		return employee;
	}

	
	public Employee updateEmail(Integer empId, String email) {
		Employee state = null;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee employee = em.find(Employee.class, empId);
			employee.setEmail(email);
			em.getTransaction().commit();
			employee = em.find(Employee.class, empId);
			em.close();
			state = employee;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}

}
