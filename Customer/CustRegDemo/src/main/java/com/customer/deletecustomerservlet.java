package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecustomerservlet")
public class deletecustomerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isSuccess ;
		
		isSuccess = CustomerDButil.deletecustomer(id);
		
		if(isSuccess == true) {
			RequestDispatcher dispatch = request.getRequestDispatcher("customerinsert.jsp");
			dispatch.forward(request, response);
		}
		else {
			List<customer> cusDetails = CustomerDButil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("CustProfile.jsp");
			dispatch.forward(request, response);
		}
		
	}

}
