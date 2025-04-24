<%-- 
    Document   : register
    Created on : Feb 16, 2025, 1:23:03 AM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/register/register.css"/>
    </head>
    <body>
        <header><%@include file="header.jsp" %></header>
        <c:set var="res" value = "${requestScope.response}"/>
        <main>
            <section>
                <div class="login-container">
                    <h2>Đăng Kí</h2>
                    <form class="login-wrapper" action="RegisterHandler" method="post">
                        <div style="display: flex;flex-direction: row;gap:10px">
                            <label>
                                First name
                                <input type="text" name="firstName" placeholder="John" required>
                            </label>
                            <label>
                                Last name
                                <input type="text" name="lastName" placeholder="Smith" required>
                            </label>
                        </div>
                        <label>
                            Email
                            <input type="text" name="email" placeholder="abc@example.com" required>
                        </label>
                        <label>
                            Password
                            <input type="password" name="password" placeholder="Mật khẩu" required>
                        </label>
                        
                        <label>
                            Address
                            <input type="text" name="address" placeholder="American" required>
                        </label>
                        <label>
                            Gender
                            <select name="gender">
                                <option value=0>Male</option>
                                <option value=1>Female</option>
                                <option value=2>Unknow</option>
                            </select>
                        </label>
                        
                        <p style = "color: red">${res}</p>

                        <button class="button" type="submit">Đăng kí</button>
                        <button  class="button" type="button" onclick="window.location.href='LoginHandler'">Đăng nhập</button>  
                    </form>
                </div>
            </section>
        </main>
        <footer><%@include file="footer.jsp" %></footer>
    </body>
</html>
