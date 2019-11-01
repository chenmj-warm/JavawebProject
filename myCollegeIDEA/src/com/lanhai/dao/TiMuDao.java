package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuanXX;


public interface TiMuDao {

	
	@Select("select * from tb_t group by wjType")
	public List<TiMu> findAllTypeTiMu();
	
	
	//��̬������Ŀ
<<<<<<< HEAD
	@Insert("insert into tb_t(tId,wjType,tInner,tBeiZhu) values(null,#{wjType},#{tInner},#{tBeiZhu})")
=======
	@Insert("insert into tb_t(tId,wjType,tInner,tBeiZhu) values(#{tId},#{wjType},#{tInner},#{tBeiZhu})")
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@Options(useGeneratedKeys=true,keyColumn="tId",keyProperty="tId")
	public boolean saveTiMu(TiMu tiMu);

	
	//��ѯ����
	@Select("select * from tb_t")
	public List<TiMu> findAllTiMu();
	

	//��̬����
	@UpdateProvider(type=TiMuDynamicProvider.class,method="updateTiMu")
	public void updateTiMu(TiMu tiMu );
	
	//������Ŀ���Ͳ�����Ŀ
	@Select("select  * from tb_t where wjType=#{wjType} ")
	public List<TiMu> findTiMuType(@Param("wjType") String wjType);
	
	//������Ŀid������Ŀ
	@Select("select * from tb_t where tId=#{tId}")
	public TiMu findTiMuById(@Param("tId") Integer tId);
	
	//����idɾ����Ŀ
	@Delete("delete from tb_t where tId=#{tId}")
	public int deleteTiMuById(Integer tId);
	
	
	//����Ŀѡ���в���ѡ��
<<<<<<< HEAD
	@Insert("insert into  tb_xx(tId,xxName) values(null,#{xxName}) ")
=======
	@Insert("insert into  tb_xx(tId,xxName) values(#{tId},#{xxName}) ")
	
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void addTiMuXX(@Param("tId") Integer tId,@Param("xxName") String xxName);
	
	//������Ŀid�����޸�
	@Update("update tb_xx set count=#{count} where tId=#{tId} and xxName=#{xxName}")
	public int updateTiMuXX(@Param("count") Integer count,@Param("tId") Integer tId ,@Param("xxName") String xxName);
	
	//������Ŀid��xxName ��ѯ
	@Select("select * from tb_xx where tId=#{tId} and xxName=#{xxName}")
	public WenJuanXX findTiMuCount(@Param("tId") Integer tId,@Param("xxName") String xxName);
	
	//���������Ϣ
	@Insert("insert into tb_dc(plId,userName,wjId,plInner,plTime) values(#{plId},#{userName},#{wjId},#{plInner},#{plTime})")
	@Options(useGeneratedKeys=true,keyColumn="plId",keyProperty="plId")
	public void addPingLun(DiaoCha diaoCha);
	
	//��ѯ���е�����
	@Select("select * from tb_dc")
	public List<DiaoCha> findAddPingLun();
	
	//����idɾ������
	@Delete("delete tb_dc where plId=#{plId}")
	public int deletePingLun(Integer plId);
	
	//���� ��Ŀid  ѡ���ѯ�ʾ�ѡ�����
	
	
	
}
