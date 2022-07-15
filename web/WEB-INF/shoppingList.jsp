<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>

        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?action=logout">Logout</a>

        <h2>List</h2>


        <form action="" method="post">             
            <label>Add item:</label>
            <input type="text" name="itemName" value="">
            <input type="submit" value="Add"> 
            <input type="hidden" name="action" value="add">

        </form>
        <form action="ShoppingList" method="post">
            <c:forEach var="item" items="${items}" >
                <input type="radio" name="itemDelete" value="${item}">
                <label>${item}</label>

            </c:forEach>

            <c:if test="${items != null}">
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
            </c:if>
        </form>




    </body>
</html>
