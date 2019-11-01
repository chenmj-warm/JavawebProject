package util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class FileUtil {
	//�洢����Ϣ
	private Map parameters = null;
	//�洢�ϴ��ļ���Ϣ
	private Map file = null;
	//�����ϴ��ļ���С
	private long max_size = 30*1024*1024;
	public FileUtil(){
		parameters = new HashMap();
		file = new HashMap();
	}
	//�ϴ��ļ��ķ���
	public int upload(HttpServletRequest request,String uploadPath) throws IOException{
		//ʵ����һ��Ӳ���ļ������������ϴ��齨ServletFileUpload
		DiskFileItemFactory diskFileItemFactory =new DiskFileItemFactory();
		//�����ϴ��ļ�ʱ������ʱ����ļ����ڴ��С��������4KB,���ڵĲ��ֽ���ʱ����Ӳ��
		diskFileItemFactory.setSizeThreshold(4096);
		//������ʵ�����ϴ��齨
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		//��������ϴ��ļ���С
		fileUpload.setSizeMax(max_size);
		//���·�����ļ���Ϊ��������⡣
		fileUpload.setHeaderEncoding("UTF-8");
		List fileList = null;
		try{
			fileList = fileUpload.parseRequest(request);
		}catch(FileUploadException e){
			if(e instanceof SizeLimitExceededException){
				System.out.println("�ļ���С����"+max_size+"�ֽ�");
				return 0;
			}
			e.printStackTrace();
		}
		Iterator fileItr = fileList.iterator();
		while(fileItr.hasNext()){
			FileItem fileItem = null;
			String sourceFilePath = null;
			String sourceFileName = null;
			String filePath = null;
			String fileExt = null;
			String realPath = null;
			long size = 0;
			fileItem = (FileItem) fileItr.next();
			//������ϴ��ļ������Ǳ���Ϣ
			if(!fileItem.isFormField()){
				//�õ�Դ�ļ�������·��
				sourceFilePath = fileItem.getName();
				size = fileItem.getSize();
				if(!sourceFilePath.equals("")&&size!=0){
					//�õ�ȥ��·�����ļ���
					sourceFileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
					//�õ��ļ�����չ��
					fileExt = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1);
					//�Ե�ǰϵͳʱ�䱣���ϴ��ļ�
					long systemTime = System.currentTimeMillis();
					filePath = uploadPath+"/"+systemTime+"."+fileExt;
					realPath = request.getServletContext().getRealPath(filePath);
					try{
						fileItem.write(new File(realPath));//�����File��ʲô
					}catch(Exception e){
						e.printStackTrace();
						return 0;
					}
					file.put("size", String.valueOf(size));
					file.put("filePath", filePath);
					file.put("fileName", sourceFileName);
				}
			}else{
				//��������ϴ��ļ����Ǳ���Ϣ������Ϣ������parameter��
				String fieldName = fileItem.getFieldName();
				String value = fileItem.getString("UTF-8");
				parameters.put(fieldName, value);
			}
		}
		return 1;
	}
	//�����ļ��ķ���
	public int download(ServletContext servletContext,HttpServletResponse response,Map file) throws IOException{
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try{
			String filePath = (String)file.get("filePath");
			String realPath = servletContext.getRealPath(filePath);
			long fileLength = new File(realPath).length();
			response.setHeader("Content-disposition","attachment;filename ="+new String(((String)file.get("filename")).getBytes("UTF-8"),"ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(realPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while((bytesRead = bis.read(buff,0,buff.length))!=-1){
				bos.write(buff, 0, bytesRead);
			}
		}catch(IOException e){
			return 0;
		}finally{
			if(bis!=null)
				bis.close();
			if(bos!=null){
				bos.close();
			}
		}
		return 1;
	}
	public Map getFile(){
		return file;
	}
	public Map getParameters(){
		return parameters;
	}
	public void setMax_size(long max_size){
		this.max_size = max_size;
	}
}
