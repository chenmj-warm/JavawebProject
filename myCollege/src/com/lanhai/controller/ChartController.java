package com.lanhai.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhai.utils.ChartUtil;


@Controller
@RequestMapping(value="/chart")
public class ChartController {
	
	
	//��ʾ��״ͼ
	@RequestMapping(value="/showBar3D")
	public String showBar3D(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");//���÷�������Ӧ�ͻ��˵����ݵĸ�ʽ�ͱ���
		
		HttpSession session=request.getSession(); //��ȡsession
		
		
		PrintWriter pw=response.getWriter();//��ӡ����� (д�ķ���  write)
		
		//jfreechart-3278084056632649744.png
		String fileName=ChartUtil.createBarChart(session, pw);//����һ��pngͼƬ���ļ���
		//String fileName=ChartUtil.createPieDataset(session, pw);
		
		//������web.xml�ļ������õ�servlet(DisplayChart)��·�� (������һ�����������Servlet����Ҫ��ʾ���ļ���)
		String filePath = request.getContextPath() + "/chart/DisplayChart?filename=" + fileName;		

		System.out.println(filePath);
		
		model.addAttribute("filePath", filePath);
		
		return "xiashitu2";//��ת�� jfreechartTest.jspҳ��
	}

}
