package com.imto.transfer.service;

import javax.ws.rs.core.Response;

import com.imto.transfer.dto.TransferDTO;
import com.imto.transfer.dto.TransferWebhookDTO;


public interface TansferService {
	
	public Response createTransfer(TransferDTO data);
	
	public Response getTransactionStatus(int transferId);

	public Response recieveRequest(TransferWebhookDTO data);
}
