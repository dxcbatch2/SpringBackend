package com.dxc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Marks {
	@Id
	int sid;
	int eid;
	private int sub1;
	private int sub2;
	private int sub3;
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marks(int sid, int eid, int sub1, int sub2, int sub3) {
		super();
		this.sid = sid;
		this.eid = eid;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	@Override
	public String toString() {
		return "Marks [sid=" + sid + ", eid=" + eid + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + "]";
	}
	

}
