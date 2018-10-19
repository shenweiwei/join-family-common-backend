package org.sww.joinfamily.common.manager;

import org.sww.framework.transfer.http.dto.AsyncHttpDataTransferObject;

public interface EmailManager {

	public void sendMail(AsyncHttpDataTransferObject asyncHttpDataTransferObject);
}
