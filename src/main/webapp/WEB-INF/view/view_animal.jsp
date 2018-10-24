<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.patrycja.util.Mappings" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Animal</title>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value="${animal.id}"/>
            </td>
        </tr>
        <tr>
            <td><label>Name</label></td>
            <td>
                <c:out value="${animal.name}"/>
            </td>
        </tr>
        <tr>
            <td><label>Type</label></td>
            <td>
                <c:out value="${animal.type}"/>
            </td>
        </tr>
        <tr>
            <td><label>Description</label></td>
            <td>
                <c:out value="${animal.description}"/>
            </td>
        </tr>

    </table>
    <c:url var="tableUrl" value="${Mappings.ANIMALS}"/>
    <a href="${tableUrl}">Show Table</a>

</div>

</body>
</html>