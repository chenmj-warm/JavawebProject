package com.lanhai.service;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;
import com.lanhai.pojo.User;

public interface UserService {

	//����û�
	public void saveUser(User user);
	
	//��ѯ����
	public PageInfo<User> findAllUserByPage(Integer currentPage);
	
	//�����û�����ѯ
	public User findUserByName(String userName);
	
	//���ݸ�����Ա����ѯ
	public Manage findManageByName(String manageName);
	
	//��̬����
	public void updateUser(User user);
	
	//����id ɾ���û�
	public int deleteUserById(Integer userId);
	
	//�����û��� ģ����ѯ
	public PageInfo<User> findUserLikeName(String userName,Integer currentPage);
	
	//��֤��¼
	public User checkUserNameAndPwd(String userName,String userPassword);
	
	//�����û�id��ѯ
	public User findUserById(Integer id);
}
