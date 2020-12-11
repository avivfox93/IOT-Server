package org.aei.iotserver.boundary;

import java.util.Date;

public class DataPacketRequest {
	private String deviceId = "";
	private Date from;
	private Date to;
	public DataPacketRequest() {
		
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	
	
	
}
