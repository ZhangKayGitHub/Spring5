package com.kay.jdbc;

/*
* 程序的耦合
*       耦合：程序间的依赖关系
*           包括:
*               类之间的依赖；
*               方法之间的依赖；
*               解耦：
*                   降低程序间的依赖关系：再编译时期就开始依赖某一个类，说明这个类的独立性就特别的差
*               实际开发中:
*                   应该做到编译时期不依赖，运行期才依赖
*               解耦的思路:
*                   第一步:在创建对象的时候采用反射来创建对象，而避免使用 new 关键字
*                   第二步:通过读取配置文件获取要创建的对象的全限定类名
0* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动

//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //与上边的DriverManager相比Class.forName()采用反射的方式，依赖的是字串而不是一个类，
        //这样就把编译时异常变成了运行时异常了
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","123456");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL,得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
