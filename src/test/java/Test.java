import java.sql.*;
import org.example.mapper.UserDao;
import org.example.model.pojo.User;
import org.example.factory.DaoFactory;

public class Test {
    @org.junit.Test
    public  void jdbcTest(){;

        String url = "jdbc:mysql://localhost:3306/myApp"; // 替换为你的数据库URL
        String user = "root"; // 替换为你的数据库用户名
        String password_d = "123456"; // 替换为你的数据库密码

        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. 加载并注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 创建数据库连接
            conn = DriverManager.getConnection(url, user, password_d);

            // 3. 创建 Statement 对象用于执行 SQL 语句
            stmt = conn.createStatement();

            // 4. 执行 SQL 查询并处理结果
            String sql = "SELECT * FROM users"; // 替换为你的表名
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // 假设你的表有一个名为 'column_name' 的列
                String columnNameValue = rs.getString("username"); // 替换为你的列名
                System.out.println(columnNameValue);
            }

            // 关闭资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    @org.junit.Test
//    public void FactoryTest(){
//        UserDao userDao = DaoFactory.getInstance().getUserDao();
//        User user = new User();
//        user.setUsername("dao name1");
//        user.setEmail("1979836005@qq.com");
//        user.setPassword("123456");
//        userDao.addUser(user);
//
//    }

}
