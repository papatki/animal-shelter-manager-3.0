
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.patrycja.util.AttributeNames" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Items</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${AttributeNames.ANIMAL}">
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td>
                        <form:input path="id" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><label>Type</label></td>
                    <td><form:input path="type"/></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><form:textarea path="description"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>

        </form:form>
    </div>
</body>
</html>