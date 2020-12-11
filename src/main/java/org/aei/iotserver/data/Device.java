package org.aei.iotserver.data;

import java.util.Map;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.aei.iotserver.dal.MapToJsonConverter;

@Entity
@Table(name="DEVICES")
public class Device {
	private String deviceId;
	private Map<String,Object> settings;
	public Device(String deviceId, Map<String, Object> settings) {
		super();
		this.deviceId = deviceId;
		this.settings = settings;
	}
	public Device() {}
	@Id
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@Convert(converter = MapToJsonConverter.class)
	@Lob
	public Map<String, Object> getSettings() {
		return settings;
	}
	public void setSettings(Map<String, Object> settings) {
		this.settings = settings;
	}
}
