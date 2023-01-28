package com.imto.transfer.response;

public class TransferResponse {
	public int status;
	public String message;
	public Object data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String request = "{" +

				"\"status\": \"" + status + "\"," +

				"\"message\": \"" + message + "\"," +

				"\"data\" : \"" + data + "\"" +

				"}";

		return request;

	}
}
