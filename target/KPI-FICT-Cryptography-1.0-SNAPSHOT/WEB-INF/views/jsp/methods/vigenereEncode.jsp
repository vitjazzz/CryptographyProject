<%--
  Created by IntelliJ IDEA.
  User: Viktor
  Date: 02.10.2016
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<div id="mainContainer" class="container-fluid">
    <div class="row">
        <div class="col-md-12 form-container">
            <div class="centralize-text">Кодування шифром Віженера</div>

            <form:form method="post" modelAttribute="encodeForm" action="vigenereEncode">

                <spring:bind path="messageToEncode">
                    <div class="form-group">
                        <label for="textToEncode" class="top-margin">Повідомлення, яке потрібно зашифрувати:</label>
                        <form:input path="messageToEncode" type="text" class="form-control" id="textToEncode"
                                    aria-describedby="encodeHelp" placeholder="Введіть повідомлення"/>
                        <div id="encodeHelp" class="form-text text-muted">Текст повідомлення повинен бути написаний
                            латинськими буквами.
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="keyString">
                    <div class="form-group">
                        <label for="keyString" class="top-margin">Слово-ключ шифрування:</label>
                        <form:input path="keyString" type="text" class="form-control" id="keyString"/>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary top-margin">Зашифрувати</button>
                </div>

            </form:form>

            <div>
                <c:if test="${not empty encodeResult}">
                    <h2>Зашифроване повідомлення:<br> ${encodeResult}</h2>
                </c:if>
            </div>
        </div>
    </div>

</div>



<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
