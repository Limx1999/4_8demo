package com.example.util;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        // 1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<String> result = new FutureTask<String>(td);
        new Thread(result).start();
        String sun;
        //用于关闭锁
        try {
            sun = result.get();
            System.out.println("---------------------------");
            System.out.println(sun);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}

@Data
class ThreadDemo implements Callable<String>{

    private String age1;
    private String agr2;



    @Override
    public String call() throws Exception {
                 int sum = 0;
                 for (int i = 0; i <= 100000; i++) {
                         System.out.println(i);
                         sum += i;
                     }


                 return  ""+sum;
    }
}