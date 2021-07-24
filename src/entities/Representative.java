package entities;

public class Representative {
	private int id;
	private String fName;
	private String lName;
	private String type;
	private int stateID;
	private int district;
	private String party;
	
	public Representative(int id, String fName, String lName, String type, int stateID, int district, String party) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.type = type;
		this.stateID = stateID;
		this.district = district;
		this.party = party;
	}
	public int getId() {
		return this.id;
	}
	
	public String getFName() {
		return this.fName;
	}
	
	public String getLName() {
		return this.lName;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getDistrict() {
		return this.district;
	}
	
	public int getState() {
		return this.stateID;
	}
	public String getParty() {
		return this.party;
	}
	
	
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setState(int stateID) {
		this.stateID = stateID;
	}
	
	public void setDistrict(int district) {
		this.district = district;
	}
	
	public void setParty(String party) {
		this.party = party;
	}
	
}
