package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO;
import bean.StudentDTO;

public class UpdateInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateInfoServlet() {
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
	    String id = request.getParameter("student_id");
		
        //����ת��ҳ��
		String forward = null;
        

		// ����ģ�Ͷ���
		StudentDAO sdao = new StudentDAO();
		//����ģ�Ͷ����ҵ�񷽷����ѧ����Ϣ
	    StudentDTO s = sdao.queryStudentById(id);
		
		forward = "Update.jsp";
		
		//���û���д��request��,�Ա㹲��
		request.getSession().setAttribute("student",s);
		
		//ͨ���ַ���ת��ҳ��
		//RequestDispatcher rd = request.getRequestDispatcher(forward);
		//rd.forward(request, response);
		
		response.sendRedirect(forward);
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
