package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.Bankaccount;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost of Deposit Class..");
		long acno = (long)req.getSession().getAttribute("acno");
		double amt = Double.parseDouble(req.getParameter("amt"));
		BankDao bankDao = new BankDao();
		 Bankaccount bankaccount = bankDao.fetchByAccno(acno);
		 System.out.println("Account Number: "+ acno);
		 bankaccount.setAmmount(amt + bankaccount.getAmmount());
		 bankDao.update(bankaccount);
	}
}
