package org.sww.joinfamily.common.manager.impl;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;
import org.sww.framework.transfer.http.dto.AsyncHttpDataTransferObject ;
import org.sww.joinfamily.common.manager.UserManager ;
import org.sww.joinfamily.common.service.UserService ;

@Component
public class UserManagerImpl implements UserManager{
	@Autowired
	private UserService userService;

	@Override
	public boolean addUserInfo(AsyncHttpDataTransferObject asyncHttpDataTransferObject) {
		// TODO Auto-generated method stub
		return false ;
	}
	
}
