package org.sww.joinfamily.common.dto.response ;

import org.sww.framework.transfer.http.dto.AsyncHttpResponseDTO ;

public class UserResponseDTO extends AsyncHttpResponseDTO {
	
	private boolean result ;
	
	public boolean isResult() {
		return result ;
	}
	
	public void setResult(boolean result) {
		this.result = result ;
	}
	
}
