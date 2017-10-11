package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		// testCon();
		
//		testDepartmentDao();
		
		testTitleDao();
		
		testEmployeeDao();
		
		
	}

	private static void testEmployeeDao() {
		
		
	}

	private static void testTitleDao() {
		Title title = new Title(6, "인턴");
		testInsert(title);
		testTitleListAll();
		
		title.setTitleName("회장");
		testUpdate(title);
		testTitleListAll();
		
		testTilteNo(title);
		testDelete(title);
	}

	private static void testTilteNo(Title title) {
		try {
			TitleDao.getInstance().selectItemByNo(title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testUpdate(Title title) {
		try {
			TitleDao.getInstance().updateItem(title);
			JOptionPane.showMessageDialog(null, "변경되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "변경실패.");
		}
		
	}

	private static void testTitleListAll() {
		List<Title> lists;
		try {
			lists = TitleDao.getInstance().selectItemByAll();
			for(Title t:lists){
				System.out.println(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void testDelete(Title title) {
		try {
			TitleDao.getInstance().deleteItem(title);
			JOptionPane.showMessageDialog(null, "직급이 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제실패");
		}
		
	}

	private static void testInsert(Title title) {
		try {
			TitleDao.getInstance().insertItem(title);
			JOptionPane.showMessageDialog(null, "직급이 추가되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "직급이 존재합니다.");
		}
		
	}

	private static void testDepartmentDao() {
		Department dept = new Department(4, "마케팅", 10);
		testInsert(dept);
		testListAll();
		
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testDeptNo(dept);
		
		
		testDelete(dept);
		testListAll();
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testDeptNo(Department dept) {
		try {
			DepartmentDao.getInstance().selectItemByNo(new Department(1));
			System.out.println(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department dept : lists){
				System.out.println(dept);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가되었습니다.");
		} catch (SQLException e) {

			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
			}
		}
	}

	private static void testCon() {
		DBCon dbCon = DBCon.getInstance();

		Connection connection = dbCon.getConnection();
		System.out.println(connection);

		JdbcUtil.close(connection);
	}

}
