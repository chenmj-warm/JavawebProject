package com.nn.bean;

import java.util.List;

public class Comment {
    private String commentid;

    private String createTime;

    private String creator;

    private String commentContent;

    private String pcommentid;

    private String psaidid;

    private String yl1;

    private String yl2;

    private String yl3;

    private String yl4;

    private String yl5;

    private String yl6;

    private String yl7;

    private String yl8;

    private String yl9;

    private String yl10;
    
    private List<Comment> replys;

    public List<Comment> getReplys() {
		return replys;
	}

	public void setReplys(List<Comment> replys) {
		this.replys = replys;
	}

	public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getPcommentid() {
        return pcommentid;
    }

    public void setPcommentid(String pcommentid) {
        this.pcommentid = pcommentid == null ? null : pcommentid.trim();
    }

    public String getPsaidid() {
        return psaidid;
    }

    public void setPsaidid(String psaidid) {
        this.psaidid = psaidid == null ? null : psaidid.trim();
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1 == null ? null : yl1.trim();
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

    public String getYl3() {
        return yl3;
    }

    public void setYl3(String yl3) {
        this.yl3 = yl3 == null ? null : yl3.trim();
    }

    public String getYl4() {
        return yl4;
    }

    public void setYl4(String yl4) {
        this.yl4 = yl4 == null ? null : yl4.trim();
    }

    public String getYl5() {
        return yl5;
    }

    public void setYl5(String yl5) {
        this.yl5 = yl5 == null ? null : yl5.trim();
    }

    public String getYl6() {
        return yl6;
    }

    public void setYl6(String yl6) {
        this.yl6 = yl6 == null ? null : yl6.trim();
    }

    public String getYl7() {
        return yl7;
    }

    public void setYl7(String yl7) {
        this.yl7 = yl7 == null ? null : yl7.trim();
    }

    public String getYl8() {
        return yl8;
    }

    public void setYl8(String yl8) {
        this.yl8 = yl8 == null ? null : yl8.trim();
    }

    public String getYl9() {
        return yl9;
    }

    public void setYl9(String yl9) {
        this.yl9 = yl9 == null ? null : yl9.trim();
    }

    public String getYl10() {
        return yl10;
    }

    public void setYl10(String yl10) {
        this.yl10 = yl10 == null ? null : yl10.trim();
    }
}