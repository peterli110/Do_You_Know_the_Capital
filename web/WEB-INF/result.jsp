<%-- 
    Document   : result
    Created on : 2016-11-30, 19:15:01
    Author     : PeterLi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <form action="CapitalServlet" method="post">
            <%=session.getAttribute("outcome")%><br>
            <input type="submit" name="action" value="Next">
        </form>
    </body>
</html>
