<%-- 
    Document   : resetPassword
    Created on : Feb 16, 2025, 2:20:31 AM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/login/login.css"/>
    </head>
    <body>
        <header><%@include file="header.jsp" %></header>
        <main>
            <c:set var="res" value = "${response}"/>
            <section>
                <div class="login-container">
                    <h2>Reset Password</h2>
                    <form class="login-wrapper" action="ResetPasswordHandler" method="post">
                        <label>
                            Email
                            <input type="text" name="email" placeholder="abc@examle.com" required>
                        </label>
                        <label>
                            Password
                            <input type="password" name="password" placeholder="Mật khẩu" required>
                        </label>
                        <label>
                            Confirm password
                            <input type="password" name="confirmPassword" placeholder="Mật khẩu" required>
                        </label>
                        <c:if test="${isSuccess == true}">
                            <p style="color:green">${res}</p>
                        </c:if>
                        <c:if test="${isSuccess != true}">
                            <p style="color:red">${res}</p>
                        </c:if>
                        <button class="button" type="submit">Reset Password</button>
                        <button class="button" type="button" onclick="window.location.href='LoginHandler'">Return</button>  
                    </form>
                </div>
            </section>
        </main>
        <footer><%@include file="footer.jsp" %></footer>
    </body>
</html>
