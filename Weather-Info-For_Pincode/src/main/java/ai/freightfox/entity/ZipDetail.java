package ai.freightfox.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZipDetail {

	@Id
	private String zip;

	private String lat;

	private String lon;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

}
