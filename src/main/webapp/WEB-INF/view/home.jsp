<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.patrycja.util.Mappings" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo List App</title>
</head>
<body>
<div align="center">
    <c:url var="animalsLink" value="${Mappings.ANIMALS}"/>
    <h2><a href="${animalsLink}">Show animals</a></h2>

</div>

</body>
</html>