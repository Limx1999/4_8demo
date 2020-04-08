package com.example.dao;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.example.pojo.Food;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import java.util.List;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */


public interface FoodDao {

    List<Food> getFoodList();

    String getCron();

    User userLogin(User u);

    List<User> queryUSer( @Param("user") User user);
}
