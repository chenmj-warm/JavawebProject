<%@ page language="java" import="java.util.*,bean.PageBean" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û���Ϣ��ҳ��ʾ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2 align="center">ͼ����Ϣ��ҳ��ʾ</h2>
    <table border="1" align="center" width="50%">
    <tr><th>���</th><th>����</th><th>����</th></tr>
	<c:forEach var="user" items="${pageBean.data}" varStatus="vs">
	<tr>
		<td align="center"><c:out value="${vs.count}"></c:out></td>
		<td align="center"><c:out value="${user.bookname}"></c:out></td>
		<td align="center"><c:out value="${user.author}"></c:out></td>
		</tr>
	</c:forEach>    
    </table>
    <p align="center">
             ÿҳ${pageBean.pageSize}��
             ��${pageBean.totalRows}��
             ҳ��${pageBean.curPage}/${pageBean.totalPages}<br/>
    <c:choose>
    	<c:when test="${pageBean.curPage==1}">��ҳ ��һҳ</c:when>
    	<c:otherwise>
    		<a href="UserInfoServlet?page=1">��ҳ</a>
    		<a href="UserInfoServlet?page=${pageBean.curPage-1}">��һҳ</a>
    	</c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${pageBean.curPage==pageBean.totalPages}">��һҳ βҳ</c:when>
    	<c:otherwise>
    	<a href="UserInfoServlet?page=${pageBean.curPage+1}">��һҳ</a>
    	<a href="UserInfoServlet?page=${pageBean.totalPages}">βҳ</a>
    	</c:otherwise>
    </c:choose>
    
    </p>
  </body>
</html>
