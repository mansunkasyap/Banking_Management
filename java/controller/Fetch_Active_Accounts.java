package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CustomerDao;
import dto.Bankaccount;
import dto.Customer;
@WebServlet("/fetchActiveAccounts")
public class Fetch_Active_Accounts extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Helloo fetch all accounts");
		Customer customer = (Customer)req.getSession().getAttribute("customer");
		List<Bankaccount> list = customer.getList();
		List<Bankaccount> list2 = new ArrayList<Bankaccount>();
		for (Bankaccount bankaccount : list) {
			if(bankaccount.isStatus())
			{
				list2.add(bankaccount);
				resp.getWriter().print("<h1> Active acccount");
			}
			else
			{
				resp.getWriter().print("<h1> Not Active acccount");
			}
		} 
		
		req.getSession().setAttribute("activelist", list2);
		req.getRequestDispatcher("Accounts.jsp").include(req, resp);
	}
}
