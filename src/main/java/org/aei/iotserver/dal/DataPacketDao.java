package org.aei.iotserver.dal;

import java.util.Date;
import java.util.List;

import org.aei.iotserver.data.DataPacket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DataPacketDao extends PagingAndSortingRepository<DataPacket, Long>  {
	public DataPacket findById(@Param("id") String id);
	public List<DataPacket> findAllByDeviceId(
			@Param("deviceId") String id
			);
	public List<DataPacket> findAllByDeviceIdAndDateBetween(
			@Param("deviceId") String id,
			Date dateStart,
			Date dateEnd
			);
}
