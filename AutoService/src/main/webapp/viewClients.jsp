<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Clients</title>
</head>
<body>
<h2>View Clients</h2>
<ul>
    <c:forEach var="client" items="${clients}">
        <li>
            Client #${client.clientId}: ${client.lastName}, ${client.firstName} ${client.middleName}<br>
            Contact Phone: ${client.contactPhone}<br>
        </li>
    </c:forEach>
</ul>
<a href="createClient.jsp">Create New Client</a><br>
<a href="deleteClient.jsp">Delete Client</a><br>

</body>
</html>