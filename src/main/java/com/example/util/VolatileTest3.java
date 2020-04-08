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
public class VolatileTest3 {

        static class Work{
          public volatile boolean flag = false;

          public void   stop1(){
              flag = true;
              System.out.println("stop了");
          }

          public  void test1(){
               while (!flag){
                 System.out.println("运行中");
               }
          }

        }

    public static void main(String[] args) {
        Work work = new Work();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::stop1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
        new Thread(work::test1).start();
    }
}