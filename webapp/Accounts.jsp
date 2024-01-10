<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="dto.Bankaccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome_to_Accounts</h1>
	<%
		List<Bankaccount> activeList = (List<Bankaccount>) request.getSession().getAttribute("activelist");
		if (activeList.isEmpty()) {%>
			<h1>No Active Accounts......</h1>
			<%} 
		else{%>

			<%for(Bankaccount bankaccount: activeList) {%>
					
					<a href="selectactiveaccount?acno=<%= bankaccount.getAcc_no()%>">
					<button><%= bankaccount.getAcc_no()%></button>
					</a>
				
				<%} 
			%>

 

		<%}
		
	%>
</body>
</html>