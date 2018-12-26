package sever;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class Client {
	ObjectOutputStream oos;
	ObjectInputStream ois;
	final int LOGIN = 1001;
	final int REGISTER = 1002;
	final int UPLOAD = 1003;
	final int TIETEXT = 1004;
	final int VIEW = 1005;
	final int DELETEUSER = 1007;
	final int VIEWDATE = 1008;
	final int VIEWTIETEXT = 1009;
	final int READTEXT = 1010;
	final int SPUSERLOGIN = 1011;
	final int BANAME = 1012;
	final int INTOBA = 1013;
	final int VIEWBAZHU = 1014;
	final int BZREASON = 1015;
	final int DELETEBAZHU = 1016;
	final int SETBAZHU = 1017;
	final int VIEWTIETEXT2 = 1018;
	final int DELETETEXT = 1019;
	final int LOADUSERINFORM = 1020;
	final int SQBAZHU = 1021;
	final int READSENDINFORM = 1022;
	final int BAZHULOGIN = 1023;
	final int CHANGEPW = 1024;
	final int REPLY = 1025;
	final int LOADREPLY = 1026;
	final int ADDGREATTEXT = 1027;
	final int VIEWGREATTEXT = 1028;
	final int DELETEGREATTEXT = 1029;
	final int UPLOADJBREASON = 1030;
	final int SETLEVEL = 1031;
	final int VIEWJBREASON = 1032;
	final int QIANDAO = 1033;
	Socket s;
	
	public Client () throws UnknownHostException, IOException{
		Socket s = new Socket ("10.51.160.232",45678);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}
	
	public  User login(String name, String pw) throws IOException, ClassNotFoundException{
			oos.writeInt(LOGIN);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeUTF(pw);
			oos.flush();

			return (User) ois.readObject();
	}
	
	public User register(String name, String pw, String email,String level)
	throws IOException, ClassNotFoundException {
		oos.writeInt(REGISTER);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeUTF(pw);
			oos.flush();
			oos.writeUTF(email);
			oos.flush();
			oos.writeUTF(level);
			oos.flush();
			return (User) ois.readObject();
		}
	
	
	
	
	public void uploadFile(String uname, File f) throws IOException {
		oos.writeInt(UPLOAD);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();
		FileInputStream fis = new FileInputStream(f);

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			oos.write(buf, 0, len);
		}
		s.shutdownOutput();
	}
	
	
	
	
	public void loadFile(String uname, File f) throws IOException {
		oos.writeInt(1006);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();

		int n = ois.readInt();
		if (n == 1) {
			FileOutputStream fos = new FileOutputStream(f);
			
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = ois.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			fos.close();
		}
	}
	
	public Tietext uploadText(String textcontent, String title,String writer,String whichba) throws IOException, ClassNotFoundException {
		oos.writeInt(TIETEXT);
		oos.flush();
		oos.writeUTF(textcontent);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
		oos.writeUTF(writer);
		oos.flush();
		oos.writeUTF(whichba);
		oos.flush();
		return (Tietext) ois.readObject();
	}
	
	
	public String view() throws IOException {
		oos.writeInt(VIEW);
		oos.flush();
		return ois.readUTF();
	}
	
	public void uploadBZreason(String name,String reason) throws IOException, ClassNotFoundException{
		oos.writeInt(BZREASON);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(reason);
		oos.flush();
	}
		
	public void deleteuser(String name) throws IOException{
		oos.writeInt(DELETEUSER);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<User> viewDate() throws IOException, ClassNotFoundException{
		oos.writeInt(VIEWDATE);
		oos.flush();
		ArrayList<User> user= (ArrayList<User>) ois.readObject();
		return user;
		//列出用户
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Tietext> viewTietext(String whichba) throws IOException, ClassNotFoundException{
		oos.writeInt(VIEWTIETEXT);
		oos.flush();
		oos.writeUTF(whichba);
		oos.flush();
		ArrayList<Tietext> tietext= (ArrayList<Tietext>) ois.readObject();
		return tietext;
	}
	
	public Tietext readtext(String title) throws IOException, ClassNotFoundException{
		oos.writeInt(READTEXT);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
		return (Tietext) ois.readObject();
	}
	
	public  Superuser spuserlogin(String supername, String superpw) throws IOException, ClassNotFoundException{
		oos.writeInt(SPUSERLOGIN);
		oos.flush();
		oos.writeUTF(supername);
		oos.flush();
		oos.writeUTF(superpw);
		oos.flush();

		return (Superuser) ois.readObject();
}
	
	public ArrayList<Baname> viewBa() throws IOException, ClassNotFoundException{
		oos.writeInt(BANAME);
		oos.flush();
		ArrayList<Baname> tietext= (ArrayList<Baname>) ois.readObject();
		return tietext;
	}
	
	public  Baname intoba(String baname) throws IOException, ClassNotFoundException{
		oos.writeInt(INTOBA);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		return (Baname) ois.readObject();
	}
	
	public ArrayList<Bazhuname> viewBazhu() throws  ClassNotFoundException, IOException{
		oos.writeInt(VIEWBAZHU);
		oos.flush();
		ArrayList<Bazhuname> bazhus = (ArrayList<Bazhuname>) ois.readObject();
		return bazhus;
	}
	
	public void deletebazhu(String baname,String screason,String bazhuname) throws IOException{
		oos.writeInt(DELETEBAZHU);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		oos.writeUTF(screason);
		oos.flush();
		oos.writeUTF(bazhuname);
		oos.flush();
	}
	
	public void setbazhu(String baname,String screason,String bazhuname) throws IOException{
		oos.writeInt(SETBAZHU);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		oos.writeUTF(screason);
		oos.flush();
		oos.writeUTF(bazhuname);
		oos.flush();
	}
	public ArrayList<Tietext> viewTietext2() throws IOException, ClassNotFoundException{
		oos.writeInt(VIEWTIETEXT2);
		oos.flush();
		ArrayList<Tietext> tietext= (ArrayList<Tietext>) ois.readObject();
		return tietext;
	}
	public void deletetext(String writer,String title,String screason) throws IOException{
		oos.writeInt(DELETETEXT);
		oos.flush();
		oos.writeUTF(writer);
		oos.flush();		
		oos.writeUTF(title);
		oos.flush();
		oos.writeUTF(screason);
		oos.flush();
	}
	
	public String loaduserinform(String username) throws IOException{
		oos.writeInt(LOADUSERINFORM);
		oos.flush();
		oos.writeUTF(username);
		oos.flush();
		return ois.readUTF();
		
		
	}
	
	public void SQbazhu(String name,String sqreason) throws IOException{
		oos.writeInt(SQBAZHU);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(sqreason);
		oos.flush();
		
	}
	
	public String readsendinform() throws IOException{
		oos.writeInt(READSENDINFORM);
		oos.flush();
		return ois.readUTF();
	}
	
	public int bazhulogin(String name, String baname) throws IOException{
		oos.writeInt(BAZHULOGIN);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		return ois.readInt();
		
	}
	public void changepw(String name ,String newpw) throws IOException{
		oos.writeInt(CHANGEPW);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(newpw);
		oos.flush();
		
	}
	public void reply(String tietitle ,String name ,String replytext) throws IOException{
		oos.writeInt(REPLY);
		oos.flush();
		oos.writeUTF(tietitle);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(replytext);
		oos.flush();
	}
	
	public String loadreply(String tietitle) throws IOException{
		oos.writeInt(LOADREPLY);
		oos.flush();
		oos.writeUTF(tietitle);
		oos.flush();
		return ois.readUTF();
		
	}
	public void addgreattext(String title ,String name ,String whichba) throws IOException{
		oos.writeInt(ADDGREATTEXT);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(whichba);
		oos.flush();
	}
	
	public ArrayList<Greattext> viewGreattext(String whichba) throws IOException, ClassNotFoundException{
		oos.writeInt(VIEWGREATTEXT);
		oos.flush();
		oos.writeUTF(whichba);
		oos.flush();
		ArrayList<Greattext> greattexts= (ArrayList<Greattext>) ois.readObject();
		return greattexts;
	}
	
	
	public  void deletegreattext(String title) throws IOException{
		oos.writeInt(DELETEGREATTEXT);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
	}
	public void uploadjbreason(String tiename ,String username,String baname,String reason) throws IOException{
		oos.writeInt(UPLOADJBREASON);
		oos.flush();
		oos.writeUTF(tiename);
		oos.flush();
		oos.writeUTF(username);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		oos.writeUTF(reason);
		oos.flush();
	}
	public void setlevel(String lv1,String lv2,String lv3,String whichba) throws IOException{
		oos.writeInt(SETLEVEL);
		oos.flush();
		oos.writeUTF(lv1);
		oos.flush();
		oos.writeUTF(lv2);
		oos.flush();
		oos.writeUTF(lv3);
		oos.flush();
		oos.writeUTF(whichba);
		oos.flush();
	}
	public String level(String name ,String baname) throws IOException{
		oos.writeInt(4000);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		return ois.readUTF();
		
	}
	public String viewjbreason(String baname) throws IOException{
		oos.writeInt(VIEWJBREASON );
		oos.flush();
		oos.writeUTF(baname);
		oos.flush();
		return ois.readUTF();
	}
	
	public int qiandao(String nowtime,String username) throws IOException{
		oos.writeInt(QIANDAO);
		oos.flush();
		oos.writeUTF(nowtime);
		oos.flush();
		oos.writeUTF(username);
		oos.flush();
		return ois.readInt();
		
	}
}


