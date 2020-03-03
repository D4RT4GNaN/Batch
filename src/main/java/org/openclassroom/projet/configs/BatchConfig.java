package org.openclassroom.projet.configs;

import org.openclassroom.projet.jobs.BatchJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;

public class BatchConfig {

    @Bean
    public JobDetail jobDetail() {
        JobDetail job = JobBuilder
                .newJob(BatchJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        return job;
    }

    @Bean
    public Trigger trigger() {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(40)
                                .repeatForever()
                )
                .build();
        return trigger;
    }

    @Bean
    public SchedulerFactory schedulerFactory() {
        return new StdSchedulerFactory();
    }

}
