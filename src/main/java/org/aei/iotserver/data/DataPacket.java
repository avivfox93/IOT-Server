package org.aei.iotserver.data;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.aei.iotserver.dal.MapToJsonConverter;

@Entity
@Table(name="DATA_PACKETS")
public class DataPacket {

    private String id;

	private Date date;
	private Map<String,Object> values;
	private String deviceId;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Convert(converter = MapToJsonConverter.class)
	@Lob
	public Map<String, Object> getValues() {
		return values;
	}

	public DataPacket() {
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "packet_timestamp")
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
