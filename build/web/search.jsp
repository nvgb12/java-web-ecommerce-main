<%-- 
    Document   : search
    Created on : Feb 20, 2025, 8:52:31 AM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/search.css"/>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <main>
            <c:set var="productList" value="${data}"/>
            <% 
            int colorPage = 1;
            int numPage =1;
            int totalPage = 1;
            try{
                numPage = (Integer)request.getAttribute("page");
                colorPage = (Integer)request.getAttribute("page");
                totalPage = (Integer)request.getAttribute("totalPage");
                if(totalPage<=2){
                    numPage=3;
                }
                else if(numPage>totalPage -2){
                    numPage = totalPage -2;
                }else if(numPage<3){
                    numPage = 3;
                }
            }catch(Exception e){
            out.println(e.getMessage());
                numPage =1;
            }
            
            %>
            <section>
                <form action="" method="get" class="search-option-container">
                    <button title="search" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    <input type="text" name="title" class="search-option" value="${param.title}"/>
                    <select name="brand" class="search-option">
                        <option value=""  ${empty param.brand ? 'selected' : ''}>Chọn Brand</option>
                        <option value="Nike" ${param.brand == 'Nike' ? 'selected' : ''}>Nike</option>
                        <option value="us" ${param.brand == 'us' ? 'selected' : ''}>Mỹ</option>
                        <option value="jp" ${param.brand == 'jp' ? 'selected' : ''}>Nhật Bản</option>
                    </select>

                    <select name="color" class="search-option">
                        <option value=""  ${empty param.color ? 'selected' : ''}>Chọn Color</option>
                        <option value="Black" ${param.color == 'Black' ? 'selected' : ''}>Black</option>
                        <option value="us" ${param.color == 'us' ? 'selected' : ''}>Mỹ</option>
                        <option value="jp" ${param.color == 'jp' ? 'selected' : ''}>Nhật Bản</option>
                    </select>

                    <select name="size" class="search-option">
                        <option value=""  ${empty param.size ? 'selected' : ''}>Chọn Size</option>
                        <option value="Free Size" ${param.size == 'Free Size' ? 'selected' : ''}>Free Size</option>
                        <option value="us" ${param.size == 'us' ? 'selected' : ''}>Mỹ</option>
                        <option value="jp" ${param.size == 'jp' ? 'selected' : ''}>Nhật Bản</option>
                    </select>

                    <select name="type" class="search-option">
                        <option value=""  ${empty param.type ? 'selected' : ''}>Chọn Type</option>
                        <option value="Cap" ${param.type == 'Cap' ? 'selected' : ''}>Cap</option>
                        <option value="us" ${param.type == 'us' ? 'selected' : ''}>Mỹ</option>
                        <option value="jp" ${param.type == 'jp' ? 'selected' : ''}>Nhật Bản</option>
                    </select>
                    <select name="sort" class="search-option">
                        <option value=""  ${empty param.type ? 'selected' : ''}>Sắp Xếp</option>
                        <option value="price" ${param.type == 'price' ? 'selected' : ''}>Price</option>
                        <option value="releaseDate" ${param.type == 'releaseDate' ? 'selected' : ''}>releaseDate</option>
                    </select>
                </form>
            </section>
            <section class="display-product container-fluid">
                <h1>Bộ lọc tìm kiếm</h1>
                <div class="row">
                    <%@include file="displayList.jsp" %>
                </div>

            </section>
            <div class = "d-flex flex-row gap-2">
                <% for (int i = numPage-2;i<numPage+3;i++){
            if(i>0 && i<=totalPage){%>
                <a href="?page=<%=i%>" class="page" style ="<%= (colorPage == i) ? "background-color: red;" : "" %>"><%=i%></a>
                <%}}%>
            </div>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
