<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="book" class="bean.Book">
	<jsp:setProperty name="book" property="id"/>
</jsp:useBean>
<%
	int result=book.delBook();
	String msg="删除失败，单击确定跳转到图书列表页！";
	if(result==1)
	{
	msg="删除成功，单击确定跳转到图书列表页！";
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");
 %>
  </head>
  
  <body>
<br>
  </body>
</html>
