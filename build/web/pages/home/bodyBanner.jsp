<%-- 
    Document   : bodyBanner
    Created on : Feb 12, 2025, 4:54:16 PM
    Author     : HOME PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%= request.getContextPath() %>/CSS/bodyBanner.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="container">
            <img src="<%= request.getContextPath() %>/assets/banner.jpg" width="100%" alt="banner" style="height: 100vh"/>
            <div class="detail-box">
                <h1>
                    Best hat 
                    <br> Collection
                </h1>
                <p>
                    "Our collection includes elegant wide-brim hats, dynamic baseball caps, cozy beanies, and sophisticated fedoras. Each hat is not just an accessory but a statement of style!"
                </p>
                <div class="btn btn-warning banner-button">
                    <a href="" class="slider-link">
                        Shop Now
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
