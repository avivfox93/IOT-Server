package org.aei.iotserver.boundary;

import java.util.Map;

public class DataPacketBoundary {
	private String deviceId;
	private Map<String,Object> values;
	
	public DataPacketBoundary() {}
	
	public DataPacketBoundary(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
	
	
}
