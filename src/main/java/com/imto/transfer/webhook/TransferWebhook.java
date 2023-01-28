package com.imto.transfer.webhook;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.imto.transfer.dto.TransferWebhookDTO;
import com.imto.transfer.service.TansferService;
import com.imto.transfer.service.TansferServiceImpl;


@Path("webhook")
public class TransferWebhook {

	TansferService transactionService = new TansferServiceImpl();		

	
	/**
	 * create(transfer data)
	 * 
	 * Receives webhook request and updates the specified record.
	 * 
	 * @param data - JSON object representing the webhook request
	 * @return -> Bad Request: if the data received on the message's body is not
	 *         valid as a request -> Okay: if the request goes through 
	 *         successfully  200
	 */
	@POST
	@Path("transfers/transfer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(TransferWebhookDTO data) {
		return transactionService.recieveRequest(data);
	}



	

}
