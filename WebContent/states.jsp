<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Poli-View</title>
   <style type="text/css">
		<%@ include file="css/states.css"%>
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
        <h1 id = 'pageTitle' class='sub'>Choose a State</h1>
        <div id=tableDiv>
            <table id='stateTable'>
                <tr>
                    <td><c:out value="${states[0].name}"></c:out>
                    <td><c:out value="${states[1].name}"></c:out>
                    <td><c:out value="${states[2].name}"></c:out>
                    <td><c:out value="${states[3].name}"></c:out>
                    <td><c:out value="${states[4].name}"></c:out>
                    <td><c:out value="${states[5].name}"></c:out>
                    <td><c:out value="${states[6].name}"></c:out>
                    <td><c:out value="${states[7].name}"></c:out>
                    <td><c:out value="${states[8].name}"></c:out>
                    <td><c:out value="${states[9].name}"></c:out>
               </tr>
              
              <tr>
                    <td><c:out value="${states[10].name}"></c:out>
                    <td><c:out value="${states[11].name}"></c:out>
                    <td><c:out value="${states[12].name}"></c:out>
                    <td><c:out value="${states[13].name}"></c:out>
                    <td><c:out value="${states[14].name}"></c:out>
                    <td><c:out value="${states[15].name}"></c:out>
                    <td><c:out value="${states[16].name}"></c:out>
                    <td><c:out value="${states[17].name}"></c:out>
                    <td><c:out value="${states[18].name}"></c:out>
                    <td><c:out value="${states[19].name}"></c:out>
               </tr>
               
               <tr>
                    <td><c:out value="${states[20].name}"></c:out>
                    <td><c:out value="${states[21].name}"></c:out>
                    <td><c:out value="${states[22].name}"></c:out>
                    <td><c:out value="${states[23].name}"></c:out>
                    <td><c:out value="${states[24].name}"></c:out>
                    <td><c:out value="${states[25].name}"></c:out>
                    <td><c:out value="${states[26].name}"></c:out>
                    <td><c:out value="${states[27].name}"></c:out>
                    <td><c:out value="${states[28].name}"></c:out>
                    <td><a class='urls' href="${pageContext.request.contextPath}/view?id=${states[29].ID}"><c:out value="${states[29].name}"></c:out></a>
               </tr>
               
               <tr>
                    <td><c:out value="${states[30].name}"></c:out>
                    <td><c:out value="${states[31].name}"></c:out>
                    <td><c:out value="${states[32].name}"></c:out>
                    <td><c:out value="${states[33].name}"></c:out>
                    <td><c:out value="${states[34].name}"></c:out>
                    <td><c:out value="${states[35].name}"></c:out>
                    <td><c:out value="${states[36].name}"></c:out>
                    <td><c:out value="${states[37].name}"></c:out>
                    <td><c:out value="${states[38].name}"></c:out>
                    <td><c:out value="${states[39].name}"></c:out>
               </tr>
               
               <tr>
                    <td><c:out value="${states[40].name}"></c:out>
                    <td><c:out value="${states[41].name}"></c:out>
                    <td><c:out value="${states[42].name}"></c:out>
                    <td><c:out value="${states[43].name}"></c:out>
                    <td><c:out value="${states[44].name}"></c:out>
                    <td><c:out value="${states[45].name}"></c:out>
                    <td><c:out value="${states[46].name}"></c:out>
                    <td><c:out value="${states[47].name}"></c:out>
                    <td><c:out value="${states[48].name}"></c:out>
                    <td><c:out value="${states[49].name}"></c:out>
               </tr>
            </table>
        </div>
    </div>
    <div id = 'states'></div>
    <div id='topBar'></div>
</body>
</html>