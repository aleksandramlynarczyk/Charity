<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="container container--70">
    <ul class="nav--actions">
<%--        <sec:authentication var="principal" property="principal" />--%>
        <c:choose>
            <c:when test="${user == null}">
                <li><a href="/user/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/user/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </c:when>
            <c:when test="${user != null}">
                <li class="logged-user">
                    Witaj ${user.firstName}
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Moje zbiórki</a></li>
                        <li><a href="#">Wyloguj</a></li>
                    </ul>
                </li>
            </c:when>

        </c:choose>


    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>