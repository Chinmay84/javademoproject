package com.demo.springboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.springboot.bean.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	private class EmployeeRowMapper implements RowMapper<Employee>{

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setFirstName(rs.getString("fName"));
			e.setLastName(rs.getString("lName"));
			return e;
		}
		
	}

	public List<Employee> findAllEmployee() {
		
		return jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
	}

	public Employee getEmployeeById(int id) {
		
		return jdbcTemplate.queryForObject("select * from employee where id=?", new Object[] {id}, new EmployeeRowMapper());
	}

	public int save(Employee employee) {

		return jdbcTemplate.update("insert into employee(id,fName,lName) value(?,?,?)", new Object[] {employee.getId(),employee.getFirstName(),employee.getLastName()});
	}

	public int update(Employee employee) {
		
		return jdbcTemplate.update("update employee set fName=?,lName=? where id=?", new Object[] {employee.getFirstName(),employee.getLastName(),employee.getId()});
	}

	public int deleteById(int id) {
		
		return jdbcTemplate.update("delete from employee where id=?", new Object[] {id});
	}

	public Employee getEmployeeByName(String fName) {
		
		return jdbcTemplate.queryForObject("select * from employee where fName=?", new Object[] {fName}, new EmployeeRowMapper());
	}

}
