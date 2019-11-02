package com.lanhai.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;
import com.lanhai.service.TiMuService;
import com.lanhai.service.WenJuanService;

@Controller
public class WenJuanController {
	
	@Autowired
	private WenJuanService wenJuanService;
	
	@Autowired
	private TiMuService tiMuService;

	public void setWenJuanService(WenJuanService wenJuanService) {
		this.wenJuanService = wenJuanService;
	}
	
	
	
	public void setTiMuService(TiMuService tiMuService) {
		this.tiMuService = tiMuService;
	}


	//����������
	//��ҳ��ѯ
	@RequestMapping(value="/findAllWenJuanIndex")
	public String findAllWenJuanIndex(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("--���Ƿ�ҳ��ѯ--");
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		
		System.out.println("������ҳ������--------"+wenJuanList);
		model.addAttribute("wenJuanList", wenJuanList);
		model.addAttribute("url", "findAllWenJuanIndex");
		return "index";
	}
	
	//������ҳ�������ʾ��� ģ����ѯ
	@RequestMapping(value="/findWenJuanByNameIndex")
	public String findWenJuanByNameIndex(String wjName,int currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanLikeName(wjName, currentPage);
		System.out.println("����ģ����ѯ�ķ���");
		System.out.println("��ѯ�Ľ��Ϊ"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findWenJuanByNameIndex?wjName="+wjName);
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		model.addAttribute("wenJuanList", wenJuanList);
	
		return "index";
	}

	//��ҳ��ѯ����   
	//��ת���ʾ�������
	@RequestMapping(value="/findAllWenJuanByPage")
	public String findAllWenJuanByPage(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("--���Ƿ�ҳ��ѯ--");
		
		
		return "wenjuanlist";
	}
	
	//������ҳ��
	//�������Ͳ�ѯ�ʾ�
	@RequestMapping(value="/findAllTypeWenJuan")
	public String findAllTypeWenJuan(Integer currentPage,String wjType,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanByType(currentPage, wjType);
		System.out.println("�������Ͳ�ѯ�ʾ�ķ���-----------------------");
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findAllTypeWenJuan?wjType="+wjType);
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		model.addAttribute("wenJuanList", wenJuanList);
		return "index";
	}
	
	//�ʾ���ӽ���
	//show
	
	@RequestMapping(value="/findAllWenJuanShow")
	public String findAllWenJuanShow(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		System.out.println("--------------"+pageInfo);
		System.out.println("--���Ƿ�ҳshow--");
		
		List<TiMu> tiMuList=tiMuService.findAllTypeTiMu();
		model.addAttribute("tiMuList", tiMuList);
		
		model.addAttribute("url", "findAllWenJuanShow");
		return "wenjuanadd";
	}
	
	
	
	//����id  ɾ���ʾ�
	@RequestMapping(value="/deleteWenJuanMethod")
	public String deleteWenJuanMethod(String wjId){
		System.out.println("����ɾ���ʾ�ķ���-------"+wjId);
		int i=wenJuanService.deleteWenjuan(wjId);
		System.out.println("Ӱ�������Ϊ��"+i);
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//ɾ��ѡ�е������ʾ�
	@RequestMapping(value="/delAllWenJuanMethod")
	public String delAllWenJuanMethod(String[] wjId){
		System.out.println("��ȡ���ʾ�idֵΪ"+wjId);
		for(String id:wjId){
			wenJuanService.deleteWenjuan(id);
		}
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//����ʾ�
	@RequestMapping(value="/addWenJuan")
	public String addWenJuan(@ModelAttribute WenJuan wenJuan,Model model){
		
		System.out.println("��������ʾ�ķ���"+wenJuan);
		System.out.println("��ȡ�����õ��ʾ����Ŀ����Ϊ��"+wenJuan.getWjNum());
			List<TiMu> tiMuList=tiMuService.findAllTiMu();
			int i=0;
			for (TiMu tiMu : tiMuList) {
				/*System.out.println("-------------------------------");
				System.out.println("��wenjuan----"+wenJuan.getWjType());
				System.out.println("��timu----"+tiMu.getWjType());
				System.out.println("��timu ��ȡ�ʾ���--- "+tiMu.getWjId());
				System.out.println("----------------------------------");*/
				if(wenJuan.getWjType().equals(tiMu.getWjType())){
					System.out.println("mmuuuuuuuu");
					if(tiMu.getWjId()  == null || "".equals(tiMu.getWjId()) && i<wenJuan.getWjNum()){
						System.out.println("��������Ŀ��idô----------------"+tiMu);
						System.out.println("-----------wenjuanId--"+wenJuan.getWjId());
						tiMu.setWjId(wenJuan.getWjId());
						
						tiMuService.updateTiMu(tiMu);
						i++;
						
					}
					
				}
			}
			System.out.println("�ʾ����Ŀ����Ϊ��-------"+i);
			
		
		wenJuan.setWjTime(new Date());
		wenJuanService.addWenJuan(wenJuan);
		
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//ģ����ѯ
	@RequestMapping(value="/findWenJuanLikeName")
	public String findWenJuanLikeName(String wjName,int currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanLikeName(wjName, currentPage);
		System.out.println("����ģ����ѯ�ķ���");
		System.out.println("��ѯ�Ľ��Ϊ"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findWenJuanLikeName?wjName="+wjName);
		
		return "wenjuanlist";
	}
	
	//�����ʾ���ʾ��Ӧ����Ŀ
	@RequestMapping(value="/findTiMuByWenJuan")
	public String findTiMuByWenJuan(Integer currentPage,String  wjId,Model model){
		
		System.out.println("�ʾ��ţ�"+wjId+"---currentpage"+currentPage);
		PageInfo<TiMu> pageInfo=wenJuanService.findTiMuByWenJuan(wjId, currentPage);
		System.out.println("������ʾ��Ӧ��Ŀ�ķ���"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("wjId", wjId);
		model.addAttribute("url","findTiMuByWenJuan?wjId="+wjId );
		//List<TiMu> tiMuList=wenJuanService.findAllTiMuByWenJuan(wjId);
		//System.out.println("-------------------------------------"+tiMuList);
		//model.addAttribute("tiMuList", tiMuList);
		return "timushow";
	}
	
	
	

}
