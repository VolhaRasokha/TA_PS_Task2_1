package by.epam.ta.ps.task2_1.service.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.ta.ps.task2_1.entity.Candy;
import by.epam.ta.ps.task2_1.entity.Sweets;

public class ReadFromDB implements Readable{
	
    
    
    
	@Override
	public List<Sweets> read() throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/candy"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
	    final String user = "root";
	    final String password = "root";
	    
	    List<Sweets> readResult = new ArrayList<Sweets>();
	    
		String query = "select sweetsName, sweetsWeight, sweetsCount, sweetsManufacturer, sweetsCandyType from candy";
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			   Candy myCandy = new Candy();
			   myCandy.setSweetName(rs.getString(1));
			   myCandy.setWeight(rs.getDouble(2));
			   myCandy.setCount(rs.getInt(3));
			   myCandy.setManufacturer(rs.getString(4));
			   myCandy.setCandyType(rs.getString(5));
			 
			   readResult.add(myCandy);
			 }
		con.close();
		stmt.close();
		rs.close();

		
		return readResult;
	}
	

}
