package org.example.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 该工具类不需要被继承
public final class JdbcUtils {
private static String url = "jdbc:mysql://localhost:3306/myApp";
private static String user = "root";
private static String password = "123456";
//不允许被创建
private JdbcUtils(){
}
static{
try{
Class.forName("com.mysql.jdbc.Driver");
}catch(ClassNotFoundException e){
throw new ExceptionInInitializerError(e);
}
}
public static Connection getConn() throws SQLException{
return DriverManager.getConnection(url, user, password);
}
public static void free(ResultSet rs,Statement st,Connection conn){
try {
if(rs != null)
rs.close();
} catch (SQLException e) {
e.printStackTrace();
}finally{
try {
if(st != null)
st.close();
} catch (SQLException e) {
e.printStackTrace();
}finally{
try {
if(conn != null)
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
}
}
