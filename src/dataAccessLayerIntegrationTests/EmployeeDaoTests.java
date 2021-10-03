package dataAccessLayerIntegrationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import dataAccessLayer.ConcreteEmployeeDao;
import dataAccessLayer.EmployeeDao;
import model.Employee;

class EmployeeDaoTests {

	DbConnection dbConnection = new DbConnection();

	@Test
	void readEmployeeTest() {

		EmployeeDao dao = new ConcreteEmployeeDao(dbConnection);

		List<Employee> test = dao.Read();

		assertNotNull(test);
		assertTrue(test.size() > 0);
	}
}
