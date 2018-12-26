package model;

import java.io.Serializable;

public class Superuser implements Serializable{
	private String supername;
	private String superpw;
	public String getSupername() {
		return supername;
	}
	public void setSupername(String supername) {
		this.supername = supername;
	}
	public String getSuperpw() {
		return superpw;
	}
	public void setSuperpw(String superpw) {
		this.superpw = superpw;
	}
	
	public Superuser(String supername, String superpw) {
		super();
		this.supername = supername;
		this.superpw = superpw;

	}
}
