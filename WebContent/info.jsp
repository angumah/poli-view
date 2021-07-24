<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Poli-View</title>
      <style type="text/css">
      <%@ include file="css/styles.css" %>
    	<%@ include file="css/info.css" %>
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
        <img id='image' src="data:image/jpg;base64,${i}"/>
    </div>

    <div id='bio'>
        <p><c:out value="${rep.FName}"></c:out> <c:out value="${rep.LName}"></c:out></p><br>
        <p>District <c:out value="${rep.district}"></c:out></p><br>
        <p><c:out value="${rep.party}"></c:out></p><br>
        <p><c:out value="${officeName}"></c:out></p><br>
    </div>
    
    <div id="content">
    	<table id='info' border="1">
			<caption>Committees</caption>
				<tr>
					<td>Name</td>
					<td>Jurisdiction</td>
					<td>Address</td>
					<td>City</td>
					<td>State</td>
					<td>Zip</td>
					<td>Phone</td>
					<td>Url</td>
					<td>Staff Contact</td>
				</tr>
			<c:forEach var="committee" items="${committeesList}">
				
				<tr>
					<td><c:out value="${committee.name}" /></td>
					<td><c:out value="${committee.jurisdiction}" /></td>
					<td><c:out value="${committee.address}" /></td>
					<td><c:out value="${committee.city}" /></td>
					<td><c:out value="${committee.state}"/></td>
					<td><c:out value="${committee.zip}" /></td>
					<td><c:out value="${committee.phone}" /></td>
					<td><c:out value="${committee.url}" /></td>
					<td><c:out value="${committee.staffContact}" /></td>
				</tr>
			</c:forEach>
		</table>
    </div>

    <div id='topBar'></div>
</body>
</html>