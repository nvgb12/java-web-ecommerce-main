<%-- 
    Document   : productDetail
    Created on : Feb 20, 2025, 6:31:07 PM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/productDetail.css"/>
    </head>
    <body>
        <header><%@include file="header.jsp" %></header>
        <section class="container-fluid">
            <c:set var="product" value="${product}"/>
            <div class="row d-flex justify-content-center flex-row my-4">
                <div class="col-3">
                    <img class="product-image" src="<%=request.getContextPath()%>/assets/products/${product.getImageURL()}" alt="product image"/>
                </div>
                <div class="col-4 d-flex flex-column gap-3">
                    <div class="detail">
                        <span><strong>Tên: </strong></span><span>${product.getTitle()}</span>
                    </div>
                    <div class="detail">
                        <span><strong>Brand: </strong></span><span>${product.getBrand()}</span>
                    </div>
                    <div class="detail">
                        <span><strong>Color: </strong></span><span>${product.getColor()}</span>
                    </div>
                    <div class="detail">
                        <span><strong>Size: </strong></span><span>${product.getSize()}</span>
                    </div>
                    <div class="detail">
                        <span><strong>Type: </strong></span><span>${product.getType()}</span>
                    </div>

                    <div class="detail">
                        <span><strong>Release Date: </strong></span><span>${product.getReleaseDate()}</span>
                    </div>
                    <div class="detail" style="color:red">
                        <span><strong>Price: </strong></span><span>${product.getPrice()}</span>
                    </div>
                    <form action="ProductDetail?userId=${sessionScope.userData.getId()}&productId=${product.getId()}" method="post">
                        <button class="btn btn-primary" type="submit">Thêm vào giỏ</button>
                    </form>
                    <c:if test="${param.response == true}"><p style="color:green">add to cart successfully</p></c:if>
                    <c:if test="${param.response == false}"><p style="color:red">this product is already in your carts</p></c:if>
                    </div>
                </div>
            </section>
        <section class="bg-secondary text-light py-5">
            <c:set var="productList" value="${related}"/>
            <h1 class="text-center">Related product</h1>
            <%@include file="displayList.jsp" %>
        </section>
        <footer><%@include file="footer.jsp" %></footer>
    </body>
</html>
