package com.example.pojo;


import java.util.Scanner;

//这是一个银行测试系统
public class BankTest {

    public static void main(String[] args) {

        byte count = 0;
        int money = 10000;
      System.out.println("--------------------------欢迎来到银行管理系统--------------------------");
      while (true){
         System.out.println("请输入你的账户密码");
         Scanner scanner = new Scanner(System.in);
         String password = scanner.next();
          if(!password.equals("123456")){
              //密码输入错误
              count++;
              if(count==3){
              }else{
                  System.out.println("第"+count+"次输入密码错误，还有"+(3-count)+"次机会");
              }
          }else{
              //密码输入正确
              while(true){
                  System.out.println("主菜单");
                  System.out.println("1.查询账户");
                  System.out.println("2.取款");
                  System.out.println("3.存款");
                  System.out.println("4.修改密码");
                  System.out.println("5.退出");
                  String str = scanner.next();
                  switch (str){
                      case "1":
                          System.err.println("账户余额：  "+money+"元");
                          break;
                      case "2":
                          while (true){
                              Scanner s = new Scanner(System.in);
                              System.out.println("请输入取款金额");
                              //判断输入是否是整数
                              if(s.hasNextInt()){
                                  int qu = s.nextInt();
                                  //判断输入数字是否小于5000
                                  if(qu<=5000 && qu>=0){
                                      //判断输入数字是100的整数
                                      if(qu%100==0){
                                          money = money - qu;
                                          System.out.println("取款成功");
                                          break;
                                      }else {
                                          System.err.println("取款金额必须是100的整数倍");
                                      }
                                  }else {
                                      System.err.println("取款单笔金额不能超过5000.0 RMB(不能为负数)");
                                  }
                              }else{
                                  System.err.println("请输入整数型且不能为字符");
                              }
                          }
                          break;
                      case "3":
                          while (true){
                              Scanner c = new Scanner(System.in);
                              System.out.println("请输入存款金额");
                              if(c.hasNextInt()){
                                  int cun = c.nextInt();
                                  //判断输入数字是100的整数
                                  if(cun%100==0 && cun>=0){
                                      money = money + cun;
                                      System.out.println("存款成功");
                                      break;
                                  }else {
                                      System.err.println("存款金额必须是100的整数倍且不为负数");
                                  }
                              }else{
                                  System.err.println("请输入整数型且不能为字符");
                              }
                          }
                          break;
                      case "4":
                          System.out.println("请输入旧密码");
                          String oidPassword = scanner.next();
                          if(oidPassword.equals("123456")){
                             while (true){
                                 System.out.println("请输入新的密码");
                                 String newpassword = scanner.next();
                                 boolean falg ;
                                 boolean flag2 = false;
                                 int count2  = 0;
                                 //校验是否为数字 和 字母 和长度
                                 if(newpassword.length()>=6){
                                     //通过比较ASCII码值 来确定输入的是否合法
                                     //a-z  97-122    A-Z6 5-90   0-9 48-57
                                  for (int i = 0 ; i < newpassword.length();i++){
                                             falg = (newpassword.charAt(i)>=65 && newpassword.charAt(i)<=90)  ||
                                                     (newpassword.charAt(i)>=97 && newpassword.charAt(i)<=122) ||
                                                     (newpassword.charAt(i)>=48 && newpassword.charAt(i)<=57) ;

                                             //但凡不是（字母|数字）则停止循环
                                             if(!falg){
                                                 flag2 = true;
                                                 break;
                                     }
                                     //判断数字的个数
                                     if(newpassword.charAt(i)>=48 && newpassword.charAt(i)<=57){
                                         count2++;
                                     }
                                 }
                                  //判断新密码是否合格
                                  if(flag2==true){
                                   System.err.println("密码只能由数字+字母组成");
                                  }else if(count2<2){
                                   System.err.println("密码中至少包含2个数字");
                                  }else{
                                  System.out.println("密码修改成功");
                                      break;
                                  }
                                 }else {
                                     System.err.println("密码最少6位【数字+字母】");
                                 }
                             }
                          }else{
                              System.out.println("旧密码输入有误 已退出改密码功能");
                          }
                          break;
                      case "5":
                          System.out.println("系统退出成功");
                          return;

                      default:
                          System.out.println("输入操作数字有误【1~5】");


                  }
              }
          }
         if(count==3){
           System.err.println("登录3次均失败,已退出程序");
           return;
         }


      }
    }

}
