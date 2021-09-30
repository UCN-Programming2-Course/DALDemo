package dataAccessLayer;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	List<Employee> Read();
	Employee Read(String ssn);
	int Create(Employee customer);
	int Update(Employee customer);
	int Delete(Employee customer);
}
