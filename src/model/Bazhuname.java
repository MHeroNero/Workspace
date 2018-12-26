package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import sever.Client;

public class Bazhuname implements Serializable{
	private String whichba;
	private String bazhuname;
	public String getWhichba() {
		return whichba;
	}
	public void setWhichba(String whichba) {
		this.whichba = whichba;
	}
	public String getBazhuname() {
		return bazhuname;
	}
	public void setBazhuname(String bazhuname) {
		this.bazhuname = bazhuname;
	}
	public Bazhuname(String whichba, String bazhuname) {
		super();
		this.whichba = whichba;
		this.bazhuname = bazhuname;
	}
	
	public ArrayList<Bazhuname> viewDate() throws UnknownHostException, IOException, ClassNotFoundException {
		Client c = new Client();
		return c.viewBazhu();
		
	}
	
	
}
