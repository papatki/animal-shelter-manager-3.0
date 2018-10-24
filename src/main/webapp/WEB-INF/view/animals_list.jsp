
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.patrycja.util.Mappings" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo Items</title>
</head>
<body>
    <div align="center">
        <c:url var="addUrl" value="${Mappings.ADD_ANIMAL}"/>
        <a href="${addUrl}">Add new animal</a>
        <table border="1" cellpadding="5">
            <caption><h2>Animals in the Shelter</h2></caption>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>View</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="animal" items="${animalData.animals}">

                <c:url var="viewUrl" value="${Mappings.VIEW_ANIMAL}">
                        <c:param name="id" value="${animal.id}"/>
                </c:url>
                <c:url var="editUrl" value="${Mappings.ADD_ANIMAL}">
                    <c:param name="id" value="${animal.id}"/>
                </c:url>

                <c:url var="deleteUrl" value="${Mappings.DELETE_ANIMAL}">
                    <c:param name="id" value="${animal.id}"/>
                </c:url>

                <tr>
                    <td><c:out value="${animal.name}"/></td>
                    <td><c:out value="${animal.type}"/></td>
                    <td><a href="${viewUrl}">View</a> </td>
                    <td><a href="${editUrl}">Edit</a> </td>
                    <td><a href="${deleteUrl}">Delete</a> </td>
                </tr>
            </c:forEach>

        </table>
    </div>

</body>
</html>