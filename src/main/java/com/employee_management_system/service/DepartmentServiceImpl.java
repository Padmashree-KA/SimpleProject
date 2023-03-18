package com.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.model.Department;
import com.employee_management_system.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository drepo;
	
	@Transactional
	public List < Department > getAllDepartments() {
		return  drepo.findAll();
	}


	@Transactional
	public void saveDepartment(Department dept) {
		this.drepo.save(dept);
	}


	@Transactional
	public Department getDepartmentById(int theId) {
		Optional <Department> optional=drepo.findById(theId);
		Department dept=null;
		if(optional.isPresent()){
			dept=optional.get();
		}
		else{
			throw new RuntimeException("Department not found" +theId);
		}
		return dept;
	}


	@Transactional
	public void deleteDepartment(int theId) {
		this.drepo.deleteById(theId);

	}



}
