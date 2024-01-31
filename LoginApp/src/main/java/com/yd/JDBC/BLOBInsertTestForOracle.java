package com.yd.JDBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BLOBInsertTestForOracle {

	private static final String INSERT_ACTOR_QUERY="INSERT INTO JDBC_ACTOR_TAB VALUES(ACTORID_SEQ.NEXTVAL,?,?,?)";
	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}  
		try(Scanner sc=new Scanner(System.in);
				//Class.forName("com.mysql.jdbc.Driver");  
				//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yugandhara");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/images","root","yugandhara");
				PreparedStatement ps=con.prepareStatement(INSERT_ACTOR_QUERY);
				){
			String actorName=null,actorAddres=null,actorPhoto=null;
			if(sc!=null) {
				System.out.println("Enter actor name::");
				actorName=sc.next();
				System.out.println("Enter actor address::");
				actorAddres=sc.next();
				System.out.println("Enter photo location::");
				actorPhoto=sc.next().replace('?', ' ').trim();
			}
			//create Stream pointing to Photo file
			InputStream is=new FileInputStream(actorPhoto);
			
			//set query param values
			if(ps!=null) {
			ps.setString(1, actorName);
			ps.setString(2, actorAddres);
			ps.setBinaryStream(3, is);
			}
			//execute the Query
			int count=0;
			if(ps!=null)
				count=ps.executeUpdate();
			//process the Result
			if(count==0) 
				System.out.println("Record not inserted");
			else {
				System.out.println("Record inserted");
			}
		}
			catch (SQLException se) {
				se.printStackTrace();
			}
			catch(Exception ec) {
				ec.printStackTrace();
			}
		
	}
}
