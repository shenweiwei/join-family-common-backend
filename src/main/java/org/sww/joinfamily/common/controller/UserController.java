package org.sww.joinfamily.common.controller ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping ;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/register")
	public DeferredResult<AsyncHttpResponseDTO> addUserInfo(@RequestBody UserRequestDTO userRequestDTO) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
		userManager.addUserInfo(userInfo(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	@PutMapping("/edit/{id}")
	public DeferredResult<AsyncHttpResponseDTO> editUserInfo(@PathVariable Long id,@RequestBody UserRequestDTO userRequestDTO) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
		userManager.addUserInfo(userInfo(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	@GetMapping("/login/{id}")
	public DeferredResult<AsyncHttpResponseDTO> loginById(@PathVariable Long id) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
//		userManager.addUserInfo(userInfo(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	@GetMapping("/find/{id}")
	public DeferredResult<AsyncHttpResponseDTO> findUserInfoById(@PathVariable Long id) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
//		userManager.addUserInfo(userInfo(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	@GetMapping("/find/list")
	public DeferredResult<AsyncHttpResponseDTO> findUserInfoList(@RequestBody UserRequestDTO userRequestDTO) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(UserRequestDTO.class, UserResponseDTO.class).build() ;
		userManager.addUserInfo(userInfo(asyncHttpDataTransferObject, userRequestDTO)) ;
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	private AsyncHttpDataTransferObject userInfo(AsyncHttpDataTransferObject asyncHttpDataTransferObject, UserRequestDTO userRequestDTO) {
		asyncHttpDataTransferObject.setInputDTO(userRequestDTO) ;
		return asyncHttpDataTransferObject ;
	}
}
