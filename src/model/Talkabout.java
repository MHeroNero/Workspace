package model;

import java.io.Serializable;

public class Talkabout implements Serializable{
	private String reply;
	private String replyname;
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplytime() {
		return replyname;
	}
	public void setReplytime(String replytime) {
		this.replyname = replytime;
	}
	public Talkabout(String reply, String replytime) {
		super();
		this.reply = reply;
		this.replyname = replytime;
	}
}
