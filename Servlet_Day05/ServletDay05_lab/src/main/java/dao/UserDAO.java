package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Util.DBUtils;
import entity.User;

/**
 * DAO(Data Access Object):封装了数据访问逻辑的对象.
 */

public class UserDAO {
	/* 数据修改的方法 */
	public void update(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "UPDATE t_user SET password=?,email=?,phone=? WHERE username=?";
			ps = conn.prepareStatement(sql);	
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.executeUpdate();
			System.out.println("修改用户信息成功....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
	}
	
	/* 删除数据的方法*/
	public void delete(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "delete from t_user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,user.getId());
			ps.executeUpdate();
			System.out.println("删除成功....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
	}
	
	/* 插入数据的方法 */
	public void insert(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "INSERT INTO t_user VALUES(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.executeUpdate();
			System.out.println("执行完毕.....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
	}
	
	/* 查询数据的方法  */
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return users;
	}

}
