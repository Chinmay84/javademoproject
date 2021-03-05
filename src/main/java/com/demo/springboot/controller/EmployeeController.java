package com.demo.springboot.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.service.EmployeeService;



@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService ;
	
	@RequestMapping("/showEmployee")
	public String forShowEmployee(ModelMap map) {
		
		map.addAttribute("elist", employeeService.findAllEmployee());
		return "dispalyemployee";
		
	}
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String forAddEmployee(ModelMap map) {
		map.addAttribute("command", new Employee());
		return "addemployee";
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String forSaveEmployee( @ModelAttribute("command") Employee employee, BindingResult result, ModelMap map) {
		if(result.hasErrors()) {
			return "addemployee";
		}
		else {
			employeeService.save(employee);
			return "redirect:/showEmployee";
		}
		
	}
	@RequestMapping(value="/editemployee/{id}",method=RequestMethod.GET)
	public String forEditEmployee(@PathVariable("id") int id,ModelMap map) {
		map.addAttribute("command",employeeService.getEmployeeById(id));
		return "editemployee";
	}
	@RequestMapping(value="/editemployee/{id}",method=RequestMethod.POST)
	public String forEditEmployee( @ModelAttribute("command") Employee employee, @PathVariable("id") int id,BindingResult result, ModelMap map) {
		if(result.hasErrors())
			return "editemployee";
		else
		{employeeService.update(employee);
			return "redirect:/showEmployee";
	}
}
	@GetMapping("/deleteemployee/{id}")
	public String forDeleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/showEmployee";
	}
}
