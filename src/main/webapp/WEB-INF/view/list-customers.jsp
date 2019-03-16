<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false" />
    <div id="content">
        <table>
            <tr>
                <th>First name</th><th>Last Name</th><th>Email</th><th>Action</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customers}">

                <%--construct an update link with customer id--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <%--construct an delete link with customer id&ndash;%&gt;--%>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="${updateLink}">Update</a> |
                        <a href="${deleteLink}" onclick="if( !(confirm('sure to delete?'))) return false;">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>