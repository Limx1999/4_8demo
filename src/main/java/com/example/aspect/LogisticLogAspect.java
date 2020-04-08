package com.example.aspect;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

        import com.example.util.PublicUtils;
        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.annotation.AfterReturning;
        import org.aspectj.lang.annotation.Before;
        import org.aspectj.lang.annotation.Pointcut;

        import org.springframework.stereotype.Component;
        import org.aspectj.lang.annotation.Aspect;
        import org.springframework.web.context.request.RequestContextHolder;
        import org.springframework.web.context.request.ServletRequestAttributes;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.Arrays;

/** <pre>queryL(这里用一句话描述这个方法的作用)
 * 创建人：李苗星
 * 修改备注：
 * @return</pre>
 */


@Aspect
@Component
public class LogisticLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
   //切点切在controller层   如果controller下面还有一层包
   // @Pointcut("execution(public * com.example.controller.app..*.*(..))")
   @Pointcut("execution(public * com.example.controller..*.*(..))")
   public void weblog(){
   }

/* ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
 HttpServletRequest request = attributes.getRequest();*/


 @Before("weblog()")
 public void doBefore(JoinPoint joinPoint) {
     startTime.set(System.currentTimeMillis());
      ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      HttpServletRequest request =  attributes.getRequest();
      System.out.println("前置通知begin  切面是controller层");
  // 接收到请求，记录请求内容

  // 记录下请求内容
  System.out.println("TIME : " + PublicUtils.getTime());
  System.out.println("URL : " + request.getRequestURL().toString());
  System.out.println("HTTP_METHOD : " + request.getMethod());
  System.out.println("IP : " + request.getRemoteAddr());
  System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
  System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
  System.out.println("前置通知end");
 }


 @AfterReturning(returning ="ret" , pointcut = "weblog()")
 public void doAfterReturning(Object ret) throws Throwable {
     System.out.println("后置通知begin  切面是controller层");
/*  System.out.println("后置通知begin  切面是controller层");
  ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
  HttpServletRequest request = attributes.getRequest();
  System.out.println("TIME : " + PublicUtils.getTime());
  System.out.println("URL : " + request.getRequestURL().toString());
  System.out.println("HTTP_METHOD : " + request.getMethod());
  System.out.println("IP : " + request.getRemoteAddr());*/
  // 处理完请求，返回内容
  System.out.println("我是方法返回值"+ret);
  System.out.println("后置通知end");
 }





}
