package sever;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Tietext;

public class DataConnect {
	private List list;
	private static Statement stat;
	private static void init() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tieba"
				,"root","123456");
		stat = con.createStatement();
		
	}
	public static Statement getStatement() throws ClassNotFoundException, SQLException{
		if(stat==null)
			init();
		return stat;
	}
	
	

}
