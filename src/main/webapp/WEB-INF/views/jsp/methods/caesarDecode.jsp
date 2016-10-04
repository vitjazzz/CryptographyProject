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
            <div class="centralize-text">Декодування шифром Цезаря</div>

            <form:form method="post" modelAttribute="decodeForm" action="caesarDecode">

                <spring:bind path="decodeMessage">
                    <div class="form-group">
                        <label for="textToDecode" class="top-margin">Повідомлення, яке потрібно дешифрувати:</label>
                        <form:input path="decodeMessage" type="text" class="form-control" id="textToDecode"
                                    aria-describedby="decodeHelp" placeholder="Введіть повідомлення"/>
                        <div id="decodeHelp" class="form-text text-muted">Текст повідомлення повинен бути написаний
                            латинськими буквами.
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="decodeKey">
                    <div class="form-group">
                        <label for="decodeKey" class="top-margin">Ключ дешифрування:</label>
                        <form:input path="decodeKey" type="number" class="form-control" id="decodeKey" step="1"/>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary top-margin">Розшифрувати</button>
                </div>

            </form:form>

            <div>
                <c:if test="${not empty decodeResult}">
                    <h2>Розшифроване повідомлення:<br> ${decodeResult}</h2>
                </c:if>
            </div>
        </div>
    </div>

</div>



<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
