package org.aei.iotserver.restController;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.aei.iotserver.boundary.DeviceSettings;
import org.aei.iotserver.dal.DeviceDao;
import org.aei.iotserver.dal.UserDao;
import org.aei.iotserver.data.Device;
import org.aei.iotserver.data.User;
import org.aei.iotserver.security.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DeviceDao deviceDao;
	
	@Autowired
	private CurrentUserService CurrentUserService;
	
	
	@RequestMapping(
			value = "/api/devices",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	Set<Device> getAllDevices(){
		User user = userDao.findByName(CurrentUserService.getCurrentUsername());
		if(user == null) {
			throw new RuntimeException("Username does not exist!");
		}
		return user.getDevices();
	}
	
	@RequestMapping(
			value = "/api/devices",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	Device createNewDevice() {

		Device device = new Device();
		User user = userDao.findByName(CurrentUserService.getCurrentUsername());
		device.setDeviceId(UUID.randomUUID().toString());
		device.setSettings(new HashMap<>());
		user.getDevices().add(device);
		deviceDao.save(device);
		userDao.save(user);
		return device;
	}
	
	@RequestMapping(
			value = "/api/devices",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	void setDeviceSettings(@RequestBody DeviceSettings deviceBoundary) {
		Device device = deviceDao.findByDeviceId(deviceBoundary.getDeviceId());
		if(device == null) {
			throw new RuntimeException("Device does not exist!");
		}
		device.setSettings(deviceBoundary.getSettings());
		deviceDao.save(device);
	}
}

