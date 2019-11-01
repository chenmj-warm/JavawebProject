package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID=1L;
	/**
	 * Constructor of the object.
	 */
	public FileUploadServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<H3>FileUpload:Servlet Sample</H3>");
		out.println("<HR>");
		try{
			//ʵ����һ��Ӳ�̹��������������ϴ����ServletFileUpload
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//���û�������С��������4KB
			factory.setSizeThreshold(4096);
			ServletFileUpload upload=new ServletFileUpload(factory);
			//�����ļ����ߴ磬������4MB
			upload.setSizeMax(4194304);
			String uploadPath=this.getServletContext().getRealPath("/upload");
			//����request����
			FileItemIterator fii=upload.getItemIterator(request);//fii��ʲô��
			//��������
			while(fii.hasNext()){
				FileItemStream fis=fii.next();
				//��鵱ǰ��Ŀ����ͨ����Ŀ�����ϴ��ļ�
				if(fis.isFormField()){    //�������ͨ����Ŀ����ʾ������
					if("desc".equals(fis.getFieldName())){
						out.println("file description:"+fis.getFieldName()+"<br/>");
					}
				}else{
					//�õ��������ļ�·��
					String path=fis.getName();
					//�õ�ȥ��·�����ļ���
					String filename=path.substring(path.lastIndexOf("\\")+1);
					//���ļ����浽webĿ¼��upload�ļ�����
					BufferedInputStream bis=new BufferedInputStream(fis.openStream());
					File file = new File(uploadPath+"\\"+filename);
					if(!file.exists()){
					    //�ȵõ��ļ����ϼ�Ŀ¼���������ϼ�Ŀ¼���ڴ����ļ�
					    file.getParentFile().mkdir();
					    try {
					        //�����ļ�
					        file.createNewFile();
					    } catch (IOException e) {
					        e.printStackTrace();
					    }
					}
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(uploadPath+"\\"+filename)));
					//��ʼ���ļ�д��ָ�����ϴ��ļ���
					Streams.copy(bis, bos, true);
					out.println(filename+"file uploaded.<br/>");
				}
			
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
