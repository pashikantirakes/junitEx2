package in.rak.com;

public class ShippingAddress {

	String addressLine1;
	String city;
	String state;
	int zip;
	String country;
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public String getCountry() {
		return country;
	}
}
