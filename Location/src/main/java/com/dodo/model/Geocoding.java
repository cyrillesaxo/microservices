package com.dodo.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@XmlRootElement(name = "Geocoding")
@Document(collection = "Geocodings")
public class Geocoding implements Serializable {
    @Id
    private String geocodingId;
	private String longitude;
	private String latitude;
	private String address;
	
	public Geocoding() {
		super();
	}
	public Geocoding(String geocodingId, String longitude, String latitude, String address) {
		super();
		this.geocodingId = geocodingId;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
	}
	public Geocoding(String longitude, String latitude, String address) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
	}
	public Geocoding(String longitude, String latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getGeocodingId() {
		return geocodingId;
	}
	public void setGeocodingId(String geocodingId) {
		this.geocodingId = geocodingId;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((geocodingId == null) ? 0 : geocodingId.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geocoding other = (Geocoding) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (geocodingId == null) {
			if (other.geocodingId != null)
				return false;
		} else if (!geocodingId.equals(other.geocodingId))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Geocoding [geocodingId=" + geocodingId + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", address=" + address + "]";
	}

}
