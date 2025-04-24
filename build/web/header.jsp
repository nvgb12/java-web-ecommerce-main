    <%-- 
    Document   : header
    Created on : Feb 7, 2025, 2:07:44 AM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRJ</title>
        <link rel="stylesheet" href="./CSS/header.css"/>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <!-- Bootstrap JS (tùy chọn, nếu cần dùng JS của Bootstrap) -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <c:set var="userData" value="${sessionScope.userData}"/>
        <div id ="header-container" class = "container-fluid">
            <div class ="row main-header">
                <div class="col-3">
                    <h1><a href="Home">PRJ</a></h1>
                </div>
                <form action="Search" method="get" class="col-6 flex-row">
                    <p class="a text-center"><a href="Search">Top List</a></p>
                    <input title="search" class="form-control form-control-sm search" type="text" placeholder="Search" name="title"/>
                    <button id="search" title="search" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
                <div class ="col-3 flex-row">
                    <c:if test="${userData == null}">
                        <div class="btn btn-primary"><a href="LoginHandler">Login</a></div>
                        <div class="btn btn-secondary"><a href="RegisterHandler">Register</a></div>
                    </c:if>
                    <c:if test="${userData != null}">
                        <div style="color: red;">hi ${userData.getFirstName()}</div>
                        <div onclick="avatarOnClick()" id="avatar"></div>
                    </c:if>
                    <ul id="menu" style="display: none">
                        <li><a href="UpdateUser?id=${userData.getId()}"><i class="fa-solid fa-circle-info"></i> User information</a></li>
                        <li><a href="Cart"><i class="fa-solid fa-cart-shopping"></i> Cart</a></li>
                                <c:if test="${sessionScope.userData.getRole()==1}">
                            <li><a href="GetAllUser"><i class="fa-solid fa-bars-progress"></i> User management</a></li>
                            <li><a href="Statics"><i class="fa-solid fa-square-poll-vertical"></i> Statics</a></li>
                            </c:if>
                        <li><a href="LogOut"><i class="fa-solid fa-right-from-bracket"></i> Log out</a></li>
                    </ul>
                </div>
            </div>
            
        </div>
        <script src="<%= request.getContextPath()%>/JS/header.js" ></script>
    </body>
</html>
