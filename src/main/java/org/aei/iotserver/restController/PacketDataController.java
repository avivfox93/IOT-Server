package org.aei.iotserver.restController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.aei.iotserver.boundary.DataPacketBoundary;
import org.aei.iotserver.boundary.DataPacketRequest;
import org.aei.iotserver.dal.DataPacketDao;
import org.aei.iotserver.dal.DeviceDao;
import org.aei.iotserver.data.DataPacket;
import org.aei.iotserver.utils.DataPacketConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacketDataController {
	
	@Autowired
	private DataPacketDao dataPacketDao;
	
	@Autowired
	private DeviceDao deviceDao;
	
	@RequestMapping(path = "/api/device/data",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public DataPacket addPacket(@RequestBody DataPacketBoundary dataPacketBoundary) {
		DataPacket result = DataPacketConverter.fromBoundary(dataPacketBoundary);
		if(deviceDao.findByDeviceId(dataPacketBoundary.getDeviceId()) == null) {
			throw new RuntimeException("Device not registerd!");
		}
		result.setId(UUID.randomUUID().toString());
		result.setDate(new Date());
		result = dataPacketDao.save(result);
		return result;
	}
	
	@RequestMapping(path = "/api/data",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public List<DataPacket> getPackets(
			@RequestBody DataPacketRequest request
			) throws ParseException {
		if(request.getFrom() != null && request.getTo() != null) {
			return dataPacketDao.findAllByDeviceIdAndDateBetween(request.getDeviceId(), request.getFrom(), request.getTo());
		}else {
			return dataPacketDao.findAllByDeviceId(request.getDeviceId());
		}
	}
}
