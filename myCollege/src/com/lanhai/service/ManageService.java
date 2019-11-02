package com.lanhai.service;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;


public interface ManageService {

	//���Ա��
		public void saveManage(Manage manage);
		
		//��ѯ����
		public PageInfo<Manage> findAllManageByPage(Integer currentPage);
		
		//����Ա������ѯ
		public Manage findManageByName(String manageName);
		
		
		
		//��̬����
		public void updateManage(Manage manage);
		
		//����id ɾ��Ա��
		public int deleteManageById(Integer manageId);
		
		//����Ա���� ģ����ѯ
		public PageInfo<Manage> findManageLikeName(String manageName,Integer currentPage);
		
		//��֤��¼
		public Manage checkManageNameAndPwd(String manageName,String managePassword);
		
		//����Ա��id��ѯ
		public Manage findManageById(Integer id);
	
}
