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


    <form class="form-signin center">
        <h2 class="font-weight-normal">Logowanie</h2>
        <div class="form-group">
            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="Nazwa użytkownika">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Hasło">
        </div>
        <button type="submit" class="btn btn-primary">Zaloguj</button>
    </form>

<jsp:include page="FRAGMENTS/footer.jspf"/>

<jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>