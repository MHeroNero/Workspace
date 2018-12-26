package model;

import java.io.Serializable;

public class Picture implements Serializable{
	private String name;
	private String img;
	private String title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Picture(String name, String img, String title) {
		super();
		this.name = name;
		this.img = img;
		this.title = title;
	}
	
	
	
	
}
