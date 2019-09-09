package com.dev.spring.rest.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.beans.Employee;
import com.dev.spring.services.EmployeeServices;
import com.dev.spring.services.EmployeeServicesImpl;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class EmployeeController {

	EmployeeServices services = new EmployeeServicesImpl();

	@RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
	public Employee getDummyEmployee() {
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setEmail("emp@mail.com");
		services.createEmployee(emp);
		return emp;
	}

	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int empId) {
		return services.getEmployee(empId);
	}

//		@RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
//		public List<Employee> getAllEmployees() {
//			List<Employee> emps = new ArrayList<Employee>();
//			List<Employee> empIdKeys = empData.keySet();
//			for(Integer i : empIdKeys){
//				emps.add(empData.get(i));
//			}
//			return emps;
//		}

	@RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		services.createEmployee(emp);
		return emp;
	}

	@RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.PUT)
	public Employee deleteEmployee(@PathVariable("id") int empId) {
		Employee emp = services.getEmployee(empId);
		services.deleteEmployee(empId);
		return emp;
	}

	@RequestMapping(value = "/rest/emp/update", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) {
		Employee employee = services.updateEmail(emp.getId(), emp.getEmail());
		return employee;
	}
}