
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="post" >
            <form:hidden path="id" />
            <table>
                <tr><th>First name: </th><td><form:input path="firstName" /></td></tr>
                <tr><th>Last name: </th><td><form:input path="lastName"/></td></tr>
                <tr><th>Email: </th><td><form:input path="email" /></td></tr>
                <tr><th></th><td><input type="submit" value="Save" /></td></tr>
            </table>
        </form:form>
        <div style="clear: both;" ></div>
        <p><a href="${pageContext.request.contextPath}/customer/list" >Back to list</a></p>
    </div>
</body>
</html>
