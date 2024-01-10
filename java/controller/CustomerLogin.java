package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;
@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Long custid = Long.parseLong(req.getParameter("custid"));
		String pwd = req.getParameter("pwd");
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.fetchById(custid);
		
		if(customer == null) {
			resp.getWriter().println("<h1>You have entered Invalid credentials<h1>");
			req.getRequestDispatcher("customerLogin.html").include(req, resp);
		}
		else { 
			if(customer.getPwd().equals(pwd)) 
			{
				resp.getWriter().println("<h1>Login Success<h1>");
				req.getSession().setAttribute("customer", customer);
											// Key ---->  Value 
				req.getRequestDispatcher("customerhome.html").include(req, resp);//redirect to home page
			}
			else {
				resp.getWriter().println("<h1>Wrong Password!!");
				req.getRequestDispatcher("customerLogin.html").include(req, resp);
			}
		}
		
	}
	
}
