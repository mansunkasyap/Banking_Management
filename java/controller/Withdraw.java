package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.Bankaccount;
@WebServlet("/with_draw_amount")
public class Withdraw extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long acno = (long)req.getSession().getAttribute("acno");
		double enteredAmt = Double.parseDouble(req.getParameter("withdrawal"));
		BankDao bankDao = new BankDao();
		 Bankaccount bankaccount = bankDao.fetchByAccno(acno);
		 if(bankaccount.getAmmount() < enteredAmt) 
		 {
			 resp.getWriter().print("<h1> Insufficient Balance!!"+"Your Available Amount: "+bankaccount.getAmmount());
		 }
		 else {
			 if(enteredAmt > bankaccount.getAcc_limit()) {
				 resp.getWriter().print("<h1> Daily Limit Exeeding...."+
						 			"  Account Limit: "+ bankaccount.getAcc_limit());
			 }
			 else {
				 bankaccount.setAmmount(bankaccount.getAmmount()- enteredAmt);
				 resp.getWriter().print(enteredAmt + "Amount has been Withdrawn Sucessfully..");
				 bankDao.update(bankaccount);
			 }
		 }
		 
		
	}
}
