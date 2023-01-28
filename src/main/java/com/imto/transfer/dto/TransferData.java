package com.imto.transfer.dto;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class TransferData{
    private int id;
    
	@JsonProperty("account_number")
    private String accountNumber;
	
	@JsonProperty("bank_code")
    private String bankCode;
	
	@JsonProperty("full_name")
    private String fullName;
	
	@JsonProperty("created_at")
    private Date createdAt;
	
    private String currency;
    
	@JsonProperty("debit_currency")
    private String debitCurrency;
	
    private int amount;
    
    private double fee;
    
    private String status;
    
    private String reference;
    
    private Object meta;
    
    private String narration;
    
	@JsonProperty("complete_message")
    private String completeMessage;
    
	@JsonProperty("requires_approval")
    private int requiresApproval;
    
	@JsonProperty("is_approved")
    private int isApproved;
    
	@JsonProperty("bank_name")
    private String bankName;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDebitCurrency() {
		return debitCurrency;
	}
	public void setDebitCurrency(String debitCurrency) {
		this.debitCurrency = debitCurrency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Object getMeta() {
		return meta;
	}
	public void setMeta(Object meta) {
		this.meta = meta;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getCompleteMessage() {
		return completeMessage;
	}
	public void setCompleteMessage(String completeMessage) {
		this.completeMessage = completeMessage;
	}
	public int getRequiresApproval() {
		return requiresApproval;
	}
	public void setRequiresApproval(int requiresApproval) {
		this.requiresApproval = requiresApproval;
	}
	public int getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
    
	@Override
    public String toString() {
        String obj = "{" +

				"\"id\": \""+ id +"\"," +

				"\"accountNumber\": \""+ accountNumber +"\"," +
				
				"\"bankCode\": \""+ bankCode +"\"," +
				
				"\"fullName\": \""+ fullName +"\"," +
				
				"\"createdAt\": \""+ createdAt +"\"," +
				
				"\"currency\": \""+ currency +"\"," +
				
				"\"debitCurrency\": \""+ debitCurrency +"\"," +
				
				"\"fee\": \""+ fee +"\"," +
				
				"\"status\": \""+ status +"\"," +
				
				"\"reference\": \""+ reference +"\"," +
				
				"\"meta\": \""+ meta +"\"," +

				"\"narration\": \""+ narration +"\"," +

				"\"completeMessage\": \""+ completeMessage +"\"," +

				"\"requiresApproval\": \""+ requiresApproval +"\"," +
				
				"\"isApproved\": \""+ isApproved +"\"," +

                "\"bankName\" : \""+ bankName +"\"" +

                "}";

        return obj;
    }
    
}



