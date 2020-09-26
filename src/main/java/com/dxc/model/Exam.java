package com.dxc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Exam {
	@Id
	private String eid;
	private String ename;
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam(String eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", ename=" + ename + "]";
	}

}
