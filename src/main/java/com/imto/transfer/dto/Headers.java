package com.imto.transfer.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Headers {
	@JsonProperty("Authorization")
	private String authorization;

	public Headers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("Authorization")
	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		String request = "{" +

				"\"authorization\" : \"" + authorization + "\"" +

				"}";

		return request;

	}

}
