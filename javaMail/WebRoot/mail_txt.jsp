<%@ page language="java" import="java.util.*" pageEncoding="GBK" import="javax.mail.*,javax.mail.internet.*,java.io.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>mail_txt.jsp</title>
    
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
  <%
  	Properties props=new Properties();
  	//�����ʼ���ַ
  	props.put("mail.host","219.216.128.8");
  	//�����ʼ��Ự
	Session ses=Session.getDefaultInstance(props,null);
	//��Session����MimeMessage(ses)
	MimeMessage msg=new MimeMessage(ses);
	InternetAddress from=new InternetAddress("jinyan_t@neusoft.edu.cn");
	InternetAddress to=new InternetAddress("zhangna@neusoft.edu.cn");
	msg.setFrom(from);
	msg.addRecipient(Message.RecipientType.TO,to);
	msg.setSubject("first mail");
	msg.setText("���ǵ�һ���ʼ�","GBK");
	Transport tran=ses.getTransport("smtp");
	tran.connect("219.216.128.8","jinyan_t@neusoft.edu.cn","***");
	Transport.send(msg);
	out.println("�ʼ����ͳɹ�");
   %>
  </body>
</html>
