<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<div style = "position:relative; left:10px">
<form:form action="find" method="post">
    Search By: <input type="text" name="searchTerm" value="${searchTerm}">
    <input type ="submit" value="Search">
</form:form>

</div>


<h3><a href="newEmployee">New Employee</a></h3>

<table border="2" width="90%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Department</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${list}">
   <tr>
   <td>${emp.employeeId}</td>
   <td>${emp.firstName} ${emp.lastName}</td>
   <td>${emp.salary}</td>
   <td>${emp.department}</td>
   <td><a href="editemp?id=${emp.employeeId}">Edit</a></td>
   <td><a href="deleteemp/${emp.employeeId}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>