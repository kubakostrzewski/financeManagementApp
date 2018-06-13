<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns:jsp="http://www.w3.org/2001/XInclude" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <jsp:include page="FRAGMENTS/stylesHead.jspf"/>
    <title>Finance Management App</title>
</head>
<body>

    <jsp:include page="FRAGMENTS/navbar.jspf"/>

    <div class="center" id="login_content" >

        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <div class="card text-center">
                    <div class="card-header">
                        WITAJ W APLIKACJI FINANCE MANAGEMENT
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Witaj ${sessionScope.user.username}!</h5>
                        <p class="card-text"> Obecnie jesteś zalogowany i możesz korzystać z aplikacji :)</p>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="card text-center">
                    <div class="card-header">
                        WITAJ W APLIKACJI FINANCE MANAGEMENT
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Obecnie jesteś wylogowany</h5>
                        <p class="card-text">Zaloguj się lub załóż konto aby skorzystać z aplikacji</p>
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-success bg-success">Logowanie</a>
                        <a href="${pageContext.request.contextPath}/register" class="btn btn-success bg-success">Rejestracja</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>


    </div>

    <jsp:include page="FRAGMENTS/footer.jspf"/>

    <jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>