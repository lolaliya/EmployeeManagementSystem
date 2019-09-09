package com.dev.spring.dao;

import java.util.List;

import com.dev.spring.beans.Employee;

public interface EmployeeDAO {
	public Employee createEmployee(Employee employee);
	public Employee getEmployee(Integer empId);
	public List<Employee> getAllEmployees();
	public Employee deleteEmployee(Integer empId);
	public Employee updateEmail(Integer empId, String email);
}