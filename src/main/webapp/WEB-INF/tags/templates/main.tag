<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Employees CRUD</title>
        <c:url var="mainCssUrl" value='/static/css/main.css' />
        <link type="text/css" rel="stylesheet" href="${mainCssUrl}" >
    </head>
    <body>
        <div class="container">
            <jsp:doBody />
        </div>
    </body>
</html>
