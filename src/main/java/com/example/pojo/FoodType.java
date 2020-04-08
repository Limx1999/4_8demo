package com.example.pojo;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import lombok.Data;

import java.util.Date;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */

@Data
public class FoodType {
    private Integer id;
    private String typeName;
    private Integer typeState;
    private Date createTime;
}
