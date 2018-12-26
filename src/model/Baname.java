package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;

import sever.Client;

public class Baname implements Serializable{
	private String baname;

	public Baname(String baname) {
		super();
		this.baname = baname;
	}

	public String getBaname() {
		return baname;
	}

	public void setBaname(String baname) {
		this.baname = baname;
	}
	
	
	public ArrayList<Baname> viewDate() throws UnknownHostException, IOException, ClassNotFoundException{
		Client c = new Client();
		return c.viewBa();
		//may can't run 
	}
}
