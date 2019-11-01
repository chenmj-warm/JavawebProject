package com.lanhai.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lanhai.dao.TiMuDao;
import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.User;
import com.lanhai.pojo.WenJuanXX;
import com.lanhai.service.TiMuService;
import com.lanhai.service.WenJuanService;

@Controller  //���Ʋ�
public class TiMuController {

	@Autowired
	private TiMuService tiMuService;
	@Autowired
	private WenJuanService wenJuanService;

	public void setWenJuanService(WenJuanService wenJuanService) {
		this.wenJuanService = wenJuanService;
	}



	public void setTiMuService(TiMuService tiMuService) {
		this.tiMuService = tiMuService;
	}



     //�����Ŀ
	@RequestMapping(value="/AddTiMuMethod",method=RequestMethod.POST)
	public String listTuMuMethod(@ModelAttribute TiMu tiMu,Model model){
		
		boolean flag=tiMuService.addTiMu(tiMu);
		System.out.println("----------"+flag);
		
		tiMuService.addTiMuXX(tiMu.gettId(),"A");
		tiMuService.addTiMuXX(tiMu.gettId(),"B");
		tiMuService.addTiMuXX(tiMu.gettId(),"C");
		tiMuService.addTiMuXX(tiMu.gettId(),"D");
		
	
		return "redirect:/findTiMuByPage?currentPage=1";
	}
	
	//��ҳ��ѯ������Ŀ��Ϣ
	@RequestMapping(value="/findTiMuByPage")
	public String findTiMuByPage(int currentPage,Model model){
		PageInfo<TiMu> pageInfo=tiMuService.findTiMuByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		List<TiMu> tiMulist=tiMuService.findAllTypeTiMu();
		model.addAttribute("tiMuList",tiMulist );
		System.out.println("-----"+tiMulist);
		System.out.println(pageInfo);
		model.addAttribute("url", "findTiMuByPage");
		return "timulist";//��ת����Ŀ�б�
	}
	
	//�������id ɾ����Ŀ
	@RequestMapping(value="/delTiMuMethod")
	public String deleteTiMuMethod(Integer tId){
		System.out.println("----------����ɾ�������ķ���"+tId);
		tiMuService.deleteTiMu(tId);
		return "redirect:findTiMuByPage?currentPage=1";
	}
	
	//ɾ��ѡ�е�������Ŀ
	@RequestMapping(value="/delAllTiMuMethod")
	public String delAllTiMuMethod(Integer[] tiMuId){
	for(Integer id:tiMuId){
		tiMuService.deleteTiMu(id);
	}
		return "redirect:findTiMuByPage?currentPage=1";
	}
	
	//��������½�������
	//����id ��ѯ�����û�
	@RequestMapping(value="/findTiMuByIdMethod")
	public String findTiMuByIdMethod(Integer tId,Model model){
		TiMu tiMu=tiMuService.findTiMuById(tId);
		model.addAttribute("tiMu", tiMu);
		return "timuupdate";
	}
	
	//����id�޸���Ŀ��Ϣ
	@RequestMapping(value="/updateTiMuMethod")
	public String updateTiMuMethod(@ModelAttribute TiMu tiMu,Model model){
		System.out.println("---����update����----------------"+tiMu);
		tiMuService.updateTiMu(tiMu);
		return "redirect:/findTiMuByPage?currentPage=1";
	}
	
	//������Ŀ���Ͳ�ѯ��Ŀ
	@RequestMapping(value="/findTiMuType")
	public String findTiMuType(int currentPage,String selectType,Model model){
		PageInfo<TiMu> pageInfo=tiMuService.findTiMuType(currentPage, selectType);
		
		List<TiMu> tiMulist=tiMuService.findAllTypeTiMu();
		System.out.println("��Ŀ���Ͳ���--------------"+tiMulist.size());
		model.addAttribute("tiMuList",tiMulist );
		model.addAttribute("pageInfo", pageInfo);
		return "timulist";
	}
	
	//id23323lanhai
	//�����ʾ�id��ѯ���е���Ŀ��Ϣ
	@RequestMapping(value="/findTiMuWenJuan")
	public String findTiMuWenJuan(String wjId,Model model){
		System.out.println("-------------------------------�ʾ�id"+wjId);
		List<TiMu> tiMulist=wenJuanService.findAllTiMuByWenJuan(wjId);
		
		System.out.println("----------------------------"+tiMulist);
		model.addAttribute("tiMuList",tiMulist );
		model.addAttribute("wjId", wjId);
		return "timushow";
	}
	
	
	
	//�����û����Ᵽ�� �û���ѡ��
	@RequestMapping(value="/saveTiMuXX")
	public String saveTiMuXX(String wjId,String userName,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String pingLun){
		
		    //����,�ָ�
		System.out.println("------�����ʾ���Ŀ��ʾ����");
		System.out.println("�û���id----------"+userName);
		System.out.println("---"+a1+"-----"+a2+"------"+a3+"-------"+a4+"--------"+a5+"------"+a6+"------"+a7+"------------");
		String a [] ={a1,a2,a3,a4,a5,a6,a7};
		int i=0;
		List<TiMu> tiMuList=wenJuanService.findAllTiMuByWenJuan(wjId);
		System.out.println("-----------------------");
		for (TiMu tiMu : tiMuList) {
			System.out.println("------��Ŀ��idΪ��-----"+tiMu.gettId());
			WenJuanXX wenJuanXX=tiMuService.findTiMuCount(tiMu.gettId(), a[i]);
			System.out.println("�����û�ѡ�����Ŀ�Ĵ���"+wenJuanXX.getCount());
			int s=tiMuService.tongJiTiMu(wenJuanXX.getCount()+1, tiMu.gettId(), a[i]);
			System.out.println("---------------------"+s);
			i++;
		}
		
		System.out.println("------����������۵ķ���--------");
		DiaoCha diaoCha=new DiaoCha(userName, wjId, pingLun, new Date());
		tiMuService.addPingLun(diaoCha);
		System.out.println("---------��ӳɹ�------------");
		
		return "redirect:findAllWenJuanIndex?currentPage=1";
	}
	
	
	//��ҳ��ʾ��������СС�ķ���
	@RequestMapping(value="/findAllPingLun")
	public String findAllPingLun(Integer currentPage,Model model){
		System.out.println("��������������ʾ�ķ���-----------");
		PageInfo<DiaoCha> pageInfo=tiMuService.findAllPingLun(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		return "pinglunlist";
	}
	
	//��ҳ��ʾ��������  ��ת����ҳ
	@RequestMapping(value="/findAllPingLunIndex")
	public String findAllPingLunIndex(Integer currentPage,Model model){
		System.out.println("��������������ʾ�ķ���-----------");
		PageInfo<DiaoCha> pageInfo=tiMuService.findAllPingLun(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		return "personpinglun";
	}
	
	//ɾ�����۵ķ���
	@RequestMapping(value="/deletePingLun")
	public String deletePingLun(Integer plId){
		System.out.println("---------------����ɾ�����۵ķ���");
		int i=tiMuService.deletePingLun(plId);
		return "redirect:findAllPingLun?currentPage=1";
	}
	
	
	
	
	
}
