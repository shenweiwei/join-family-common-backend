package org.sww.joinfamily.common.controller ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.context.request.async.DeferredResult ;
import org.sww.framework.transfer.http.builder.AsyncHttpDataTranObjectBuilder ;
import org.sww.framework.transfer.http.dto.AsyncHttpDataTransferObject ;
import org.sww.framework.transfer.http.dto.AsyncHttpResponseDTO ;
import org.sww.joinfamily.common.dto.request.UserRequestDTO ;
import org.sww.joinfamily.common.dto.response.UserResponseDTO ;
import org.sww.joinfamily.common.manager.UserManager ;

@RestController
@RequestMapping("/user")
public class UserController {
	
	protected static Logger	logger	= LoggerFactory.getLogger(UserController.class) ;
	
	@Autowired
	private UserManager			userManager ;
	
	@PostMapping("/add")
	public DeferredResult<AsyncHttpResponseDTO> addUserInfo(@RequestBody UserRequestDTO userRequestDTO) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
		userManager.addUserInfo(initUserRequestDto(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	private AsyncHttpDataTransferObject initUserRequestDto(AsyncHttpDataTransferObject asyncHttpDataTransferObject, UserRequestDTO userRequestDTO) {
		asyncHttpDataTransferObject.setInputDTO(userRequestDTO) ;
		return asyncHttpDataTransferObject ;
	}
}
