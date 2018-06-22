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
<body class="text-center">

<jsp:include page="FRAGMENTS/navbar.jspf"/>


<form class="form-signin center" action="register" method="post">
    <h2 class="font-weight-normal">Rejestracja</h2>
    <div class="form-group">
        <input name="inputName" type="text" class="form-control" aria-describedby="emailHelp"
               placeholder="Nazwa użytkownika" value="${requestScope.name}" maxlength="45">
        <small id="nameHelp" class="form-text text-muted">Podaj swoją unikalną nazwę użytkownika</small>
        <c:if test="${requestScope.duplicate == true}">
            <small i="duplicatedNameHelp" class="form-text" style="color:red">Podana nazwa użytkownika już istnieje!</small>
        </c:if>
    </div>
    <div class="form-group">
        <input name="inputPassword" type="password" class="form-control" id="exampleInputPassword"
               placeholder="Hasło" maxlength="45">
        <input name="inputPasswordConfirm" type="password" class="form-control" id="exampleInputPasswordConfirm"
               placeholder="Powtórz hasło" maxlength="45">
        <c:if test="${requestScope.passMatch == true}">
            <small i="passwordMatchHelp" class="form-text" style="color:red">Podane hasła są różne!</small>
        </c:if>
        <c:if test="${requestScope.passTooShort == true}">
            <small i="passwordTooShortHelp" class="form-text" style="color:red">Hasło musi mieć minimum 6 znaków!</small>
        </c:if>
    </div>
    <button type="submit" class="btn btn-primary">Zarejestruj</button>
</form>

<jsp:include page="FRAGMENTS/footer.jspf"/>

<jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>