package org.openclassroom.projet.triggers;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Properties;

/**
 * ----------------------------------------------------
 *     Config Class for Trigger with TriggerBuilder
 * ----------------------------------------------------
 */
public class BatchTrigger {

    // ------------------------ Attributes ---------------------------
    private Trigger trigger;


    // ----------------------- Constructor ---------------------------
    public BatchTrigger() {
        // New trigger with simple scheduler that repeats itself every x amount of time, every time
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


    // -------------------------- Getter -----------------------------
    public Trigger getTrigger() {
        return trigger;
    }


    // --------------------- Privates Methods ------------------------
    // Return the value of batch.scheduler.intervalTimeInSecond in String
    private String getProperties() {
        Properties properties = new Properties();

        try {
            properties.load(BatchTrigger.class.getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("batch.scheduler.intervalTimeInSecond");
    }

    // Convert the String value of batch.scheduler.intervalTimeInSecond in int value
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
