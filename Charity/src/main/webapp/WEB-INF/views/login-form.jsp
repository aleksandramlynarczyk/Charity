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
        <h2>Zaloguj się</h2>
        <form:form action="/user/login" method="post" modelAttribute="user">
            <div class="form-group">
                <form:input path="email" type="email" id="email" placeholder="Email"/>
            </div>
            <div class="form-group">
                <form:password path="password"  id="password" placeholder="Hasło"/>

                <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
            </div>

            <div class="form-group form-group--buttons">
                <a href="#" class="btn btn--without-border">Załóż konto</a>
                <button class="btn" type="submit">Zaloguj się</button>
            </div>
        </form:form>
    </section>

        <%@ include file="footer.jsp" %>
</body>
</html>
