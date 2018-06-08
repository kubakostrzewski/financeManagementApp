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

<div class="row">
    <div class="col-12">
        <h1>Moje konto</h1>
    </div>
</div>
<div class="row">
    <div class="col-2">
        <div class="btn-group-vertical" role="group" aria-label="Basic example">
            <button type="button" class="btn btn-outline-secondary">Mój profil</button>
            <button type="button" class="btn btn-outline-secondary">Zmiana hasła</button>
        </div>
    </div>
    <div class="col-10">
        Prawa
    </div>
</div>

<jsp:include page="FRAGMENTS/footer.jspf"/>

<jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>