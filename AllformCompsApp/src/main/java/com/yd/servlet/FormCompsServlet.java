package com.yd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormCompsServlet extends HttpServlet{
@Override
public void doGet(HttpServletResquest req,HttpServletResponse res)throws ServletExcetion, IOExcetion
//get PrintWriter
PrintWriter pw=res.getWriter();
//set response content type
// res.setContentType("text/html");
//read form data
string name=req.getParameter("pname");
int age=Integer.parseInt(req.getParameter("page"));
string addrs=req.getParameter("paddrs");
string ms=req.getParameter("ms");
string gender=req.getParameter("gender");
string qlfy=req.getParameter("qlfy");
string courses[]=req.getParametervalue("crs");
string mail=req.getParameter("email");
string dob=req.getParameter("dob");
string tob=req.getParameter("tob");
string wob=req.getParameter("wob");
string fbUrl=req.getParameter("fbUrl");
long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
string favNo=Integer.parseInt(req.getParameter("favNo"));
string favColor=req.getParameter("favColor");
string favColor=req.getParameter("favColor");
string favColor=req.getParameter("favColor");

}
