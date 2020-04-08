package com.example.service;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.example.pojo.Food;
import com.example.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** <pre>queryL(这里用一句话描述这个方法的作用)   
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */
public interface FoodService {

    List<Food> getFoodList();

    String getCron();

    boolean userLogin(User u, HttpServletRequest request);

    List<User> queryUser(User user);
}
