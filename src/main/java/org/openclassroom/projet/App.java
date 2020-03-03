package org.openclassroom.projet;

import org.openclassroom.projet.jobs.BatchJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello world!
 *
 */
public class App 
{
    @Autowired
    private static SchedulerFactory schedulerFactory;

    @Autowired
    private static JobDetail job;

    @Autowired
    private static Trigger trigger;

    public static void main( String[] args )
    {
        try {

            Scheduler sched = schedulerFactory.getScheduler();
            sched.scheduleJob(job, trigger);
            sched.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
