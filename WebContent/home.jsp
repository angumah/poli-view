<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
    <title>Poli-View</title>
    <style type="text/css">
    	<%@ include file="css/styles.css" %>
    </style>
</head>
	<body>
	<div id='topBar'></div>
	<div id=header></div>
    <div id='TopBar'>
        <a href="${pageContext.request.contextPath}/" ><img id='logo' src="data:image/jpg;base64,${logo}"/></a>
        <div class = 'dropdown'>
            <a href="${pageContext.request.contextPath}/states"> <p class = 'tabs' id = 'figures'>Political Figures</p></a>
            <a href='${pageContext.request.contextPath}/news'><p class = 'tabs' id = 'news'>News</p></a>
            <a href='forums.html'><p class = 'tabs' id = 'forums'>Forums</p></a>
        </div>
    </div>
    
    <h1 class='title'>Poli-View</h1>
    <div id='mainContentHolder'>
        <img id = 'usMap' src='data:image/jpg;base64,${map}'/>
    </div>

    <div id='abstract'>
    <img id='abLogo' src="data:image/jpg;base64,${logo}"/>
        <p>Poli-View is a one stop shop for everything you need to know about politics.
        Poli-View tries to provide relevant information on politicians as well as upcoming elections and events, so that you can make an informed voting decision.</p>
    </div>

</body>
</html>