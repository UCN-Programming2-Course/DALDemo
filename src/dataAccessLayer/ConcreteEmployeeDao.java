package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class ConcreteEmployeeDao implements EmployeeDao {

	private DataContext dataContext;

	public ConcreteEmployeeDao(DataContext dataContext) {
		this.dataContext = dataContext;

	}

	@Override
	public List<Employee> Read() {

		String sql = "SELECT ssn, fname, lname FROM Employee";

		List<Employee> result = new ArrayList<Employee>();

		try {
			Connection conn = dataContext.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setSsn(rs.getString(1));
				employee.setFname(rs.getString(2));
				employee.setLname(rs.getString(3));
				result.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee Read(String ssn) {
		String sql = "SELECT ssn, fname, lname FROM Employee WHERE Id = ?";

		Employee result = null;

		try {
			Connection conn = dataContext.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ssn);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				result = new Employee();
				result.setSsn(rs.getString(1));
				result.setFname(rs.getString(2));
				result.setLname(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int Create(Employee employee) {
		String sql = "INSERT INTO Employee (ssn, fname, lname) VALUES (?,?,?)";
		int result = 0;

		try {
			Connection conn = dataContext.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, employee.getSsn());
			statement.setString(2, employee.getFname());
			statement.setString(3, employee.getLname());
			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int Update(Employee employee) {
		String sql = "UPDATE Employee SET fname = ? , lname = ? WHERE ssn = ?";
		int result = 0;

		try {
			Connection conn = dataContext.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, employee.getFname());
			statement.setString(2, employee.getLname());
			statement.setString(3, employee.getSsn());
			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int Delete(Employee employee) {
		String sql = "DELETE FROM Employee WHERE ssn = ?";
		int result = 0;

		try {
			Connection conn = dataContext.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, employee.getSsn());

			result = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
