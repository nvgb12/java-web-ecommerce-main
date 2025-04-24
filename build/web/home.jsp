<%-- 
    Document   : home
    Created on : Feb 7, 2025, 2:08:38 AM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header><%@include file="header.jsp" %></header>
        <main>
            <section>
                <%@include file="./pages/home/bodyBanner.jsp" %>
            </section>
            <section>
                <%@include file="./pages/home/bodyContent.jsp"%>
            </section>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
