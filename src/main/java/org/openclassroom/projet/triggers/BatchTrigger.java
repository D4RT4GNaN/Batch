package org.openclassroom.projet.triggers;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class BatchTrigger {

    private Trigger trigger;

    public Trigger getTrigger() {
        return trigger;
    }

    public BatchTrigger() {
        this.trigger = TriggerBuilder
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
    }

}
