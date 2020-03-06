package org.openclassroom.projet.jobs;

import generated.libraryservice.LibraryService;
import generated.libraryservice.LibraryServiceService;
import generated.libraryservice.Loan;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BatchJob implements Job {

    private LibraryService libraryService = new LibraryServiceService().getLibraryServicePort();
    private static Logger LOGGER = LoggerFactory.getLogger(BatchJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        LOGGER.info("--------------------------------------------------------------------");
        LOGGER.info("Job start: " + context.getFireTime());
        JobDetail jobDetail = context.getJobDetail();
        LOGGER.info("Job name is: " + jobDetail.getJobDataMap().getString("jobName"));

        List<Loan> loansOverdue = libraryService.checkExpiration();

        for(Loan loan : loansOverdue) {
            LOGGER.info(" * - A mail was sent to user " + loan.getUserID() + " for book with the reference " + loan.getBookReference());
        }

        LOGGER.info("Job end: " + context.getJobRunTime() + ", key: " + jobDetail.getKey());
        LOGGER.info("Job next scheduled time: " + context.getNextFireTime());
        LOGGER.info("--------------------------------------------------------------------");
    }

}
