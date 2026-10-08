<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Time in the world</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
          crossorigin="anonymous">
</head>
<body>
<c:if test="${empty zone}">
    <div class="container mt-3 text-center">
        <p>Hello</p>
        <p>Enter a zone to find out the time</p>
    </div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/minsk">Minsk</a></li>
        <li><a href="${pageContext.request.contextPath}/washington">Washington</a></li>
        <li><a href="${pageContext.request.contextPath}/beijing">Beijing</a></li>
    </ul>
    <p>Or you can find out the age of majority by entering: <b>/isAdult?age=17</b></p>

</c:if>

<c:if test="${not empty zone}">
    <p class="container mt-3 text-center">Time in ${zone}: ${time}</p>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>