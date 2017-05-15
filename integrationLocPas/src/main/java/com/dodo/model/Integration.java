package com.dodo.model;

import java.util.Collection;

public class Integration {
	private String id;
	private Collection<Geocoding> locations;
	private Collection<Passenger> passengers;
	
	public Integration(String id, Collection<Geocoding> locations, Collection<Passenger> passengers) {
		super();
		this.id = id;
		this.locations = locations;
		this.passengers = passengers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Collection<Geocoding> getLocations() {
		return locations;
	}
	public void setLocations(Collection<Geocoding> locations) {
		this.locations = locations;
	}
	public Collection<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		result = prime * result + ((passengers == null) ? 0 : passengers.hashCode());
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
		Integration other = (Integration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (locations == null) {
			if (other.locations != null)
				return false;
		} else if (!locations.equals(other.locations))
			return false;
		if (passengers == null) {
			if (other.passengers != null)
				return false;
		} else if (!passengers.equals(other.passengers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Integration [id=" + id + ", locations=" + locations + ", passengers=" + passengers + "]";
	}
	
	
}
