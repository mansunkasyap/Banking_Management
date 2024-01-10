package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dao.CustomerDao;
import dto.Bankaccount;
import dto.Customer;

@WebServlet("/createbankaccount")
public class Create_Bank_Account extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String banktype = req.getParameter("banktype");//fetching from radio button
		Customer curr_customer = (Customer) req.getSession().getAttribute("customer");
		List<Bankaccount> list1 = curr_customer.getList();
		boolean indicator = true;
		for (Bankaccount bankaccount : list1) {
			if (bankaccount.getAccount_type().equals(banktype)) {
				resp.getWriter().print("<h1>Already have an account");
				indicator = false;
			}
		}
		if (indicator == true) {
			Bankaccount bankaccount = new Bankaccount();
			bankaccount.setAccount_type(banktype);

			if (bankaccount.getAccount_type().equals("savings"))
				bankaccount.setAcc_limit(10000);
			else
				bankaccount.setAcc_limit(15000);

			bankaccount.setCustomer(curr_customer);
			BankDao bankDao = new BankDao();
			bankDao.save(bankaccount);// Calling Save()
			List<Bankaccount> list2 = list1;
			list2.add(bankaccount);
			curr_customer.setList(list2);

			CustomerDao customerDao = new CustomerDao();
			customerDao.update(curr_customer);
			resp.getWriter().print("<h1> Account created Successfully<h1>");
		}
	}
}