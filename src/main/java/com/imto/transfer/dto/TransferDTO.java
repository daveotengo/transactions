package com.imto.transfer.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class TransferDTO {

	@JsonProperty("account_bank")
	private String accountBank;

	@JsonProperty("account_number")
	private String accountNumber;
	
	private Integer amount;
	
	private String currency;
	
	private String narration;
	
	private String reference;
	
	@JsonProperty("callback_url")
    public String callbackUrl;

	@JsonProperty("debit_currency")
    public String debitCurrency;

	@JsonProperty("account_bank")
	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	@JsonProperty("account_number")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	
	
	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getDebitCurrency() {
		return debitCurrency;
	}

	public void setDebitCurrency(String debitCurrency) {
		this.debitCurrency = debitCurrency;
	}

	@Override
    public String toString() {
        String request = "{" +

				"\"accountBank\": \""+ accountBank +"\"," +


				"\"accountNumber\": \""+ accountNumber +"\"," +
				
				
				"\"currency\": \""+ currency +"\"," +
				
				"\"amount\": \""+ amount +"\"," +
				
				
				"\"narration\": \""+ narration +"\"," +
				
				"\"reference\": \""+ reference +"\"," +

				"\"callbackUrl\": \""+ callbackUrl +"\"," +

                "\"debitCurrency\" : \""+ debitCurrency +"\"" +


                "}";

        return request;
    
	
	}
	
}


