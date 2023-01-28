package com.imto.transfer.datastore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.imto.transfer.dto.TransferData;
import com.imto.transfer.model.Transfer;

public class DataStore {
	private static Logger _log = Logger.getLogger(DataStore.class.getName());

	static public List<Transfer> transfers = new ArrayList<Transfer>();

	public static List<Transfer> getListOfTransfers() {
		
			TransferData trfd = new TransferData();
			trfd.setAmount(2000);
			trfd.setAccountNumber("******");
			trfd.setBankName("ACCESS BANK NIGERIA");
			trfd.setId(8416497);
			trfd.setBankCode("044");
			trfd.setFullName("John Doe");

			Date date = new GregorianCalendar(2021, Calendar.MARCH, 28).getTime();
			trfd.setCreatedAt(date);
			trfd.setDebitCurrency("NGN");
			trfd.setCurrency("NGN");
			trfd.setFee(10.75);
			trfd.setStatus("SUCCESSFUL");
			trfd.setReference("TX-refe123456-6-3-1");
			trfd.setNarration("Test for wallet to wallet");
			trfd.setCompleteMessage("Transaction was successful");
			trfd.setRequiresApproval(0);
			trfd.setIsApproved(1);

			Transfer tf = new Transfer();

			tf.setId(1);

			tf.setEvent("transfer.pending");

			tf.setEventType("Transfer");

			tf.setData(trfd);
			
			tf.setStatus(5);
			
			tf.setMessage("Pending");

			transfers.add(tf);


		return transfers;
	}

	public static Transfer getTransferByTransId(int transId) {

		transfers = getListOfTransfers();

		_log.info("transId");
		_log.info(transId);
		
		for (Transfer trnfs : transfers) {

			_log.info("trnfs.getData().getId()");

			_log.info(trnfs.getData().getId());
			if (trnfs.getData().getId() == transId) {

				_log.info("returning trnfs");

				_log.info(trnfs);

				return trnfs;
			}
		}

		return null;

	}

}
