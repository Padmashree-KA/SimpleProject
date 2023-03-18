package com.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee_management_system.model.Employee;
import com.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List < Employee > getEmployees() {
		return  employeeRepository.findAll();
	}


	@Transactional
	public void saveEmployee(Employee theEmployee) {
		this.employeeRepository.save(theEmployee);
	}


	@Transactional
	public Employee getEmployee(long theId) {
		Optional <Employee> optional=employeeRepository.findById(theId);
		Employee employee=null;
		if(optional.isPresent()){
			employee=optional.get();
		}
		else{
			throw new RuntimeException("Employee not found" +theId);
		}
		return employee;
	}


	@Transactional
	public void deleteEmployee(long theId) {
		this.employeeRepository.deleteById(theId);

	}


	
	
	
	
}
