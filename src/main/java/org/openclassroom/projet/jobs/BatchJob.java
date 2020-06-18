package org.openclassroom.projet.jobs;

import generatedlibraryservice.GeneratedBook;
import generatedlibraryservice.GeneratedBorrowing;
import generatedlibraryservice.LibraryService;
import generatedlibraryservice.LibraryServiceService;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ----------------------------------------
 *         Class running a job
 * ----------------------------------------
 */
public class BatchJob implements Job {

    // ------------------------- Attributes --------------------------
    // Web Service Interface
    private LibraryService libraryService = new LibraryServiceService().getLibraryServicePort();

    // SLF4J Logger associated in background with Log4J2
    private static Logger LOGGER = LoggerFactory.getLogger(BatchJob.class);


    // -------------------------- Methods ----------------------------
    // Job calling checkExpiration method that returns a list of emails sent
    @Override
    public void execute(JobExecutionContext context) {
        LOGGER.info("--------------------------------------------------------------------");
        LOGGER.info("Job start: " + context.getFireTime());
        JobDetail jobDetail = context.getJobDetail();
        LOGGER.info("Job name is: " + jobDetail.getJobDataMap().getString("jobName"));

        List<GeneratedBorrowing> borrowingsOverdue = libraryService.checkExpiration();

        for(GeneratedBorrowing generatedBorrowing : borrowingsOverdue) {
            LOGGER.info(" * - A mail was sent to user " + generatedBorrowing.getUsager().getId() + " for book with the reference " + generatedBorrowing.getBook().getReference());
        }

        LOGGER.info("Job end: " + context.getJobRunTime() + ", key: " + jobDetail.getKey());
        LOGGER.info("Job next scheduled time: " + context.getNextFireTime());
        LOGGER.info("--------------------------------------------------------------------");
    }

}
