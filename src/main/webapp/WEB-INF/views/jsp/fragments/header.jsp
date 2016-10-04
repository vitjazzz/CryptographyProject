<%--
  Created by IntelliJ IDEA.
  User: Viktor
  Date: 02.10.2016
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style type="text/css">
        <%@include file="../../../../css/bootstrap.min.css" %>
        <%@include file="../../../../css/bootstrap-theme.min.css" %>
        <%@include file="../../../../css/style.css"%>
    </style>

    <title>Cryptography Project</title>


</head>

<jsp:useBean id="methods" class="com.vitja.CryptographyMethod" scope="page"/>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Cryptography Methods</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Choose method
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <c:forEach var="method" items="${methods.methodNames}">
                        <li class="dropdown-submenu">
                            <a tabindex="-1" href="#">${method.methodName}</a>
                            <ul class="dropdown-menu">
                                <li><a href="${method.methodURL}Encode">Зашифрувати</a></li>
                                <li><a href="${method.methodURL}Decode">Дешифрувати</a></li>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
    </div>
</nav>

