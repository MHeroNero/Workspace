package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;

import sever.Client;

public class User implements Serializable{

		private String name;
		private String pw;
		private String email;

		
		
		
		
		public User(String name, String pw, String email, String level) {
			super();
			this.name = name;
			this.pw = pw;
			this.email = email;
			this.level = level;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		private String level;
		
		public ArrayList<User> viewDate() throws UnknownHostException, IOException, ClassNotFoundException{
			Client c = new Client();
			return c.viewDate();
			
		}
}
