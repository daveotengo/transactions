package com.imto.transfer.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.imto.transfer.dto.TransferDTO;
import com.imto.transfer.service.TansferService;
import com.imto.transfer.service.TansferServiceImpl;

@Path("transfers")
public class TransferEndPoint {

	TansferService transferService = new TansferServiceImpl();

	/**
	 * getTransferStatus()
	 * 
	 * Gets the Status of a transfer by the tranferId
	 * 
	 * .
	 */
	@GET
	@Path("/transfer/status/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransferStatus(@PathParam("id") int transferId) {
		return transferService.getTransactionStatus(transferId);
	}

	/**
	 * create(transfer data)
	 * 
	 * Creates a transfer to the system.
	 * 
	 * @param data - JSON object representing the transfer
	 * @return -> Bad Request: if the data received on the message's body is not
	 *         valid as a transfer -> Created: if the request goes through
	 *         successfully return 200
	 */
	@POST
	@Path("transfer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTransfer(TransferDTO data) {
		return transferService.createTransfer(data);
	}

}
