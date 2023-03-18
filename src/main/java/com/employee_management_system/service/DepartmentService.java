package com.employee_management_system.service;

import java.util.List;

import com.employee_management_system.model.Department;

public interface DepartmentService {
	
	public List < Department > getAllDepartments();

    public void saveDepartment(Department dept);

    public Department getDepartmentById(int theId);

    public void deleteDepartment(int theId);

}
