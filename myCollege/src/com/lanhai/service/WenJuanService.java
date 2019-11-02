package com.lanhai.service;

import java.util.List;



import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;

public interface WenJuanService {
	
	//����ʾ�
	public void addWenJuan(WenJuan wenJuan);
	
	//��ҳ��ѯ�����ʾ�
	public PageInfo<WenJuan> findAllWenJuanByPage(Integer currentPage);
	
	//����id��ѯ�ʾ�
	public WenJuan findWenJuanById(String wjId);
	
	//��ѯ����
	public List<WenJuan> findAllWenJuan();
	
	//�������Ͳ�ѯ�ʾ�
	public PageInfo<WenJuan> findWenJuanType(String wjType,Integer currentPage);
	
	//ģ����ѯ
	public PageInfo<WenJuan> findWenJuanLikeName(String wjName,Integer currentPage);
	
	//����id ɾ���ʾ�
	public int deleteWenjuan(String wjId);
	
	//��ҳ�����ʾ�id��ѯ��Ŀ
	public PageInfo<TiMu> findTiMuByWenJuan(String wjId,Integer currentPage);
	
	//�����ʾ�id��ѯ��Ŀ
	public List<TiMu> findAllTiMuByWenJuan(String wjId);
	
	//
	public List<WenJuan> findAllTypeWenJuan();
	
	public PageInfo<WenJuan> findWenJuanByType(Integer currentPage,String wjType);

}
