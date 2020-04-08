package com.example.util;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.util.resources.cldr.ss.CalendarData_ss_SZ;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public class StringUtils {
    private static Integer i = 0;
    public static boolean isCron(String str){
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
         /*   System.out.println("当前线程优先级！:" + Thread.currentThread().getPriority());
            System.out.println("当前线程名称！:" + Thread.currentThread().getName());
            System.out.println("当前线程唯一表识！:" + Thread.currentThread().getId());
            System.out.println("当前的中断标识！:" + Thread.currentThread().isInterrupted());
            System.out.println("当前是否为守护线程！:" + Thread.currentThread().isDaemon());
            System.out.println("判断线程是否在运行！:" + Thread.currentThread().isAlive());*/
         while (true){
             System.out.println("当前的中断标识！:" + Thread.currentThread().isInterrupted());
         }

        },"NICE");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("当前的中断标识4aa！:" + Thread.currentThread().isInterrupted());
    }



}



