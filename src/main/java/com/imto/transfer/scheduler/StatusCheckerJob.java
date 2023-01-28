package com.imto.transfer.scheduler;



import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.imto.transfer.datastore.DataStore;
import com.imto.transfer.model.Transfer;
 

public class StatusCheckerJob implements Job {

	private static Logger _log = Logger.getLogger(StatusCheckerJob.class);

 
    public StatusCheckerJob() {
    }


    public void execute(JobExecutionContext context)
        throws JobExecutionException {

    	List<Transfer> listOfTransfer= DataStore.getListOfTransfers();
    	
    	for(Transfer trf: listOfTransfer)
    		if(trf.getEventType().equals("transfer.completed")&&trf.getStatus()!=0) {
    			trf.setStatus(0);
    			trf.setMessage("processed");
    			_log.info(trf);
    	        _log.info("Processed - "+trf.getId()+" at " + new Date());

    		}
    }

}