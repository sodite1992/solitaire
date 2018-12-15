package com.wkgao.solitaire.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzeConfig {


    /*
    @Bean
    public Trigger testQuartzTrigger() {
        JobDetail jobDetail = JobBuilder.newJob(ScheduleTaskDemo.class)
                .withIdentity("ScheduleTaskDemo")
                .storeDurably().build();

        //cron方式，每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity("ScheduleTaskDemo")*/
//                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
//                .build();
//    }
}
