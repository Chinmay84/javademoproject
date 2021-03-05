package com.demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.bean.Employee;
import com.demo.springboot.dao.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao; 

	public List<Employee> findAllEmployee() {

		return employeeDao.findAllEmployee();
	}

	public Employee getEmployeeById(int id) {
		
		return employeeDao.getEmployeeById(id);
	}

	public int save(Employee employee) {
		
		return employeeDao.save(employee);
	}

	public int update(Employee employee) {
		
		return employeeDao.update(employee);
	}

	public int deleteById(int id) {

		return employeeDao.deleteById(id);
	}

	public Employee getEmployeeByName(String fName) {
		
		return employeeDao.getEmployeeByName(fName);
	}

}
