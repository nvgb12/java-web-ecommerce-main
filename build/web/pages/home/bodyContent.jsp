</-- 
    Document   : bodyContent
    Created on : Feb 12, 2025, 5:28:49 PM
    Author     : HOME PC
--/>

</@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" />
</@page contentType="text/html" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/bodyContent.css"/>
    </head>
    <body>
        <div class = "container-fluid">
            <c:set var="productList" value="${data.get(0)}" scope="request"/>
            <div class="row text-center">
                <h1 class="h1">Featured Product</h1>
                <p>
                   A collection of our fearured Product.
                </p>
            </div>
            <div class="row"><jsp:include page="displayList.jsp" /></div>
        </div>
        <div class = "container-fluid bg-dark text-light py-5">
            <c:set var="productList" value="${data.get(1)}" scope="request"/>
            <div class="row text-center">
                <h1 class="h1">Luxury Product</h1>
                <p>
                    Product from well known brand.
                </p>
            </div>
            <div class="row"><jsp:include page="displayList.jsp" /></div>
        </div>
        <div class = "container-fluid ">
            <c:set var="productList" value="${data.get(2)}" scope="request"/>
            <div class="row text-center">
                <h1 class="h1">Most bought Product</h1>
                <p>
                   The highest-demand product among customers.
                </p>
            </div>
            <div class="row"><jsp:include page="displayList.jsp" /></div>
        </div>
    </body>
</html>
