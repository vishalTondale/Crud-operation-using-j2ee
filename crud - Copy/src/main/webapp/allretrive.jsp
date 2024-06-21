<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.crud.model.Employee"
	import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<title>Employee Data</title>
<style>
body {
	padding: 50px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h2>Employee Data</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Mobile Number</th>
				<th>Designation</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<% 
        List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
        for (Employee employee : employeeList) { 
      %>
			<tr>
				<td><%= employee.getId() %></td>
				<td><%= employee.getName() %></td>
				<td><%= employee.getGender() %></td>
				<td><%= employee.getMail() %></td>
				<td><%= employee.getMobileNumber() %></td>
				<td><%= employee.getDesignation() %></td>
				<td><%= employee.getSalary() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<br>
	<br>
	<a href="options.html">
		<button
			style="display: inline-block; padding: 8px 16px; background-color: #4CAF50; color: white; text-align: center; text-decoration: none; border: none; border-radius: 4px; cursor: pointer;">Home
			Page</button>
	</a>


</body>
</html>
