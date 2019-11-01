package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.Manage;
import com.lanhai.pojo.User;

public interface UserDao {
	
	//�û�ע��
	@Select("insert into tb_user(userId,userName,userPassword,userSex,userPhone,userAddress,qx_name) values(#{userId},#{userName},#{userPassword},#{userSex},#{userPhone},#{userAddress},#{qx_name})")
	@Options(useGeneratedKeys=true,keyColumn="userId",keyProperty="userId")
	public void saveUser(User user);
	
	//��ѯ�����û�
	@Select("select * from tb_user")
	public List<User> findAllUser();
	
	//�����û�����ѯ
	@Select("select * from tb_user where userName=#{userName}")
	public User findUserByName(@Param("userName") String userName);
	
	//���ݹ���Ա����ѯ
	@Select("select * from tb_manage where manageName=#{manageName}")
	public Manage findManageByName(@Param("manageName") String manageName);
	
	//��̬����
	@UpdateProvider(type=UserDynamicProvider.class,method="updateUser")
	public void updateUser(User user);
	
	//����id �����û�
	@Select("select * from tb_user where userId=#{userId}")
	public User findUserById(@Param("userId") Integer userId);
	
	//����idɾ���û�
	@Delete("delete from tb_user where userId=#{userId}")
	public int deleteUserById(Integer userId);
	
	//ģ����ѯ
	@Select("select * from tb_User where userName like concat('%',#{userName},'%')")
	public List<User> findUserLikeName(@Param("userName") String userName );
	
	//��֤��¼
	@Select("select * from tb_user where userName=#{userName} and userPassword=#{userPassword}")
	public User userNameAndPassword(@Param("userName") String userName,@Param("userPassword")String userPassword);
	
	

}
