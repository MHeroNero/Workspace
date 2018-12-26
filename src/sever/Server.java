package sever;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;






import model.*;

public class Server implements Runnable{
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket s;
	final int LOGIN = 1001;
	final int REGISTER = 1002;
	final int UPLOAD = 1003;
	final int TIETEXT = 1004;
	final int view = 1005;
	final int VIEWDATE = 1008; 
	final int  VIEWTIETEXT = 1009;
	final int DELETEUSER = 1007;
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
	
	public Server() throws IOException, ClassNotFoundException, SQLException  {
		ServerSocket ss = new ServerSocket(45678);

		while (true) {
			s = ss.accept();
			Thread t = new Thread(this);
			t.start();
		}
	}
	
	public void login() throws IOException, ClassNotFoundException,
	SQLException {
			User u = null;
			String name = ois.readUTF();
			String pw = ois.readUTF();
			String sql = "select * from user where name='" + name + "' and pw ='"
		+ pw + "'";
			ResultSet rs = DataConnect.getStatement().executeQuery(sql);
			if (rs.next())
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
			oos.writeObject(u);
			oos.flush();

}
	
	public void register() throws IOException, ClassNotFoundException {
		User u = null;
		String name = ois.readUTF();
		String pw = ois.readUTF();
		String email = ois.readUTF();
		String level = ois.readUTF();
		String sql = "insert into user values('" + name + "','" + pw + "','"
				+ email + "','"+ level + "')";
		try {
			DataConnect.getStatement().executeUpdate(sql);
			oos.writeObject(new User(name,pw,email, level));
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			oos.writeObject(null);
			oos.flush();
		}
	}
	
	
	public void upLoadFile() throws IOException, SQLException,
	ClassNotFoundException {
		String uname = ois.readUTF();
			File f = new File("D:\\alljava\\数据存储\\img\\" + uname + ".jpg");

			FileOutputStream fos = new FileOutputStream(f);



			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = ois.read(buf)) != -1) {
				fos.write(buf);
			}
			fos.close();
			try {
				String sql = "insert into img values('" + uname + "','"
				+ f.getName() + "')";
				DataConnect.getStatement().executeUpdate(sql);
			} catch (Exception e) {

			}

}
	
	public void loadFile() throws IOException, SQLException,
	ClassNotFoundException {

		String uname = ois.readUTF();

		String sql = "select * from img where uname='" + uname + "'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		String fname = "";
	if (rs.next()) {
		fname = rs.getString(2);
	}
	if(fname.equals("")){
		oos.writeInt(0);
		oos.flush();
		return;
	}
		oos.writeInt(1);
		oos.flush();
	
		File f = new File("D:\\alljava\\数据存储\\img\\" + fname);
		System.out.println(f.getAbsolutePath());
		FileInputStream fis = new FileInputStream(f);
		
	
		
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
		oos.write(buf);
	}
		s.shutdownOutput();

}
	
	
	
	
	
	public void uploadText() throws IOException, ClassNotFoundException {
		String textcontent = ois.readUTF();
		String title = ois.readUTF();
		String writer = ois.readUTF();
		String whichba = ois.readUTF();
		
		String sql = "insert into tietext values('" + textcontent + "','"
		+ title + "','" + writer +  "','" + whichba +"')";
		
		try {
			DataConnect.getStatement().executeUpdate(sql);
			oos.writeObject(new Tietext(textcontent,title,writer,whichba));
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void viewDate() throws SQLException, ClassNotFoundException, IOException{
		String sql = "select * from user";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<User> users = new ArrayList<User>();
		while(rs.next()){
			users.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			
		}
		oos.writeObject(users);
		oos.flush();
	}
	
	public void viewTietext() throws SQLException, ClassNotFoundException, IOException{
		String whichba = ois.readUTF();
		String sql = "select * from tietext where whichba='" + whichba +"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<Tietext> tietexts = new ArrayList<Tietext>();
		while(rs.next()){
			tietexts.add(new Tietext(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			
		}
		oos.writeObject(tietexts);
		oos.flush();
	}
	

	
	public void deleteuser() throws IOException, SQLException, ClassNotFoundException{
		String name = ois.readUTF();
		String sql="delete from user where name='"+name+"'";
		DataConnect.getStatement().execute(sql);
	}
	
	public void readtext() throws IOException, SQLException, ClassNotFoundException {
		Tietext t = null;
		String title = ois.readUTF();
		String sql="select * from tietext where title='" + title +"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		if (rs.next())
			t = new Tietext(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
		oos.writeObject(t);
		oos.flush();
		
		
	}
	public void superuserlogin() throws IOException, SQLException, ClassNotFoundException{
		String  supername = ois.readUTF();
		String superpw = ois.readUTF();
		Superuser spu = null;
		String sql =	"select * from superuser where supername='" + supername + "' and superpw ='"
		+ superpw + "'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		if (rs.next())
			spu = new Superuser(rs.getString(1), rs.getString(2));
		oos.writeObject(spu);
		oos.flush();
	}
	
	
	public void viewBazhu() throws SQLException, ClassNotFoundException, IOException{
		String sql = "select * from bazhuname";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<Bazhuname> bazhus = new ArrayList<Bazhuname>();
		while(rs.next()){
			bazhus.add(new Bazhuname(rs.getString(1),rs.getString(2)));
			
		}
		oos.writeObject(bazhus);
		oos.flush();
		
	}
	
	public void deletebazhu() throws IOException, SQLException, ClassNotFoundException{
		String baname = ois.readUTF();
		String screason = ois.readUTF();
		String bazhuname = ois.readUTF();
		String sql = "update bazhuname set bazhuname='' where whichba='"+baname+"'";
		DataConnect.getStatement().executeUpdate(sql);
		String sql2 = "insert into userreason values('" + bazhuname + "','您被撤销了吧主的资格，原因是："
		+ screason + "')";
		DataConnect.getStatement().executeUpdate(sql2);
		
	}
	public void setbazhu() throws IOException, SQLException, ClassNotFoundException{
		String baname = ois.readUTF();
		String screason = ois.readUTF();
		String bazhuname = ois.readUTF();
		String sql = "update bazhuname set bazhuname='"+bazhuname+"' where whichba='"+baname+"'";
		DataConnect.getStatement().executeUpdate(sql);
		String sql2 = "insert into userreason values('" + bazhuname + "','您被选为了吧主，原因是："
		+ screason + "')";
		DataConnect.getStatement().executeUpdate(sql2);
		
	}
	
	
	
	public void viewTietext2() throws SQLException, ClassNotFoundException, IOException{
		String sql = "select * from tietext  ";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<Tietext> tietexts = new ArrayList<Tietext>();
		while(rs.next()){
			tietexts.add(new Tietext(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			
		}
		oos.writeObject(tietexts);
		oos.flush();
	}
	
	
	public void deletetext() throws SQLException, ClassNotFoundException, IOException{
		String writer = ois.readUTF();
		String title = ois.readUTF();
		String screason = ois.readUTF();
		String sql="delete from tietext where title='"+title+"'";
		DataConnect.getStatement().execute(sql);
		String sql2 = "insert into userreason values('" + writer + "','您的" + title + "帖子已被删除，原因是："
		+ screason + "')";
		DataConnect.getStatement().executeUpdate(sql2);
	}
	
	
	public void loaduserinform() throws IOException, SQLException, ClassNotFoundException{
		String username = ois.readUTF();
		String sql = "select * from userreason where user='"+username+"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		String string = "";
		while (rs.next()) {
			string +=  rs.getString(2) ;
			string += "\n";
		}
		oos.writeUTF(string);
		oos.flush();
	}
	
	public void SQbazhu() throws IOException, SQLException, ClassNotFoundException{
		String name =ois.readUTF();
		String sqreason = ois.readUTF();
		String sql ="insert into sendreason values('" + name + "', ' 想要申请吧主，原因是:" + sqreason + "')";
		DataConnect.getStatement().executeUpdate(sql);
	
	}
	
	public void readsendinform() throws SQLException, ClassNotFoundException, IOException{
		String sql = "select * from sendreason ";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		String string = "";
		while (rs.next()) {
			string +=  "用户"+rs.getString(1)+":"+rs.getString(2)+"\n";
			string += "\n";
		}
		oos.writeUTF(string);
		oos.flush();
	}
	
	public void bazhulogin() throws IOException, SQLException, ClassNotFoundException{
		String name = ois.readUTF();
		String baname = ois.readUTF();
		String sql = "select * from bazhuname where bazhuname='" + name + "' and whichBa ='" + baname + "'";
		int i = 0;
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		if (rs.next())
			i = 1;
		oos.writeInt(i);
		oos.flush();
	}
	public void changepw() throws IOException, SQLException, ClassNotFoundException{
		String name = ois.readUTF();
		String newpw = ois.readUTF();
		String sql = "update user set pw='"+newpw+"' where name='"+name+"'";
		DataConnect.getStatement().executeUpdate(sql);
		
	}
	
	public void reply() throws IOException, SQLException, ClassNotFoundException {
		String tietitle = ois.readUTF();
		String name = ois.readUTF();
		String replytext = ois.readUTF();
		String sql = "insert into reply values('" + tietitle + "','" + name + "','"
		+ replytext + "')";
		DataConnect.getStatement().executeUpdate(sql);
	}
	
	public void loadreply() throws IOException, SQLException, ClassNotFoundException{
		String tietitle = ois.readUTF();
		String sql = "select * from reply where tietitle = '"+tietitle+"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		String string = "";
		while (rs.next()) {
			string += "用户[" + rs.getString(2) + "]" +": "+ rs.getString(3) + "\n";
			string += "\n";
		}
		oos.writeUTF(string);
		oos.flush();
	}
	
	public void addgreattext() throws IOException, SQLException, ClassNotFoundException{
		String title = ois.readUTF();
		String name = ois.readUTF();
		String whichba = ois.readUTF();
		String sql ="insert into greattext values('" + title + "','" + name + "','"
		+ whichba + "')";
		DataConnect.getStatement().executeUpdate(sql);
	}
	
	public void viewGreattext() throws SQLException, ClassNotFoundException, IOException{
		String whichba = ois.readUTF();
		String sql = "select * from greattext where whichba='" + whichba +"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<Greattext> greattexts = new ArrayList<Greattext>();
		while(rs.next()){
			greattexts.add(new Greattext(rs.getString(1),rs.getString(2),rs.getString(3)));
			
		}
		oos.writeObject(greattexts);
		oos.flush();
	}
	
	public void deletegreattext() throws IOException, SQLException, ClassNotFoundException{
		String title = ois.readUTF();
		String sql="delete from greattext where greattext='"+title+"'";
		DataConnect.getStatement().execute(sql);
	}
	
	public void uploadjbreason() throws IOException, SQLException, ClassNotFoundException{
		String tiename = ois.readUTF();
		String username = ois.readUTF();
		String baname = ois.readUTF();
		String reason = ois.readUTF();
		String sql = "insert into jbreason values('帖子" + tiename + "','" + username + "','"+ baname + "','原因是" + reason + "')";
		DataConnect.getStatement().executeUpdate(sql);
	}
	
	public void setlevel() throws IOException, SQLException, ClassNotFoundException{
		String lv1 = ois.readUTF();
		String lv2 = ois.readUTF();
		String lv3 = ois.readUTF();
		String whichba = ois.readUTF();
		String sql = "update levelset set lv1='"+lv1+"',lv2='"+lv2+"',lv3='"+lv3+"' where whichba='"+whichba+"'";
		DataConnect.getStatement().executeUpdate(sql);
	}
	
	public void level() throws IOException{
		String name = ois.readUTF();
		String baname = ois.readUTF();
		int i = 0;
		String sql = "select * from tietext where writer='" + name + "' and whichBa ='" + baname + "'";
		String sql2 = "select * from levelset where  whichBa ='" + baname + "'";
		try {
			ResultSet rs = DataConnect.getStatement().executeQuery(sql);
			while(rs.next()){
				i +=1; 
			}
			rs.close();
			ResultSet rs2 = DataConnect.getStatement().executeQuery(sql2);
			
			if(rs2.next()){
				if(i<=0){
				oos.writeUTF("您还没有称号");
				oos.flush();
				}
				else if(i>0&&i<=5){
					oos.writeUTF(rs2.getString(1));
					oos.flush();
				}
				else if(i>5&&i<=10){
					oos.writeUTF(rs2.getString(2));
					oos.flush();
				}
				else if(i>10){
					oos.writeUTF(rs2.getString(3));
					oos.flush();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void viewJBreason() throws SQLException, ClassNotFoundException, IOException{
		String baname = ois.readUTF();
		String sql = "select * from jbreason where baname='" + baname +"'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		String string = "";
		while (rs.next()) {
			string += "用户[" + rs.getString(2) + "]" +"举报"+rs.getString(3)+ rs.getString(1) + rs.getString(4)+"\n";
			string += "\n";
		}
		oos.writeUTF(string);
		oos.flush();
	}
	
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Baname() throws SQLException, ClassNotFoundException, IOException{
		String sql = "select * from baname";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		ArrayList<Baname> banames = new ArrayList<Baname>();
		while(rs.next()){
			banames.add(new Baname(rs.getString(1)));
			
		}
		oos.writeObject(banames);
		oos.flush();
	}
	

	
	
	public void intoba() throws SQLException, ClassNotFoundException, IOException{
		Baname b = null;
		String baname = ois.readUTF();
		String sql = "select * from baname where baname='" + baname +  "'";
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		if (rs.next())
			b = new Baname(rs.getString(1));
		oos.writeObject(b);
		oos.flush();
	}
	
	public void qiandao() throws IOException, SQLException, ClassNotFoundException{
		String nowtime = ois.readUTF();
		String username = ois.readUTF();
		String sql = "select * from qiandao where user='" + username + "' ";
		String sql2 = "insert into qiandao values('" + username + "','" + 1 + "','"
		+ nowtime + "')";
		String sql3 = "update qiandao set date='"+nowtime+"',daynumber=daynumber+1 where user='"+username+"'";
		int i = 0;
		ResultSet rs = DataConnect.getStatement().executeQuery(sql);
		if (rs.next()){
			String otime =rs.getString(3); 
			if(nowtime.equals(otime)){
				i=rs.getInt(2);
				}
			else{
				i=rs.getInt(2)+1;
				DataConnect.getStatement().execute(sql3);
			}
			}
		else{
			DataConnect.getStatement().executeUpdate(sql2);
			i = 1;
		}
		
		oos.writeInt(i);
		oos.flush();
		
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		ois = new ObjectInputStream(s.getInputStream());
		oos = new ObjectOutputStream(s.getOutputStream());
		int command = ois.readInt();
		if (command == LOGIN) { 
			login();
		}
		if (command == REGISTER) {
			register();
		}
		if (command == UPLOAD) {
			upLoadFile();
		}
		if (command == 1006) {
			loadFile();
		}
		if (command == TIETEXT) {
			uploadText();
		}
		if (command == view) {
			
		}
		
		if (command == VIEWDATE) {
			viewDate();
		}
		if (command == VIEWTIETEXT) {
			viewTietext();
		}
		if (command == DELETEUSER) {
			deleteuser();
		}
		if (command == READTEXT) {
			readtext();
		}
		if (command == SPUSERLOGIN) {
			superuserlogin();
		}
		if (command == BANAME) {
			Baname();
		}
		if (command == INTOBA) {
			intoba();
		}
		if (command == VIEWBAZHU) {
			viewBazhu();
		}
		if (command == DELETEBAZHU) {
			deletebazhu();
		}
		if (command == SETBAZHU) {
			setbazhu();
		}
		if (command == VIEWTIETEXT2) {
			viewTietext2();
		}
		if (command == DELETETEXT) {
			deletetext();
		}
		if (command == LOADUSERINFORM) {
			loaduserinform();
		}
		if (command == SQBAZHU) {
			SQbazhu();
		}
		if (command == READSENDINFORM) {
			readsendinform();
		}
		if (command == BAZHULOGIN) {
			bazhulogin();
		}
		if (command == CHANGEPW) {
			changepw();
		}
		if (command == REPLY) {
			reply();
		}
		if (command == LOADREPLY) {
			loadreply();
		}
		if (command == ADDGREATTEXT) {
			addgreattext();
		}
		if (command == VIEWGREATTEXT) {
			viewGreattext();
		}
		if (command == DELETEGREATTEXT) {
			deletegreattext();
		}
		if (command == UPLOADJBREASON) {
			uploadjbreason();
		}
		if (command == SETLEVEL) {
			setlevel();
		}
		if (command == 4000) {
			level();
		}
		if (command == VIEWJBREASON) {
			viewJBreason();
		}
		if (command == QIANDAO) {
			qiandao();
		}
		
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
