package org.aei.iotserver.dal;

import org.aei.iotserver.data.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DeviceDao extends PagingAndSortingRepository<Device, Long>  {
	public Device findByDeviceId(
			@Param("deviceId") String id
			);
}
