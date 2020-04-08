package com.example.pojo;/**
 * 类描述：（用一句话 描述这个类的作用）
 * 创建人：李苗星
 * 修改备注：
 *
 * @version </pre>
 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.objects.annotations.Where;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** <pre>main(知识点: Scanner + List +对象 + if + for )
 * 创建人：陈铎
 * 修改备注：    修改未完成（不知道要出现什么效果）
 * @return</pre>
 */
public class TestAnimal {

    private volatile  String ss = "";


    public static void main(String[] args) {

        List<Animal> AnimalList = new ArrayList<Animal>();

        Integer bh = 1;
        Boolean falg = true;
        while (falg){
            //输出主菜单页面
            System.out.println("                欢迎来到宠物管理系统");
            System.out.println("************************************************");
            System.out.println("1. 添加宠物");
            System.out.println("2. 删除宠物");
            System.out.println("3. 查询宠物");
            System.out.println("4. 修改宠物");
            System.out.println("5. 查询所有宠物信息");
            System.out.println("6. 统计动物数量");
            System.out.println("0. 退出系统");
            //创建一个动物集合  泛型为动物
            System.out.println("请输入要执行的操作");
            Scanner scan = new Scanner(System.in);
            Integer sum =  null;

            //判断输入是否是整数
            if(scan.hasNextInt()){
                sum = scan.nextInt();
            }else{
                System.out.println("请输入正确的操作数字");
            }
            if(sum!=null && sum>=0 && sum<7 ){
                if(sum==1){
                    Animal animal =  new Animal();
                    //添加动物
                    Boolean namefalg         = true;
                    Boolean ageflag          = true;
                    Boolean maosefalg        = true;
                    Boolean animalWeightfalg = true;
                    //动物名称
                    while (namefalg){
                        System.out.println("请输入动物名称");
                        Scanner putname = new Scanner(System.in);
                        String name = putname.next();
                        if(name!=null && name!=""){
                            animal.setAnimalName(name);
                            namefalg = false;
                        }else{
                            System.out.println("动物名称不能为空且不能为空串,请重新输入");
                        }
                    }
                    while (ageflag){
                        System.out.println("请输入动物年龄");
                        Scanner putage = new Scanner(System.in);
                        if(putage.hasNextInt()){
                            animal.setAnimalAge(Integer.parseInt(putage.next()));
                            ageflag = false;
                        }else{
                            System.out.println("动物年龄不能为字符串和小数,请重新输入");
                        }
                    }
                    while (maosefalg){
                        System.out.println("请输入动物毛色");
                        Scanner putmaose = new Scanner(System.in);
                        String maose = putmaose.next();
                        if(maose!=null && maose!="" && maose.substring(maose.length()-1).equals("色")){
                            animal.setAnimalMaose(maose);
                            maosefalg = false;
                        }else{
                            System.out.println("动物毛色不能为空且格式为 **色,请重新输入");
                        }
                    }
                    while (animalWeightfalg){
                        System.out.println("请输入动物体重: 单位 KG");
                        Scanner weight = new Scanner(System.in);
                        if(weight.hasNextInt() || weight.hasNextDouble()){
                            animal.setAnimalWeight(Double.valueOf(weight.next()));
                            animalWeightfalg = false;
                        }else{
                            System.out.println("动物体重不能为空且不能为字符串,请重新输入");
                        }

                    }
                    //ID赋值
                    animal.setAnimalId(bh);
                    //ID自增
                    bh++;
                    //动物新增 放入集合
                    AnimalList.add(animal);
                    System.out.println("动物新增成功");
                }
                if(sum==2){
                    //删除动物
                    System.out.println("请输入要删除的类型【1.编号删除      2.名称删除】");
                    Scanner deltype = new Scanner(System.in);
                    if(deltype.hasNextInt()){
                        Integer deltypesum = deltype.nextInt();
                    Boolean delidfalg = false;
                    if(deltypesum==1){
                        System.out.println("请输入要删除的编号");
                        Scanner del = new Scanner(System.in);
                        Integer deldwid = del.nextInt();
                       if(deldwid!=null){
                           for (int i= 0 ; i <AnimalList.size();i++  ) {
                                if(AnimalList.get(i).getAnimalId()==deldwid){
                                    AnimalList.remove(AnimalList.get(i));
                                    delidfalg = true;
                                }
                           }
                           if(delidfalg){
                               System.out.println("删除成功");
                           }else{
                               System.out.println("删除未成功 输入的编号不存在");
                           }

                       }else{
                           System.out.println("输入错误");
                       }
                    }else if(deltypesum==2){
                        System.out.println("请输入要删除的动物名称");
                        Scanner del = new Scanner(System.in);
                        String delname = del.next();
                        Boolean delnameflag = false;
                        if(delname!=null && delname!=""){
                            for (int i = 0; i < AnimalList.size(); i++ ) {
                                if(AnimalList.get(i).getAnimalName().equals(delname)){
                                    AnimalList.remove(AnimalList.get(i));
                                    delnameflag = true;
                                }
                            }
                        if(delnameflag){
                            System.out.println("删除成功");
                        }else{
                            System.out.println("删除未成功 输入的名称不存在");
                        }

                        }else{
                            System.out.println("输入错误");
                        }
                    }else{
                        System.out.println("输入有误【可供选择 1，2】,已退出");
                    }
                    }else {
                        System.out.println("输入有误【可供选择 1，2】,已退出");
                    }


                }
                if(sum==3){
                    //查询动物
                    System.out.println("请输入要查询的动物编号");

                    Scanner querydw = new Scanner(System.in);
                    Integer queryId = null;
                    Boolean queryflag = false;
                    if(querydw.hasNextInt()){
                        queryId = querydw.nextInt();
                        for(int i=0;i<AnimalList.size();i++){
                           if(AnimalList.get(i).getAnimalId()==queryId){
                               queryflag = true;
                               System.err.println("编号:" + AnimalList.get(i).getAnimalId() + "    " +
                                       "姓名:" + AnimalList.get(i).getAnimalName() + "    " +
                                       "毛色:" + AnimalList.get(i).getAnimalMaose() + "    " +
                                       "年龄:" + AnimalList.get(i).getAnimalAge() + "    " +
                                       "体重:" + AnimalList.get(i).getAnimalWeight() + "    ");
                           }
                        }
                        if(!queryflag){
                           System.out.println("查询失败 未找到编号为"+queryId+"的动物");
                        }
                    }else{
                        System.out.println("编号输入有误");
                    }

                }
                if(sum==4){
                    //修改动物
                }
                if(sum==5){
                    //查询所有动物信息
                    System.out.println("所有动物信息展示↓↓↓：");
                    if(AnimalList.size()==0){
                       System.out.println("【抱歉：暂无动物信息,请手动添加】：");
                    }else {
                        for (int i = 0; i < AnimalList.size(); i++) {
                            System.out.println("编号:" + AnimalList.get(i).getAnimalId() + "    " +
                                    "姓名:" + AnimalList.get(i).getAnimalName() + "    " +
                                    "毛色:" + AnimalList.get(i).getAnimalMaose() + "    " +
                                    "年龄:" + AnimalList.get(i).getAnimalAge() + "    " +
                                    "体重:" + AnimalList.get(i).getAnimalWeight() + "    ");
                        }
                    }
                }
                if(sum==6){
                    //统计动物数量
                    System.err.println("动物总共有"+AnimalList.size()+"只");
                }
                if(sum==0){
                    falg = false;
                }
            }else{
                System.out.println("操作数字范围在【0~6】且不能为空字符串");
            }



        }

        System.out.println("退出系统成功");

    }
}
