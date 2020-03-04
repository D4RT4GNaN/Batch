package org.openclassroom.projet.jobs;

import generated.libraryservice.LibraryService;
import generated.libraryservice.LibraryServiceService;
import generated.libraryservice.Loan;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;

import java.util.List;

public class BatchJob implements Job {

    private LibraryService libraryService = new LibraryServiceService().getLibraryServicePort();

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Job start: " + context.getFireTime());
        JobDetail jobDetail = context.getJobDetail();
        System.out.println("Job name is: " + jobDetail.getJobDataMap().getString("jobName"));

        List<Loan> loansOverdue = libraryService.checkExpiration();

        for(Loan loan : loansOverdue) {
            System.out.println(" * - A mail was sent to user " + loan.getUserID() + " for book with the reference " + loan.getBookReference());
        }

        System.out.println("Job end: " + context.getJobRunTime() + ", key: " + jobDetail.getKey());
        System.out.println("Job next scheduled time: " + context.getNextFireTime());
        System.out.println("--------------------------------------------------------------------");
    }

}
