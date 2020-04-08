package com.example.pojo;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import lombok.Data;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：陈铎
 * 修改备注： 
 * @return</pre>
 */
 //动物POJO类

@Data       //此注解自动生成get set 有参 无参 ToString 方法
public class Animal {
    private Integer animalId;  //动物编号
    private String animalName; //动物名称
    private Integer animalAge;  //动物年龄
    private String animalMaose;  //动物毛色
    private Double animalWeight;  // 动物体重
}
