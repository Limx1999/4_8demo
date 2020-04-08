package com.example.util;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

/** <pre>queryL(这里用一句话描述这个方法的作用)   
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public class ThreadTest3 extends Thread{
       public  void run(){
           //任务
           System.out.println("你好 杰克");
       }

    //这种方式不好
    public static void main(String[] args) {
        new ThreadTest3().start();
    }
}
