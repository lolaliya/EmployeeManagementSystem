package com.dev.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.spring.beans.Employee;
import com.dev.spring.dao.EmployeeDAO;
import com.dev.spring.dao.EmployeeJPAImpl;



@Service
public class EmployeeServicesImpl implements EmployeeServices {
	private EmployeeDAO db = new EmployeeJPAImpl();

	
	public Employee createEmployee(Employee employee) {
		return db.createEmployee(employee);
	}

	
	public Employee getEmployee(Integer empId) {
		return db.getEmployee(empId);
	}

	
	public Employee deleteEmployee(Integer empId) {
		return db.deleteEmployee(empId);
	}

	
	public Employee updateEmail(Integer empId, String email) {
		return db.updateEmail(empId, email);
	}

	
	public List<Employee> getAllEmployees() {
		return db.getAllEmployees();
	}




	
}