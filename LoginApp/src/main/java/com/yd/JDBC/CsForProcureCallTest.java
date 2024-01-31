package com.yd.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class CsForProcureCallTest {

	private static final String CALL_PROCEDURE="{call first_pro(?,?)}";
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yugandhara");
				java.sql.CallableStatement cs=con.prepareCall(CALL_PROCEDURE); 
				){
			//read input values
			int no=0;
			if(sc!=null) {
				System.out.println("Enter number::");
				no=sc.nextInt();
			}//if
			if(cs!=null) {
			//register output params 
			cs.registerOutParameter(2,java.sql.Types.INTEGER);
			//set value to In params
			cs.setInt(1,no);
			//call PL/SQL procedure
			cs.execute();
			//gether results from OUT param
			int result=cs.getInt(2);
			System.out.println("Square value::"+result);
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
	
	}
}
