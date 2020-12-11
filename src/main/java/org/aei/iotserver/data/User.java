package org.aei.iotserver.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	private Set<Device> devices;
	private String name;
	private String password;
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		devices = new HashSet<>();
	}
	public User() {
		
	}
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Device> getDevices() {
		return devices;
	}
	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}
	@Id
	public String getName() {
		return name;
	}
	public void setName(String userName) {
		this.name = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
