package com.lanhai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;
import com.lanhai.service.ManageService;
@Controller
public class ManageController {
	
	
	@Autowired
	private ManageService manageService;
	
	
	
	
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}

		// ���Ա��
		@RequestMapping(value = "/addManageMethod", method = RequestMethod.POST)
		public String addManageMethod(@ModelAttribute Manage manage, Model model) {
			System.out.println(manage);
			manageService.saveManage(manage);
			return "redirect:findAllManageByPage?currentPage=1";
		}

		// ��¼��֤

		// ����Ա������ѯԱ��������֤
		// Ա���Ƿ����
		@RequestMapping(value = "/checkmanageMethod")
		@ResponseBody
		//����ҳ������ajax�����Զ�ת��
		public Manage checkManageMethod(String manageName) {
			return manageService.findManageByName(manageName);
			
		}

		
		
		//����Ա��������ģ����ѯ
		@RequestMapping(value="/findManageLikeName")
		public String findManageLikeName(String checkName,int currentPage,Model model){
			System.out.println("����Ա��ģ����ѯ���"+checkName+"----"+currentPage);
			PageInfo<Manage> pageInfo=manageService.findManageLikeName(checkName, currentPage);
			model.addAttribute("pageInfo", pageInfo);
			System.out.println("����Ա��ģ����ѯ�ķ���");
			System.out.println("�����ؼ���"+checkName);
			model.addAttribute("url", "findmanageLikeName?checkName="+checkName);
			return "managelist";
		}
		
		//����id����ɾ��
		@RequestMapping(value="/deleteManageById")
		public String deleteManageById(Integer manageId){
			int a=manageService.deleteManageById(manageId);
			System.out.println("����ɾ������  I��ֵ"+a);
			return "redirect:findAllManageByPage?currentPage=1";
		}
		
		//����id��ѯԱ��
		@RequestMapping(value="/findManageById")
		public String findManageById(Integer manageId,Model model){
			Manage manage=manageService.findManageById(manageId);
			model.addAttribute("manage", manage);
			return "manageupdate";
		}
		//����id �����޸�Ա��
		@RequestMapping(value="/updateManageMethod")
		public String updateManageMethod(@ModelAttribute Manage manage,Model model){
			manageService.updateManage(manage);
			return "redirect:findAllManageByPage?currentPage=1";
		}
		
		//��ҳ��ѯ����
		@RequestMapping(value="/findAllManageByPage")
		public String findAllManageByPage(Integer currentPage,Model model){
			System.out.println("���Ƿ�ҳ��ѯԱ���ķ���");
			PageInfo<Manage> pageInfo=manageService.findAllManageByPage(currentPage);
			System.out.println("��ѯ��Ϊ���Ϊ��"+pageInfo);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("url", "findAllManageByPage");
			return "managelist";
		}

}
