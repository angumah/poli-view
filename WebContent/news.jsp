<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
    <title>Poli-View</title>
    <style type="text/css">
    	<%@ include file="css/styles.css" %>
    	<%@ include file="css/news.css" %>
    </style>
</head>
	<body>
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
    <div>
    	<table id='news'>
    		<tr>
    			<td><img id='article1' class='articles' src="data:image/jpg;base64,${article}"/></td>
    			<td><a id='link1' class='links' href='https://www.cnn.com/2021/03/18/politics/biden-tax-plan-explainer/index.html' target='_blank'>Here's how Biden wants to raise taxes on the wealthy and corporations<br><br>
    			By Tami Luhby and Katie Lobosco, CNN<br>
    			Updated 8:07 AM ET, Thu March 18, 2021</a></td>
    			<td><img id='article2' class='articles' src="data:image/jpg;base64,${article1}"/></td>
    			<td><a id='link2' class='links' href='https://www.cnn.com/2021/03/17/politics/ron-desantis-covid-florida/index.html' target='_blank'>A year into the pandemic, Florida is booming and Republican Gov. DeSantis is taking credit<br><br>
    			By Jeff Zeleny, Chief National Affairs Correspondent<br>
    			Updated 11:19 AM ET, Wed March 17, 2021
    			</a></td>
    		<tr>
    	</table>
    </div>

    <div id='topBar'></div>
</body>
</html>