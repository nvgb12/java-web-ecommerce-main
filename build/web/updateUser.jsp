<%-- 
    Document   : updateUser
    Created on : Feb 19, 2025, 4:58:53 PM
    Author     : HOME PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/CSS/register/register.css"/>
    </head>
    <body>
        <c:set var="res" value="${response}"/>
        <c:set var="user" value="${user}"/>
        <header><%@include file="header.jsp" %></header>
        <section>
                <div class="login-container">
                    <h2>Update</h2>
                    <form class="login-wrapper" action="UpdateUser?id=${user.getId()}" method="post">
                        <div style="display: flex;flex-direction: row;gap:10px">
                            <label>
                                First name
                                <input value="${user.getFirstName()}" type="text" name="firstName" placeholder="John" required>
                            </label>
                            <label>
                                Last name
                                <input value="${user.getLastName()}" type="text" name="lastName" placeholder="Smith" required>
                            </label>
                        </div>
                        <label>
                            Email
                            <input value="${user.getEmail()}" type="text" name="email" placeholder="abc@example.com" required>
                        </label>
                        
                        <label>
                            Address
                            <input value="${user.getAddress()}" type="text" name="address" placeholder="American" required>
                        </label>
                        <label>
                            Gender
                            <select name="gender">
                                <option <c:if test="${user.gender == 0}">selected</c:if> value=0>Male</option>
                                <option <c:if test="${user.gender == 1}">selected</c:if> value=1>Female</option>
                                <option <c:if test="${user.gender == 2}">selected</c:if>value=2>Unknow</option>
                            </select>
                        </label>
                        
                        <p style = "color: red">${res}</p>

                        <button class="button" type="submit">Update</button> 
                    </form>
                </div>
            </section>
        <footer><%@include file="footer.jsp"%></footer>
    </body>
</html>
