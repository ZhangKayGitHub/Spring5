package com.kay.factory;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 *
 * Bean在计算机用于中有可重用组件的含义
 * JacaBean:用java语言编写的可重用组件
 *      javabean >> 实体类
 *    它就是创建我们service和Dao对象的。
 *
 *    第一个：需要一个配置文件来配置我们的service和dao
 *           配置的内容：唯一标识=全限定类名 （key=value）
 *    第二个：通过读取配置文件中的配置，反射创建对象
 *
 *    我们的配置文件可以是xml 也可以是properties
 */

public class Beanfactory {
    //定义一个Preporties对象
    private static Properties props;

    //定义一个map，用于存放我们要创建的对象，我们把他称为容器
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = Beanfactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            //实例化容器；
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入到容器中
                beans.put(key,value);
            }
        }catch (Exception e){
            /**
             * 如果配置文件初始化失败什么事情都做不了，创建一个初始化异常抛出
             */
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


    /**
     * 由于在bean.properties中我们配置了多个键值对，获取哪一个键值对我们还不能确定，因此为了方法的通用性
     * 该方法的返回值采用Object 同时通过函数的参数的来确定调用那一个键值对
     * @param beanName
     * @return
     */

    /*
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
    */


}
