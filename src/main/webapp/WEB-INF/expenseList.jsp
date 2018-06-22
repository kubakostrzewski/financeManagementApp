<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<div class="container-fluid">
    <c:if test="${not empty requestScope.expenses}">
        <h1 class="text-center">Lista Twoich wydatków:</h1>
        <table class="table table-hover table-bordered text-center">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Data</th>
                <th class="w-50" scope="col">Nazwa wydatku</th>
                <th scope="col">Typ</th>
                <th scope="col">Kwota [PLN]</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <c:forEach var="expense" items="${requestScope.expenses}" varStatus="loop">

                <tbody>
                <tr class="clickable" data-toggle="collapse" data-target="#group-of-rows-${loop.index}"
                    aria-expanded="false" aria-controls="group-of-rows-${loop.index}">
                    <th scope="row">${loop.index + 1}</th>
                    <td>${expense.date}</td>
                    <td>${expense.name}</td>
                    <td>${expense.type}</td>
                    <td>
                        <c:choose>
                            <c:when test="${expense.value*100%10 eq 0}">
                                ${expense.value}0
                            </c:when>
                            <c:otherwise>
                                ${expense.value}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="text-center">Klinij aby zobaczyć dodatkowe opcje i opis</td>
                </tr>
                </tbody>
                <tbody id="group-of-rows-${loop.index}" class="collapse">
                <tr>
                    <td colspan="5">
                        <strong>Opis:</strong>
                            <br>${expense.description}
                    </td>
                    <td>
                        <div class="d-flex justify-content-center">
                            <div class="btn-group-vertical" role="group" aria-label="Basic example">
                                <a href="${pageContext.request.contextPath}/editExpense?expId=${expense.expenseId}"
                                   class="btn btn-success">
                                    <i class="far fa-edit"></i>
                                    Edytuj
                                </a>
                                <a href="${pageContext.request.contextPath}/deleteExpense?expId=${expense.expenseId}"
                                   class="btn btn-danger">
                                    <i class="far fa-trash-alt"></i>
                                    Usuń
                                </a>
                            </div>
                        </div>

                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>

    </c:if>

</div>
<div class="d-flex justify-content-center">
    <a href="${pageContext.request.contextPath}/addExpense" class="btn btn-success bg-success">
        <i class="fas fa-plus"></i>
        Dodaj kolejny wydatek
    </a>
</div>

<jsp:include page="FRAGMENTS/footer.jspf"/>

<jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>