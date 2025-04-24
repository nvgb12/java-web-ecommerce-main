<%-- 
    Document   : statics
    Created on : Feb 21, 2025, 11:57:36 PM
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
        <main style="height: 100vh; display: flex; justify-content: center; align-items: center; background-color: #1E3C60;">
    <div style="width: 50%; padding: 20px; border-radius: 10px; background-color: #f8f9fa; box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);">
        <h2 class="text-center">Thống kê</h2>
        <hr>
        <p><strong>Tổng lượng sản phẩm:</strong> ${numProducts}</p>
        <p><strong>Tổng lượng người dùng:</strong> ${numUsers}</p>
        <p><strong>Tổng lượng đặt hàng:</strong> ${numCarts}</p>
    </div>
</main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
