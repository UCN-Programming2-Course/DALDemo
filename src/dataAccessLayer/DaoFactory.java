package dataAccessLayer;

public class DaoFactory {

	public static EmployeeDao createEmployeeDao(DataContext dbConnection) {
		return new EmployeeDaoImpl(dbConnection);
	}
}
