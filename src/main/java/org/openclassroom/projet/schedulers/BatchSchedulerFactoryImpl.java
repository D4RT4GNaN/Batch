package org.openclassroom.projet.schedulers;

import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class BatchSchedulerFactoryImpl {

    private SchedulerFactory schedulerFactory;

    public BatchSchedulerFactoryImpl() {
        schedulerFactory = new StdSchedulerFactory();
    }

    public SchedulerFactory getSchedulerFactory() {
        return schedulerFactory;
    }
}
