package com.yd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MarriageElgibilityCheckServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		System.out.println("Hi");
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//read form data
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String gen=req.getParameter("gender");
		
		//write b.logic
		if(gen.equalsIgnoreCase("M")) {
			if(age>=21)
			{
			pw.println("<h1 style='color:green;text-align:center'>Mr."+name+"ur eligiable for marriage but think twice</h1>");
				}
			else {
			pw.println("<h1 style='color:blue;text-align:center'>Mr."+name+"ur not eligiable for marriage...be happy</h1>");
			
			}
		}
		else {
			if(age>=20)
			{
			pw.println("<h1 style='color:green;text-align:center'>Mr."+name+"ur eligiable for marriage but think twice</h1>");
				}
			else {
			pw.println("<h1 style='color:blue;text-align:center'>Mr."+name+"ur not eligiable for marriage ...be happy</h1>");
		} //end else
		
		} 
			pw.println("<br><br><a href='http://localhost:8080/MarriageApp/input.html'><'image src='image/home.jpg'></a>");
		pw.close();
}
	
}