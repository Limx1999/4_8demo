package com.example.controller;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.example.pojo.Food;
import com.example.pojo.FoodType;
import com.example.pojo.User;
import com.example.service.FoodService;

import com.example.util.RedisCommonf;
import com.example.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisUtil redisUtil;

/*    private static final Logger l =  LoggerFactory.getLogger(FoodController.class);*/



   /* @Bean("foodService")
    public FoodService getFoodService(){
       return foodService;
    }*/


    //用户登录
    @RequestMapping("userLogin")
    @ResponseBody
    public boolean UserLogin(User u, HttpServletRequest request){
        return foodService.userLogin(u,request);
    }
    //用户注销
    @RequestMapping("onu")
    @ResponseBody
    public String onu(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return  "注销成功";
    }
    @RequestMapping("/")
    public String Text(){
        return "redirect:getFoodList";
    }


    @RequestMapping("getFoodList")
    public ModelAndView getFoodList(){

        List foodList  =  foodService.getFoodList();

        //--------------text
        List foodTypeList = new ArrayList<>();
        for (int i = 0 ; i < 5; i++){
           FoodType foodType =   new FoodType();
            foodType.setId(i);
            foodType.setCreateTime(new Date());
            foodType.setTypeName("加油 奥利给"+i);
            foodTypeList.add(foodType);
        }
        //--------------end
        Map m  = new HashMap<String, Object>();
        m.put("foodList",foodList);
        m.put("foodTypeLIst",foodTypeList);
       ModelAndView view = new ModelAndView();
        view.addAllObjects(m);
        view.setViewName("/foodlist");
        return new ModelAndView("foodlist", "userList", m);
    }

    @RequestMapping("testRedis")
    @ResponseBody
    public List<User> queryUser(User user){
        //假设条查
       List<User> userAll = new ArrayList<User>();
       String redisKey = RedisCommonf.QUERY_USER;
       if(user!=null){
           if(user.getUname()!=null){
               redisKey += "_"+user.getUname();
           }
           if(user.getUage()!=null){
               redisKey += "_"+user.getUage();
           }
       }
       if(redisUtil.hasKey(redisKey)){
           System.out.println(1);
           userAll  =  (List<User>)redisUtil.get(redisKey);
       }else{
           System.out.println(2);
           userAll =  foodService.queryUser(user);
           redisUtil.set(redisKey,userAll);
       }
       return userAll;
    }

}
