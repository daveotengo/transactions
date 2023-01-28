package com.imto.transfer.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class TransferWebhookDTO {
	
	private String event;

	@JsonProperty("event.type")
	private String eventType;
	
	private WebhookData data;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}



	public WebhookData getData() {
		return data;
	}

	public void setData(WebhookData data) {
		this.data = data;
	}

	@JsonProperty("event.type")
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	
	@Override
    public String toString() {
        String request = "{" +

				"\"event\": \""+ event +"\"," +


				"\"eventType\": \""+ eventType +"\"," +
				

                "\"data\" : \""+ data +"\"" +


                "}";

        return request;
    
	
	}
	
	

}
