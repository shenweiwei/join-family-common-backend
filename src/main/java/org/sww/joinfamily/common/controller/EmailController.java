package org.sww.joinfamily.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.sww.framework.transfer.http.builder.AsyncHttpDataTranObjectBuilder;
import org.sww.framework.transfer.http.dto.AsyncHttpDataTransferObject;
import org.sww.framework.transfer.http.dto.AsyncHttpResponseDTO;
import org.sww.joinfamily.common.dto.request.EmailRequestDTO;
import org.sww.joinfamily.common.dto.response.EmailResponseDTO;
import org.sww.joinfamily.common.manager.EmailManager;

@RestController()
@RequestMapping("/email")
public class EmailController {

	protected static Logger	logger	= LoggerFactory.getLogger(EmailController.class) ;
	
	@Autowired
	private EmailManager emailManager;
	
	public DeferredResult<AsyncHttpResponseDTO> sendMail(@RequestBody EmailRequestDTO emailRequestDTO) {
		AsyncHttpDataTransferObject asyncHttpDataTransferObject = AsyncHttpDataTranObjectBuilder.builder(EmailRequestDTO.class, EmailResponseDTO.class).build() ;
		emailManager.sendMail(mailInfo(asyncHttpDataTransferObject, emailRequestDTO));
		return asyncHttpDataTransferObject.getDeferredResult() ;
	}
	
	private AsyncHttpDataTransferObject mailInfo(AsyncHttpDataTransferObject asyncHttpDataTransferObject, EmailRequestDTO emailRequestDTO) {
		asyncHttpDataTransferObject.setInputDTO(emailRequestDTO) ;
		return asyncHttpDataTransferObject ;
	}
}
