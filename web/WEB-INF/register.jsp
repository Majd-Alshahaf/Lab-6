

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
       <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            <label>Username:</label>
            <input type="text" name="username" value="">
            <input type="submit" value="Register name">
            <input type="hidden" name="action" value="register">
   
            
        </form>
       <p>${message}</p>
    </body>
</html>
