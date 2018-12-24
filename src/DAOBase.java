import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DAOBase implements DAO {
	
	private static LinkedList<Connection> listConnections=new LinkedList<Connection>();
	
	static{
		InputStream in=DAOBase.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop=new Properties();
		try{
			prop.load(in);
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int jdbcPoolInitSize=Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
			Class.forName(driver);
			for(int i=0;i<jdbcPoolInitSize;i++){
				Connection conn=DriverManager.getConnection(url,username,password);
				System.out.println("链接的数量"+conn);
				listConnections.add(conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if(listConnections.size()>0){
			final Connection conn =listConnections.removeFirst();
			System.out.println("空间链接的数量："+listConnections.size());
			return (Connection)Proxy.newProxyInstance(DAOBase.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){
				public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
					if(!method.getName().equals("close")){
						return method.invoke(conn, args);
					}else{
						listConnections.add(conn);
						System.out.println(conn+"释放了链接");
						System.out.println("链接的数量"+listConnections.size());
						return null;
					}
				}
 			});
		}else{
			throw new RuntimeException("链接已经满了");
		}
	}
}
