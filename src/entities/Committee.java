package entities;

public class Committee {
	int id;
	String name;
	String jurisdiction;
	String address;
	String city;
	String state;
	String zip;
	String phone;
	String url;
	String staffContact;
	
	public Committee(int id, String name, String jurisdiction, String address, 
			String city, String zip, String phone, String url, String staffContact) {
		
		this.id = id;
		this.name = name;
		this.jurisdiction = jurisdiction;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.url = url;
		this.staffContact = staffContact;
	}
	
	public int gtId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getJurisdiction() {
		return this.jurisdiction;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getStaffContact() {
		return this.staffContact;
	}
}


