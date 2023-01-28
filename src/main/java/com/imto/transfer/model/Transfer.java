package com.imto.transfer.model;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;

import com.imto.transfer.dto.TransferData;

public class Transfer {

	@NotNull
	@JsonProperty("id")
	private Integer id;

	private String event;

	@JsonProperty("event.type")
	private String eventType;

	private TransferData data;
	
	private int status;
	
	private String message;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	

	public TransferData getData() {
		return data;
	}

	public void setData(TransferData data) {
		this.data = data;
	}
	
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Transfer() {
		super();
	}

	@Override
	public String toString() {
		String response = "{" +

				"\"id\": \"" + id + "\"," +

				"\"event\": \"" + event + "\"," +

				"\"eventType\" : \"" + eventType + "\"," +
				"\"data\" : \"" + data + "\"," +

				"\"status\" : \"" + status + "\"," +
				"\"message\" : \"" + message + "\"" +


				"}";

		return response;
	}

}
