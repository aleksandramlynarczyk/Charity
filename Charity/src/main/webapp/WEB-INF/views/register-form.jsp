<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>
<header class="header--form-page">
    <%@ include file="header.jsp" %>

    <section class="login-page">
        <h2>Załóż konto</h2>
        <form:form action="/user/register" method="post" modelAttribute="userCheck">
            <div class="form-group">
                <form:input path="email" type="email" id="email" placeholder="Email"/>
            </div>
            <div class="form-group">
                <form:input path="firstName" type="text" id="firstName" placeholder="Imię"/>
            </div>
            <div class="form-group">
                <form:input path="lastName" type="text" id="lastName" placeholder="Nazwisko"/>
            </div>
            <div class="form-group">
                <form:password path="password" id="password" placeholder="Hasło"/>
            </div>
            <div class="form-group">
                <form:password path="password2" id="password2" placeholder="Powtórz hasło"/>
            </div>

            <div class="form-group form-group--buttons">
                <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
                <button class="btn" type="submit">Załóż konto</button>
            </div>
        </form:form>
    </section>
    <%@ include file="footer.jsp" %>
</body>
</html>
