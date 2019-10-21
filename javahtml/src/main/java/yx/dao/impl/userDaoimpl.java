package yx.dao.impl;

import com.sun.org.apache.xerces.internal.impl.dv.xs.FullDVFactory;
import yx.dao.UserDao;
import yx.entity.User;
import yx.utils.sqlUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:三金
 * @Date:2019/10/18 9:16
 */
public class userDaoimpl implements UserDao {
    sqlUtils utils = new sqlUtils();

    @Override//显示所有数据库内容
    public List<User> getUser(String name, String pwd) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean end=false;
        List<User> users=new ArrayList<>();
        try {
        connection = utils.getconnection();
            System.out.println(connection);
        //编写sql语句
        String sql = "select * from userdb";
            preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                //判断用户密码是否正确
                if (name.equals(resultSet.getString("name")) && pwd.equals(resultSet.getString("pwd"))){
                    end =true;
                }
                user.setID(resultSet.getInt("ID"));
                user.setName(resultSet.getString("name"));
                user.setPwd(resultSet.getString("pwd"));
                users.add(user);
            }
            if (end){
                return users;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            utils.close(connection,preparedStatement,resultSet);
        }
    }


    public void insertUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = utils.getconnection();
            System.out.println(connection);
            //编写sql语句
            String sql="insert into userdb(ID,name,pwd) values (?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getID());
            if(!"".equals(user.getName())){
                preparedStatement.setString(2,user.getName());
            }
            if(!"".equals(user.getPwd())){
                preparedStatement.setString(3,user.getPwd());
            }
            int i=preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.close(connection,preparedStatement,resultSet);
        }
    }

    public static void main(String[] args) {
        User user = new User(9, "123", "123");
        userDaoimpl userDaoimpl = new userDaoimpl();
        userDaoimpl.insertUser(user);
    }
}
