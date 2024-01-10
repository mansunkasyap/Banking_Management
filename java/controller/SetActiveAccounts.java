package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectactiveaccount")
public class SetActiveAccounts extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc = req.getParameter("acno");
		long acno = Long.parseLong(acc);
		req.getSession().setAttribute("acno", acno);
		req.getRequestDispatcher("Transaction.jsp").include(req, resp);
	}
}
