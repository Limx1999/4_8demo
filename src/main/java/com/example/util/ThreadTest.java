package com.example.util;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.sun.xml.internal.ws.developer.Serialization;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public class ThreadTest implements Runnable{
    public static  Integer Num = 0;
    @Override
    public void run() {
        //我是李苗星 ,我会成功的
      //do something here
      for(int i = 0 ; i < 10000;i++){
          System.out.println("线程名称"+Thread.currentThread().getName()+"Num"+Num);
          reint();
      }
    }

    public static synchronized int  reint(){
        return ++Num;
    }


}
