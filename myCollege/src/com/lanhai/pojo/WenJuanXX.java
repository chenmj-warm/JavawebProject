package com.lanhai.pojo;

public class WenJuanXX {

	//�ʾ�ѡ��
	
	private Integer xxId;
	//��Ŀ���
	private int tId;
	//ѡ����
	private String xxName;
	//ѡ�����
	private Integer count;
	public WenJuanXX(Integer xxId, int tId, String xxName, Integer count) {
		super();
		this.xxId = xxId;
		this.tId = tId;
		this.xxName = xxName;
		this.count = count;
	}
	public WenJuanXX() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WenJuanXX(int tId, String xxName, Integer count) {
		super();
		this.tId = tId;
		this.xxName = xxName;
		this.count = count;
	}
	@Override
	public String toString() {
		return "WenJuanXX [xxId=" + xxId + ", tId=" + tId + ", xxName=" + xxName + ", count=" + count + "]";
	}
	public Integer getXxId() {
		return xxId;
	}
	public void setXxId(Integer xxId) {
		this.xxId = xxId;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getXxName() {
		return xxName;
	}
	public void setXxName(String xxName) {
		this.xxName = xxName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
