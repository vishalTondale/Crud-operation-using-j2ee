package com.crud.DAO;

import java.util.List;

import com.crud.model.Employee;

public interface employeeBO {
	int insert (Employee e);
	int update(int id,String mail);
	int delete(int id);
	Employee get(int id);
	List<Employee> getAll();
}
