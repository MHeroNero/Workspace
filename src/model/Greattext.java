package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;

import sever.Client;

public class Greattext implements Serializable{
	private String greattext;
	private String name ;
	private String whichba;
	public String getGreattext() {
		return greattext;
	}

	public void setGreattext(String greattext) {
		this.greattext = greattext;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhichba() {
		return whichba;
	}

	public void setWhichba(String whichba) {
		this.whichba = whichba;
	}

	public Greattext(String greattext, String name, String whichba) {
		super();
		this.greattext = greattext;
		this.name = name;
		this.whichba = whichba;
	}

	public ArrayList<Greattext> viewDate(String whichba) throws UnknownHostException, IOException, ClassNotFoundException{
		Client c = new Client();
		return c.viewGreattext(whichba);
		//may can't run 
	}
	
	
	
}
