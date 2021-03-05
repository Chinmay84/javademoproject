package com.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.service.EmployeeService;



@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService; 
	
	@GetMapping(value="/",produces ="application/json")
	public List<Employee> forAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	@GetMapping(value="/{id}",produces="application/json")
	public Employee forEmployeeById(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}
	@DeleteMapping(value="/{id}",produces="application/json")
	public String forDeleteEmployee(@PathVariable("id") int id) {
		if(employeeService.deleteById(id)>0)
			return "delete successfully";
		else
			return "please check details";
	}
	@PostMapping(value="/",produces="application/json",consumes="application/json")
	public String forAddEmployee(@RequestBody Employee employee) {
		if(employeeService.save(employee)>0) {
			return "Adding Employee info Successfully ";
		}
		else {
			return "Please check info";
		}
	}
	@PutMapping(value="/",produces="application/json",consumes="application/json")
	public String forEditEmployee(@RequestBody Employee employee) {
		if(employeeService.update(employee)>0){
			return "{'message':'Adding employee info Succesfully'}";
		}
		else {
			return "{'message':'Please check creditanls'}";
		}
		
		
	}
}
