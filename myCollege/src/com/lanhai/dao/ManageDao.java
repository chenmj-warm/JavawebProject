package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.Manage;

public interface ManageDao {
	
	
	//Ա�����
		@Select("insert into tb_manage(manageId,manageName,managePassword,manageQuanXian) values(#{manageId},#{manageName},#{managePassword},#{manageQuanXian})")
		@Options(useGeneratedKeys=true,keyColumn="manageId",keyProperty="manageId")
		public void saveManage(Manage manage);
		
		//��ѯ����Ա��
		@Select("select * from tb_manage")
		public List<Manage> findAllManage();
		
		//����Ա������ѯ
		@Select("select * from tb_manage where manageName=#{manageName}")
		public Manage findManageByName(@Param("manageName") String manageName);
		
		
		
		//��̬����
		@UpdateProvider(type=ManageDynamicProvider.class,method="updateManage")
		public void updateManage(Manage manage);
		
		//����id ����Ա��
		@Select("select * from tb_manage where manageId=#{manageId}")
		public Manage findManageById(@Param("manageId") Integer manageId);
		
		//����idɾ��Ա��
		@Delete("delete from tb_manage where manageId=#{manageId}")
		public int deleteManageById(Integer manageId);
		
		//ģ����ѯ
		@Select("select * from tb_manage where manageName like concat('%',#{manageName},'%')")
		public List<Manage> findManageLikeName(@Param("manageName") String manageName );
		
		//��֤��¼
		@Select("select * from tb_manage where manageName=#{manageName} and managePassword=#{managePassword}")
		public Manage manageNameAndPassword(@Param("manageName") String manageName,@Param("managePassword") String managePassword);
		

}
