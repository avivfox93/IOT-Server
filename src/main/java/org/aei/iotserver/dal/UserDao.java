package org.aei.iotserver.dal;

import org.aei.iotserver.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends PagingAndSortingRepository<User, Long>  {	
	public User findByName(
			@Param("name") String name
			);
}
