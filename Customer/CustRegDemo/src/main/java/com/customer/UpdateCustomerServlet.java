package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String Phone = request.getParameter("Phone");
		String DateOfBirth = request.getParameter("DateOfBirth");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		boolean isSuccess;
		
		isSuccess = CustomerDButil.UpdateCustomer(id, Name, Address, Phone, DateOfBirth, Email, Password);
		
		if(isSuccess==true) {
			
			List<customer> customerDetails = CustomerDButil.getCustomerDetails(id);
			request.setAttribute("customerDetails", customerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("CustProfile.jsp");
			dis.forward(request, response);
		} else {
			List<customer> customerDetails = CustomerDButil.getCustomerDetails(id);
			request.setAttribute("customerDetails", customerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("CustProfile.jsp");
			dis.forward(request, response);
		}
		
	}

}
