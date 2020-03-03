package org.openclassroom.projet;

import org.openclassroom.projet.configs.BatchConfig;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Scheduler sched = BatchConfig.getScheduler();
            sched.scheduleJob(BatchConfig.getJobDetail(), BatchConfig.getTrigger());
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
