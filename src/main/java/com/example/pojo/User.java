package com.example.pojo;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
@Data
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String upassword;
    private String unc;
    private String uphone;
    private String uyouxiang;
    private Integer uage;
    private Date ushengri;
}
