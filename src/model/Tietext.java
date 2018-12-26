package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;

import sever.Client;

public class Tietext implements Serializable{
	private String textcontent;
	private String title;
	private String writer;
	private String whichba;
	
	public Tietext(String textcontent, String title, String writer,
			String whichba) {
		super();
		this.textcontent = textcontent;
		this.title = title;
		this.writer = writer;
		this.whichba = whichba;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTextcontent() {
		return textcontent;
	}
	public void setTextcontent(String textcontent) {
		this.textcontent = textcontent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	public String getWhichba() {
		return whichba;
	}
	public void setWhichba(String whichba) {
		this.whichba = whichba;
	}
	public ArrayList<Tietext> viewDate(String whichba) throws UnknownHostException, IOException, ClassNotFoundException{
		Client c = new Client();
		return c.viewTietext(whichba);
		//may can't run 
	}
	public ArrayList<Tietext> viewDate2() throws UnknownHostException, IOException, ClassNotFoundException{
		Client c = new Client();
		return c.viewTietext2();
		//may can't run 
	}
}
