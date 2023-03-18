package com.employee_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.employee_management_system.model.Employee;
import com.employee_management_system.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("listEmployees", employeeService.getEmployees());
		return "employee_list";
	}
	

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee_form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return "redirect:/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("id") long theId,
			Model theModel) {
		Employee theEmployee = employeeService.getEmployee(theId);
		theModel.addAttribute("employee", theEmployee);
		return "update_employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long theId) {
		this.employeeService.deleteEmployee(theId);
		return "redirect:/list";
	}
	
	@RequestMapping("/employee")
	public String searchEmployee(Model theModel){
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee";
	}
	
	@RequestMapping("/search")
	public String showForm(@RequestParam("id") long theId,
			Model theModel) {
		Employee theEmployee = employeeService.getEmployee(theId);
		theModel.addAttribute("employee", theEmployee);
		if(theEmployee==null)
		{
			
			return "Invalid";
		}
		
		return "Viewemployee";
	}
	
	

}
