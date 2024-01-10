package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.Bankaccount;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("adminemail");
		String password= req.getParameter("adminpassword");
		
		if(email.equals("admin@gmail.com") && password.equals("admin"))
		{
			resp.getWriter().println("<h1>Login Sucess<h1>");
			BankDao bankDao = new BankDao();
			List<Bankaccount> list = bankDao.fetch_All_Bank_Details();
			req.getSession().setAttribute("list", list);//because later in jsp we want whole table of all Customers
			req.getRequestDispatcher("Account_Home.jsp").include(req, resp);
		}
		else {
			resp.getWriter().println("<h1>Invalid credentials<h1>");
			req.getRequestDispatcher("admin.html").include(req, resp);
		}
	}
}
