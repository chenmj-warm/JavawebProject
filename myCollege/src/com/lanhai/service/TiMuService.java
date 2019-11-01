package com.lanhai.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lanhai.dao.TiMuDao;
import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuanXX;

public interface TiMuService {
	//�����Ŀ
	public boolean addTiMu(TiMu tiMu);
   //��ҳ��ѯ��Ŀ
	public PageInfo<TiMu> findTiMuByPage(int currentPage);
	
	//��ѯ���� ��Ŀ
	public List<TiMu> findAllTiMu();
	
	//����id ��ѯ������Ŀ
	public TiMu findTiMuById(Integer tId);
	
	//����Idɾ����Ŀ��Ϣ
	public void deleteTiMu(Integer tId);
	
	//������Ŀ���Ͳ�ѯ��Ŀ��Ϣ
	public PageInfo<TiMu> findTiMuType(int pageNum,String wjType);
	
	//��̬�޸�
	public void updateTiMu(TiMu tiMu);
	
	//�ʾ�𰸱���
	public void addWenJuanXX(WenJuanXX wenJuanXX);
	
	//����Ŀѡ���в���ѡ��
	public void addTiMuXX(Integer tId,String xxName);
	
	//ͳ���û�ѡ�����Ŀ
	public int tongJiTiMu(Integer count,Integer tId,String xxName);
	
	//��ѯ��Ŀѡ��Ĵ���
	public WenJuanXX findTiMuCount(Integer tId,String xxName);
	
	//�������
	public void addPingLun(DiaoCha diaoCha);
	
	//��ѯ���� 
	public PageInfo<DiaoCha> findAllPingLun(Integer currentPage);
	
	//����idɾ������
	public int deletePingLun(Integer plId);
	
	//����������Ŀ����
	public List<TiMu> findAllTypeTiMu();
	
	

}
