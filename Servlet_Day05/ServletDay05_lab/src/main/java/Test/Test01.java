package Test;

import java.util.List;

import Util.DBUtils;
import dao.UserDAO;
import entity.User;

public class Test01 {
	public static void main(String[] args) throws Exception {
//		System.out.println(DBUtils.getConn());
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
}
