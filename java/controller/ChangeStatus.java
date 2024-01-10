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
@WebServlet("/changestatus")
public class ChangeStatus extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Change Status Class.........");
		String acno = req.getParameter("acno");
		System.out.println(acno);
		long acc = Long.parseLong(acno);
		BankDao dao = new BankDao();
		Bankaccount bankaccount = dao.fetchByAccno(acc);
		if(bankaccount.isStatus()) {
			System.out.println("Status: "+bankaccount.isStatus());
			bankaccount.setStatus(false);
		}else {
			System.out.println(bankaccount.isStatus());
			bankaccount.setStatus(true);
		} 
		dao.update(bankaccount);
		List<Bankaccount>listAll = dao.fetch_All_Bank_Details();
		req.getSession().setAttribute("list", listAll);
		req.getRequestDispatcher("Account_Home.jsp").include(req, resp);
		resp.getWriter().print("<h1>"+bankaccount.getAcc_no()+" Status change Sucessfully<h1>");
	}
}
