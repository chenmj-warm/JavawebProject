<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�޸�ͼ����Ϣ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
	<script type="test/javascripct" src="JavaScript/book.js"></script>
	

  </head>
  
  <body background="img/timg (3).jpg">
  <%
 
  request.setCharacterEncoding("GBK");
   %>
<jsp:useBean id="book" class="bean.Book"/>
<jsp:setProperty name="book" property="id"/>
<%
HashMap bookinfo=(HashMap)book.getBook();
if(bookinfo!=null){

 %>
 
  <h2 align="center"> �޸�ͼ����Ϣ</h2>
  <form name="form1" onSubmit="return check()" action="edit_do.jsp" method="post">
  <input type="hidden" name="id" value="<%=bookinfo.get("id") %>"/>
  <table align="center" width="60%" border="1">
  <tr><th width="30%">����:</th><td><input type="text" name="bookname" value="<%=bookinfo.get("bookname")%>"/></td></tr>
  <tr><th >���ߣ�</th><td><input type="text" name="author" value="<%=bookinfo.get("author")%>"/></td></tr>
  <tr><th>�����裺</th><td><input type="text" name="press" value="<%=bookinfo.get("press")%>"/></td></tr>
  <tr><th>�۸�</th><td><input type="text" name="price" value="<%=bookinfo.get("price")%>"/></td></tr>
  <tr><th colspan="2"align="center"><input type="submit" value="�޸�"/><input type="reset" value="����"/></th></tr>
  </table>
  </form>
  <%
  }
   %>
     <br>
  </body>
</html>
