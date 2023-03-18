package com.employee_management_system.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.employee_management_system.model.Employee;

public interface EmployeeService {
	
	 public List < Employee > getEmployees();

	    public void saveEmployee(Employee theEmployee);

	    public Employee getEmployee(long theId);

	    public void deleteEmployee(long theId);
	    
	  
}
