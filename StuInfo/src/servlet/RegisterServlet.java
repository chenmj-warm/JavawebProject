package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserDAO;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		//����������
		String username = request.getParameter("userName");
		String password = request.getParameter("userPwd");
		String sex = request.getParameter("userSex");
		String email = request.getParameter("userEmail"); 
		String info = request.getParameter("userBasicInfo");
		
        //����ת��ҳ��
		String forward = null;
        

		// ����ģ�Ͷ���
		UserDAO udao = new UserDAO();
		//����ģ�Ͷ����ҵ�񷽷����жϵ�¼���û��Ƿ���Ч
		boolean b = udao.register(username, password,sex,email,info);
		
		if (b)	
			forward = "login.jsp";		
		else 
			forward = "register.jsp";
		
		//���û���д��request��,�Ա㹲��
		request.setAttribute("username",username);
		
		//ͨ���ַ���ת��ҳ��
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		//response.sendRedirect(forward);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
