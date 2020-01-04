package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
程序的耦合:
    耦合：程序间的依赖关系
        包括：
            类之间依赖
            方法之间依赖
    解耦：
        降低程序间的依赖关系
    实际开发中：
        应该做到，编译器不依赖，运行期才依赖
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ee?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT","root","guobo12368");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm=conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs=pstm.executeQuery();
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
