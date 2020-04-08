package com.example.service.impl;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.example.dao.FoodDao;
import com.example.pojo.Food;
import com.example.pojo.User;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */

@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodDao foodDao;

    @Override
    public List<Food> getFoodList() {
        List list = new ArrayList<Food>();
        list.add(new Food());
        return foodDao.getFoodList();
    }

    @Override
    public String getCron() {
        return foodDao.getCron();
    }

    @Override
    public boolean userLogin(User u, HttpServletRequest request) {
        User u2 = foodDao.userLogin(u);
        if(u2==null){
          return false;
        }else{
            request.getSession().setAttribute("user",u2);
            return true;
        }
    }

    @Override
    public List<User> queryUser(User user) {
        return foodDao.queryUSer(user);
    }


}
