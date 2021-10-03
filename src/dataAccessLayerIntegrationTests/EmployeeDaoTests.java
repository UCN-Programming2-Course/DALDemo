package dataAccessLayerIntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import dataAccessLayer.EmployeeDaoImpl;
import dataAccessLayer.EmployeeDao;
import model.Employee;

class EmployeeDaoTests {

	DbConnection dbConnection = new DbConnection();

	@Test
	void readEmployeeTest() {

		EmployeeDao dao = new EmployeeDaoImpl(dbConnection); // NOTE! This is tight coupled, use Factory Pattern instead

		List<Employee> test = dao.Read();

		assertNotNull(test);
		assertTrue(test.size() > 0);
	}
}
