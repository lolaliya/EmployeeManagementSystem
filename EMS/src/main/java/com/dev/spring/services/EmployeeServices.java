package com.dev.spring.services;

import java.util.List;

import com.dev.spring.beans.Employee;

public interface EmployeeServices {
	public Employee createEmployee(Employee employee);
	public Employee getEmployee(Integer empId);
	public Employee deleteEmployee(Integer empId);
	public Employee updateEmail(Integer empId, String email);
	public List<Employee> getAllEmployees();
}