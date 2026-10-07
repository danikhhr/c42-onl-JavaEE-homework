<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Library</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
          crossorigin="anonymous">
</head>
<body>
<h1 class="container mt-3 text-center">Electronic library</h1>
<ul>
    <li>
        <a href="${pageContext.request.contextPath}/book?book=cleanCode">download Clean Code.pdf</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/book?book=algorithms">download Grokking Algorithms</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/book?book=java">Download Think Java</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/book?book=python">Download Think Python</a>
    </li>
</ul>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>