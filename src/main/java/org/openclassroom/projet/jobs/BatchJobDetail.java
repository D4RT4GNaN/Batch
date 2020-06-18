package org.openclassroom.projet.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

/**
 * --------------------------------------------
 *      Config Class for Job with JobBuilder
 * --------------------------------------------
 */
public class BatchJobDetail {

    // ------------------------- Attributes --------------------------
    private JobDetail jobDetail;


    // -------------------------- Getter -----------------------------
    public JobDetail getJobDetail() {
        return jobDetail;
    }


    // -------------------------- Methods ----------------------------
    public BatchJobDetail() {
        jobDetail = JobBuilder
                .newJob(BatchJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("jobName", "Checking Borrowing")
                .build();
    }

}
