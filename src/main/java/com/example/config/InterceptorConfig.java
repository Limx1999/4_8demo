package com.example.config;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注：
 *  拦截器配置
 *  addInterceptor：需要一个实现HandlerInterceptor接口的拦截器实例
 * addPathPatterns：用于设置拦截器的过滤路径规则；addPathPatterns("/**")对所有请求都拦截
 * excludePathPatterns：用于设置不需要拦截的过滤规则
 * 拦截器主要用途：进行用户登录状态的拦截，日志的拦截等。
 * @return</pre>
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("xxl-job-admin", "/api/**", "/index", "/userLogin", "/doc.html#/**", "/doc.html")
                .excludePathPatterns("/js/**", "/layui/**", "/css/**", "/image/**")
                .excludePathPatterns("/webjars/**", "/swagger-resources/**", "/webjars/**")
                .excludePathPatterns("/newslist", "/news", "/newsdetails", "/noticedetails", "/noticelist")
                .excludePathPatterns("/Html/**", "/images/**");
    }


    /*
    * *静态资源处理
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
