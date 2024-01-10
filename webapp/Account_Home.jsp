<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="dto.Bankaccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Account Home</title>
<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
  }

  h1 {
    color: #3498db;
  }

  table {
    border-collapse: collapse;
    width: 80%;
    margin-top: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
  }

  th {
    background-color: #3498db;
    color: #fff;
    border-radius: 5px;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  a button {
    background-color: #e74c3c;
    color: #fff;
    border: none;
    border-radius: 4px;
    padding: 8px 16px;
    text-decoration: none;
    cursor: pointer;
  }

  a button:hover {
    background-color: #c0392b;
  }
</style>
</head>
<body>
  <h1>Welcome to Account Home</h1>

  <% List<Bankaccount> list = (List<Bankaccount>)request.getSession().getAttribute("list"); %>
  <table>
    <tr>
      <th>Account Number</th>
      <th>Account Type</th>
      <th>Balance</th>
      <th>Account Limit</th>
      <th>Account Status</th>
      <th>Customer Name</th>
      <th>Customer Id</th>
      <th>Change Status</th>
    </tr>

    <% for(Bankaccount bankaccount: list){ %>
      <tr>
        <td><%= bankaccount.getAcc_no() %></td>
        <td><%= bankaccount.getAccount_type() %></td>
        <td><%= bankaccount.getAmmount() %></td>
        <td><%= bankaccount.getAcc_limit() %></td>
        <td><%= bankaccount.isStatus() %></td>
        <td><%= bankaccount.getCustomer().getName() %></td>
        <td><%= bankaccount.getCustomer().getCustId() %></td>
        <td><a href="changestatus?acno=<%= bankaccount.getAcc_no() %>"><button>Change Status</button></a></td>
      </tr>
    <% } %>
  </table>
</body>
</html>
