/**
 *
 */
package com.example.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName: PublicUtils
 * @Description:TODO
 * @author: PUFEI
 * @date: 2019年12月20日 下午2:53:02
 *
 * @Copyright: http://shows.tynet.vip/
 */
public class PublicUtils {

    /**
     * 生成UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取系统时间
     */
    public static String getTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

        return sdf.format(d);
    }

    /**
     * 获取系统时间
     */
    public static Date getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowdayTime = dateFormat.format(new Date());
        Date nowDate = null;
        try {
            nowDate = dateFormat.parse(nowdayTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return nowDate;
    }

    /**
     * @param phone 字符串类型的手机号 传入手机号,判断后返回 true为手机号,false相反
     */
    public static boolean isPhone(String phone) {
        if (null == phone) {
            return false;
        }
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    //获取服务器路径 TODO
    public static String serverPath = "http://xfbapi.tynet.vip/";

    //Date转换String
    public static String dateToString(Date date) {
        if (null == date) {
            return "";
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }


}
