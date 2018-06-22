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

<div class="container center card w-50">
    <h1 class="text-center mt-3 mb-3">Edytuj wydatek</h1>
    <form action="editExpense" method="post">
        <div class="form-group">
            <input name="expId" type="hidden" value="${expense.expenseId}">
        </div>
        <div class="form-group">
            <label>Nazwa wydatku</label>
            <input name="inputName" type="text" class="form-control" maxlength="45" value="${expense.name}" required >
        </div>
        <div class="form-group">
            <label>Typ wydatku</label>
            <select name="inputType" class="form-control">
                <option>Wyżywienie</option>
                <c:choose>
                    <c:when test="${expense.type} == 'Mieszkanie'">
                        <option selected>Mieszkanie</option>
                    </c:when>
                    <c:otherwise>
                        <option>Mieszkanie</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${expense.type == 'Samochód'}">
                        <option selected>Samochód</option>
                    </c:when>
                    <c:otherwise>
                        <option>Samochód</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${expense.type == 'Bilety'}">
                        <option selected>Bilety</option>
                    </c:when>
                    <c:otherwise>
                        <option>Bilety</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${expense.type == 'Inne'}">
                        <option selected>Inne</option>
                    </c:when>
                    <c:otherwise>
                        <option>Inne</option>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
        <div class="form-group">
            <label>Data</label>
            <input name="inputDate" type="date" value="${expense.date}" required>
            <c:if test="${requestScope.dateFail == true}">
                <small class="form-text" style="color:red">Podaj poprawną datę!</small>
            </c:if>
        </div>
        <div class="form-group">
            <label>Kwota [PLN]</label>
            <input name="inputValue" class="border" type="number" min="0" step="0.01" value="${expense.value}" required>
            <c:if test="${requestScope.valueFail == true}">
                <small class="form-text" style="color:red">Podaj poprawną kwotę!</small>
            </c:if>
        </div>
        <div class="form-group">
            <label>Opcjonalny opis</label>
            <textarea name="inputDescription" class="form-control" rows="3" maxlength="300"
                      placeholder="${expense.description}"></textarea>
        </div>
        <div class="d-flex justify-content-center btn-group mb-3" role="group">
            <button type="submit" class="btn btn-success">
                <i class="fas fa-plus"></i>
                Zatwierdź
            </button>
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/expenseList';" class="btn btn-danger">
                <i class="far fa-trash-alt"></i>
                Anuluj
            </button>
        </div>
    </form>


</div>



<jsp:include page="FRAGMENTS/footer.jspf"/>

<jsp:include page="FRAGMENTS/scripts.jspf"/>

</body>
</html>