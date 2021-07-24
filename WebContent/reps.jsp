<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Poli-View</title>
   <style type="text/css">
		<%@ include file="css/pf.css"%>
	</style>
</head>
<body>
<div id='topBar'></div>
    <div id=header></div>
    <div id='topBar'>
        <a href="${pageContext.request.contextPath}/" ><img id='logo' src="data:image/jpg;base64,${logo}"/></a>
        <div class = 'dropdown'>
            <a href="${pageContext.request.contextPath}/states"> <p class = 'tabs' id = 'figures'>Political Figures</p></a>
            <a href='${pageContext.request.contextPath}/news'><p class = 'tabs' id = 'news'>News</p></a>
            <a href='forums.html'><p class = 'tabs' id = 'forums'>Forums</p></a>
        </div>
    </div>
    <h1 class='title'>Poli-View</h1>
    <div>
        <h1 id='pageTitle' class='sub'>Choose Representative</h1>
        <div id=tableDiv>
            <table id='stateTable'>
            <caption>Congress Representatives</caption>
                <tr>
                	<c:forEach var="rep" items="${reps}">
                    	<td><a class='reps' href="${pageContext.request.contextPath}/info?id=${rep.id}"><c:out value="${rep.FName}"></c:out> <c:out value="${rep.LName}"></c:out></a><td>
                    </c:forEach>
               </tr>
            </table>
        </div>
        <div id=tableDiv2>
            <table id='stateTable'>
            <caption>U.S Senators</caption>
                <tr>
                	<c:forEach var="rep" items="${senators}">
                    	<td><a class='senators' href="${pageContext.request.contextPath}/info?id=${rep.id}"><c:out value="${rep.FName}"></c:out> <c:out value="${rep.LName}"></c:out></a><td>
                    </c:forEach>
               </tr>
            </table>
        </div>
    </div>
    <div id = 'states'></div>
    <div id='mainContentHolder'>
        
    </div>
    
</body>
</html>