package com.imto.transfer.dto;

public class TransferStatusDTO {
	private String transferId;

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	@Override
	public String toString() {
		String request = "{" +

				"\"transferId\": \"" + transferId + "\"" +

				"}";

		return request;
	}

}
