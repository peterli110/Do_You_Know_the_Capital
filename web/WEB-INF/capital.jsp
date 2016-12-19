<%-- 
    Document   : capital
    Created on : 2016-11-30, 19:14:30
    Author     : PeterLi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capital Page</title>
    </head>
    <body>
        <form action="CapitalServlet" method="post">
            What is the capital of <%= session.getAttribute("question") %>? <input type="text" name="capital_name" value="" >
            <input type="submit" name="action" value="Submit">
        </form>
    </body>
</html>
