<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    <link rel="stylesheet" href="dtree.css" type="text/css"/>
    <script type="text/javascript" src="dtree.js"></script>
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
   <div class="dtree"></div>
   <h2>���β˵�dtree���������</h2>
   <p><a href="javascript:d.openAll();">ȫ��չ��</a>|<a href="javascript:d.closeAll()">ȫ���۵�</a></p>
   <script type="text/javascript">
	   d=new dTree('d');
	   d.add(0,-1,'�ҵ����β˵�');
	   d.add(1,0,'�ڵ�1','tree.jsp');
	   d.add(2,0,'�ڵ�2','tree.jsp');
	   d.add(3,1,'�ڵ�1.1','tree.jsp');
	   d.add(4,0,'�ڵ�3','tree.jsp');
	   d.add(5,3,'�ڵ�1.1.1','tree.jsp');
	   d.add(6,5,'�ڵ�1.1.1.1','tree.jsp');
	   d.add(7,0,'�ڵ�4','tree.jsp');
	   d.add(8,1,'�ڵ�1.2','tree.jsp');
	   d.add(9,0,'�ҵ����','tree.jsp','�����ҵ����','','','img/imgfolder.gif');
	   d.add(10,9,'�ҵ�����','tree.jsp','�ҵ�������Ƭ');
	   d.add(11,9,'��������','tree.jsp');
	   d.add(12,0,'����վ','tree.jsp','','','img/trash.gif');
	   document.write(d);
   </script>
  </body>
</html>
