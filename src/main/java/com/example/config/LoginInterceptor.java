package com.example.config;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.example.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注： 
 * @return</pre>
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     *
     /*
     * 预处理回调方法，实现处理器的预处理 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("开始拦截.......................................");
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("拦截");
            request.setAttribute("msg", "没有权限，请重新登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调， 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally， 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}
