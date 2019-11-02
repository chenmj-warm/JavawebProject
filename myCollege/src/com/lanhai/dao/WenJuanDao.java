package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;
import com.lanhai.pojo.WenJuanXX;

public interface WenJuanDao {
	
	
	//����ʾ�
	@Insert("insert into tb_wj(wjId,wjName,wjNum,wjType,wjBeiZhu,wjAuthor,wjTime) "
			+ "values(#{wjId},#{wjName},#{wjNum},#{wjType},#{wjBeiZhu},#{wjAuthor},#{wjTime} )")
	public void saveWenJuan(WenJuan wenJuan);
	
	//��ѯ����
	@Select("select * from tb_wj")
	public List<WenJuan> findAllWenJuan();
	
	//��ѯ�������͵��ʾ�
	@Select("select * from tb_wj group by wjType")
	public List<WenJuan> findAllTypeWenJuan();
	
	//����id��ѯ�ʾ�
	@Select("select * from tb_wj where wjId=#{wjId}")
	public WenJuan findWenJuanById(@Param("wjId") String wjId);
	
	//����id ɾ���ʾ�
	@Delete("delete from tb_wj where wjId=#{wjId}")
	public int deleteWenJuanById(String wjId);
	
	//ģ����ѯ
	@Select("select * from tb_wj where wjName like concat('%',#{wjName},'%') ")
	public List<WenJuan> findWenJuanLikeName(@Param("wjName") String wjName);

	
	//�����ʾ����Ͳ�ѯ�ʾ�
	@Select("select distinct *��form tb_wj where wjType=#{wjType}")
	public List<WenJuan> findWenJuanType(@Param("wjType") String wjType);
	
	//�����ʾ�id ��ѯ��Ӧ����Ŀ
	@Select("select * from tb_t where wjId=#{wjId}")
	public List<TiMu> findTiMuByWenJuan(@Param("wjId") String wjId);
	
	//�����ʾ����Ͳ����ʾ�
	@Select("select * from tb_wj where wjType=#{wjType}")
	public List<WenJuan> findWenJuanByType(@Param("wjType") String wjType);
	

}
