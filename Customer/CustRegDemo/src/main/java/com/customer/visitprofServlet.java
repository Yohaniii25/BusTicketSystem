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

@WebServlet("/visitprofServlet")
public class visitprofServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String Email = request.getParameter("Email");
		String password = request.getParameter("Password");
		boolean isTrue;
		
		isTrue = CustomerDButil.validateVisit(Email, password);
		
		if (isTrue == true) {
			List<customer> customerDetails = CustomerDButil.getCustomer(Email);
			request.setAttribute("customerDetails", customerDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("CustProfile.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your email or password is incorrect');");
			out.println("location='visitprof.jsp'");
			out.println("</script>");
		}
	}

}
