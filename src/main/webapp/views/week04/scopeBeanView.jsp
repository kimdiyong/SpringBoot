<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>week04/scopeBeanView.jsp</title>
</head>
<body>
<c:forEach var="smsArray" items="${scopeBeanArray}" varStatus="status">
    <c:forEach var="sms" items="${smsArray}" varStatus="status">
        ${status.count} : <c:out value="${sms}"/><br>
    </c:forEach>
    <c:out value="====================="/> <br>
</c:forEach>
</body>
</html>