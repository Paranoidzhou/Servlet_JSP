package Test;

import java.util.List;

import Util.DBUtils;
import dao.UserDAO;
import entity.User;

public class Test01 {
	public static void main(String[] args) throws Exception {
//		System.out.println(DBUtils.getConn());
		UserDAO dao = new UserDAO();
		System.out.println(dao.find("李白"));
	}
}
