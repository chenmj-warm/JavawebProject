package com.lanhai.pojo;

public class TiMu {

	//�ʾ���Ŀ
	//��Ŀ���
	private Integer tId;

	//�ʾ���
	private String wjId;
	//ѡ�� id
	private Integer xxId;
	//��Ŀ����
	private String wjType;
	//��Ŀ����
	private String tInner;
	private String tBeiZhu;
	public TiMu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TiMu(Integer tId, String wjId, Integer xxId, String wjType, String tInner, String tBeiZhu) {
		super();
		this.tId = tId;
		this.wjId = wjId;
		this.xxId = xxId;
		this.wjType = wjType;
		this.tInner = tInner;
		this.tBeiZhu = tBeiZhu;
	}
	public TiMu(String wjId, Integer xxId, String wjType, String tInner, String tBeiZhu) {
		super();
		this.wjId = wjId;
		this.xxId = xxId;
		this.wjType = wjType;
		this.tInner = tInner;
		this.tBeiZhu = tBeiZhu;
	}
	@Override
	public String toString() {
		return "TiMu [tId=" + tId + ", wjId=" + wjId + ", xxId=" + xxId + ", wjType=" + wjType + ", tInner=" + tInner
				+ ", tBeiZhu=" + tBeiZhu + "]";
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getWjId() {
		return wjId;
	}
	public void setWjId(String wjId) {
		this.wjId = wjId;
	}
	public Integer getXxId() {
		return xxId;
	}
	public void setXxId(Integer xxId) {
		this.xxId = xxId;
	}
	public String getWjType() {
		return wjType;
	}
	public void setWjType(String wjType) {
		this.wjType = wjType;
	}
	public String gettInner() {
		return tInner;
	}
	public void settInner(String tInner) {
		this.tInner = tInner;
	}
	public String gettBeiZhu() {
		return tBeiZhu;
	}
	public void settBeiZhu(String tBeiZhu) {
		this.tBeiZhu = tBeiZhu;
	}
	
	
	
	
	
	
	
	
	
	
}
