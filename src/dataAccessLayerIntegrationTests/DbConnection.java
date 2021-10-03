package dataAccessLayerIntegrationTests;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import dataAccessLayer.DataContext;

/*
 * Client specific implementation of the DataContext 
 * interface that should point to a test database
 * 
 */
public class DbConnection implements DataContext{

	private static final String serverName = "localhost\\sqlexpress";
	private static final String databaseName = "Company";
	private static final String username = "companyuser";
	private static final String password = "ThisIsALongPassword";	
	
	@Override
	public Connection getConnection() throws SQLException {
		
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser(username);
		ds.setPassword(password);
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		return ds.getConnection();
	}
}
