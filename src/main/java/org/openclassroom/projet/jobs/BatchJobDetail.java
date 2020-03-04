package org.openclassroom.projet.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class BatchJobDetail {

    private JobDetail jobDetail;

    public BatchJobDetail() {
        jobDetail = JobBuilder
                .newJob(BatchJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("jobName", "Checking Loan")
                .build();
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

}
