package com.example.util;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
 public class SaticScheduleTask {

    private  static  long begindate = 0 ;
    private  static  long enddate = 0 ;
    private   int  sun = 0;
    //3.添加定时任务
    //@Scheduled(cron = "2 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=5000)
    private void configureTasks() {

    }

    //*
    //     Cron表达式参数分别表示：
    //
    //    秒（0~59） 例如0/5表示每5秒
    //    分（0~59）
    //    时（0~23）
    //    日（0~31）的某天，需计算
    //    月（0~11）
    //    周几（ 可填1-7 或 SUN/MON/TUE/WED/THU/FRI/SAT）
    //    @Scheduled：除了支持灵活的参数表达式cron之外，还支持简单的延时操作，例如 fixedDelay ，fixedRate 填写相应的毫秒数即可。
    // */

}
