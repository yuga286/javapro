package com.yd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

//import com.sun.tools.classfile.Opcode.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet{

	private static final String GET_EMP_INFO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WEHER EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	//set response content type
		res.setContentType("text/html");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//read form data
		int eno=Integer.parseInt(req.getParameter("eno"));
		//write jdbc code
		Connection con=null;
	PreparedStatement ps =null;
	ResultSet rs =null;
	try {
		//Load jdbc driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe","system","yugandhara");
		//create jdbc Statement object
		ps=con.prepareStatement(GET_EMP_INFO);
		//ser IN param values
		ps.setInt(1, eno);
		//execute the SQL
		rs=ps.executeQuery();
		//process the ResultSet
		if(rs.next()) {
			pw.println("<h1 style='color:red;text-align:center'>"+eno+"Employee Details are</h1>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr><td>Empno::</td><td>"+rs.getInt(1)+"</td></tr>");
			pw.println("<tr><td>Emp Name::</td><td>"+rs.getString(2)+"</td></tr>");
			pw.println("<tr><td>Emp Desg::</td><td>"+rs.getString(3)+"</td></tr>");
			pw.println("<tr><td>Emp Salary::</td><td>"+rs.getFloat(3)+"</td></tr>");
			pw.println("</table>");
		}//if
		else {
			pw.println("<h1 style='color:red;text-align:center'>Employee Details are not found</h1>");
		}
		
	}
	catch(SQLException se) {
		se.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Problem in  DB Interaction</h1>");
	}
	catch(Exception e) {
		e.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Unknown Problem</h1>");
	}
	finally {
	//close jdbc objs
		try {
			if(rs!=null)
				rs.close();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
			con.close();
		}
		catch(SQLException se) {
		se.printStackTrace();
		}
	}//finally
	//add home hyperlink
	pw.println("<h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
	
	//close stream
	pw.close();
	
	}//doGet(-,-)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		doPost(req, res);
	}
	
}
