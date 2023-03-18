package com.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee_management_system.model.Department;
import com.employee_management_system.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService dService;
	
	@GetMapping("/deptList")
	public String listDepartments(Model theModel) {
		theModel.addAttribute("departments", dService.getAllDepartments());
		return "department_list";
	}
	
	

	@GetMapping("/deptForm")
	public String showFormForAdd(Model theModel) {
		Department dept = new Department();
		theModel.addAttribute("department", dept);
		return "department_form";
	}

	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("department") Department dept) {
		dService.saveDepartment(dept);
		return "redirect:/deptList";
	}

	@GetMapping("/updateDept")
	public String showFormForUpdate(@RequestParam("id") int theId,
			Model theModel) {
		Department dept = dService.getDepartmentById(theId);
		theModel.addAttribute("department", dept);
		return "update_department";
	}

	@GetMapping("/deleteDept")
	public String deleteDepartment(@RequestParam("id") int theId) {
		this.dService.deleteDepartment(theId);
		return "redirect:/deptList";
	}


}
