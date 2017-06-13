package com.dodo.model;

import java.io.Serializable;
import java.util.List;

public class Geocodings /*implements Serializable*/  {
	List<Geocoding> list;

	public Geocodings() {
		super();
	}

	public Geocodings(List<Geocoding> list) {
		super();
		this.list = list;
	}

	public List<Geocoding> getList() {
		return list;
	}

	public void setList(List<Geocoding> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		Geocodings other = (Geocodings) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geocodings [list=" + list + "]";
	}
	
}
