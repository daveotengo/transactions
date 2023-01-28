package com.imto.transfer.response;

import com.imto.transfer.model.Transfer;

public class WebhookTransferResponse {
	public String status;
	public String message;
	public Transfer transfer;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	@Override
	public String toString() {
		String request = "{" +

				"\"status\": \"" + status + "\"," +

				"\"message\": \"" + message + "\"," +

				"\"transfer\" : \"" + transfer + "\"" +

				"}";

		return request;

	}
}
