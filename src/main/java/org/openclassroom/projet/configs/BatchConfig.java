package org.openclassroom.projet.configs;

import org.openclassroom.projet.jobs.BatchJobDetail;
import org.openclassroom.projet.triggers.BatchTrigger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * ----------------------------------------------
 *     Config Class for Quartz Scheduler API
 * ----------------------------------------------
 */
public class BatchConfig {

    // ------------------------- Attributes --------------------------
    private static BatchTrigger trigger = new BatchTrigger();
    private static BatchJobDetail jobDetail = new BatchJobDetail();
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();


    // -------------------------- Getters ----------------------------
    public static Trigger getTrigger() {
        return trigger.getTrigger();
    }

    public static JobDetail getJobDetail() {
        return jobDetail.getJobDetail();
    }

    public static Scheduler getScheduler() throws SchedulerException {
        return schedulerFactory.getScheduler();
    }

}
