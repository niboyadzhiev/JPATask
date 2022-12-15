<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>Edit Employee</h1>
		<form:form action="saveemp" method="post" modelAttribute="employee">
		<table>
			<form:hidden path="employeeId"/>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
            	<td>Last Name:</td>
            	<td><form:input path="lastName" /></td>
            </tr>
			<tr>
				<td>Salary:</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
            	<td>Department:</td>
            	<td><form:input path="department" />
            	</td>
            </tr>

				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
			<tr>
			    <td> <span style="color:red;">${message}</span></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>