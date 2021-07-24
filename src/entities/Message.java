package entities;

public class Message {
	private User sender;
	private int length;
	private String content;
	
	public Message(User sender, String content) {
		this.sender = sender;
		this.content = content;
	}
}
