package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerInsert")
public class customerInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//save the entered values in jsp
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Phone = request.getParameter("Phone");
		String DateOfBirth = request.getParameter("DateOfBirth");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		boolean isCorrect;
		boolean isAvailable;
		
		isAvailable =CustomerDButil.validateInsert(Email);
		
		if(isAvailable == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Email is already in use.please enter anohter email');");
			out.println("location='customerinsert.jsp'");
			out.println("</script>");
			
		}else {
			
			isCorrect = CustomerDButil.insertCustomer(Name, Address, Phone, DateOfBirth, Email, Password);
			
			if(isCorrect == true) {
				
				List<customer> customerDetails = CustomerDButil.getCustomer(Name);
				request.setAttribute("customerDetails", customerDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("visitprof.jsp");
				dis.forward(request, response);
			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Insertion was unsuccesful.Please enter your details again.');");
				out.println("location='customerinsert.jsp'");
				out.println("</script>");
			}
		}
		
	}

	
}
