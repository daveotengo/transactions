package com.imto.transfer.scheduler;


import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class TrasferStatusCheckerScheduler {


	private  Logger log = Logger.getLogger(TrasferStatusCheckerScheduler.class.getName());

  public void run() throws Exception {
	  

    log.info("------- Initializing ----------------------");

    // First we must get a reference to a scheduler
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();

    log.info("------- Initialization Complete -----------");

    // computer a time that is on the next round minute
    Date runTime = evenMinuteDate(new Date());

    log.info("------- Scheduling Job  -------------------");

    // define the job and tie it to our HelloJob class
    JobDetail job = newJob(StatusCheckerJob.class).withIdentity("job1", "group1").build();

    // Trigger the job to run on the next round minute
    //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // Trigger the job to run every 5 seconds
    CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/5 * * * * ?"))
            .build();

    // Tell quartz to schedule the job using our trigger
    sched.scheduleJob(job, trigger);
    log.info(job.getKey() + " will run at: " + runTime);

    // Start up the scheduler (nothing can actually run until the
    // scheduler has been started)
    sched.start();

    log.info("------- Started Scheduler -----------------");

    // wait long enough so that the scheduler as an opportunity to
    // run the job!
  //  log.info("------- Waiting 65 seconds... -------------");
//    try {
//      // wait 65 seconds to show job
//      Thread.sleep(65L * 1000L);
//      // executing...
//    } catch (Exception e) {
//      //
//    }

    // shut down the scheduler
//    log.info("------- Shutting Down ---------------------");
//    sched.shutdown(true);
//    log.info("------- Shutdown Complete -----------------");
  }



}