package org.openclassroom.projet.triggers;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Properties;

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
                                .withIntervalInSeconds(getIntervalInSeconds())
                                .repeatForever()
                )
                .build();
    }

    private String getProperties() {
        Properties properties = new Properties();

        try {
            properties.load(BatchTrigger.class.getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("batch.scheduler.intervalTimeInSecond");
    }

    private int getIntervalInSeconds() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object result = null;

        try {
            result = engine.eval(getProperties());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return (int) result;
    }

}
