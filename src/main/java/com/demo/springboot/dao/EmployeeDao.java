package com.demo.springboot.dao;

import java.util.List;

import com.demo.springboot.bean.Employee;



public interface EmployeeDao {

	List<Employee> findAllEmployee();

	Employee getEmployeeById(int id);

	int save(Employee employee);

	int update(Employee employee);

	int deleteById(int id);

	Employee getEmployeeByName(String fName);

}
