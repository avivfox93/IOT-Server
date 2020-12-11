package org.aei.iotserver.boundary;

import java.util.Map;

public class DeviceSettings {
	private String deviceId;
	private Map<String,Object> settings;
	
	public DeviceSettings() {}
	
	public DeviceSettings(String deviceId, Map<String,Object> settings) {
		this.deviceId = deviceId;
		this.settings = settings;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Map<String, Object> getSettings() {
		return settings;
	}

	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
}
