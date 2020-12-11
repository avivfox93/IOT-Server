package org.aei.iotserver.utils;

import org.aei.iotserver.boundary.DataPacketBoundary;
import org.aei.iotserver.data.DataPacket;

public class DataPacketConverter {
	public static DataPacket fromBoundary(DataPacketBoundary packet) {
		DataPacket result = new DataPacket();
		result.setDeviceId(packet.getDeviceId());
		result.setValues(packet.getValues());
		
		return result;
	}
}
