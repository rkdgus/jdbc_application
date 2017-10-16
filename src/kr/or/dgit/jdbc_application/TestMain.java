package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.JdbcUtil;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import kr.or.dgit.jdbc_application.service.TitleService;

public class TestMain {

	public static void main(String[] args) {
		
		
		
	
		
		
		
//		 testCon();
		
//		testDepartmentDao();
		
//		testTitleDao();
		
//		testEmployeeDao();
		
		
		
//		testTextFieldComponent();
		
		
//		TestDepartmentContent();
		
//		TestTitleContent();
		
		
		EmployeeContent tfc = new EmployeeContent(new EmployeeService());
		
		tfc.setContent(new Employee(2222, "아이유", new Title(1), new Employee(2), 1800000, new Department(2)));

		
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					Employee emp = tfc.getContent();
					
					
					JOptionPane.showMessageDialog(null, emp);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc,btn);
		
	}

















	private static void TestTitleContent() {
		TitleContent tfc = new TitleContent(new TitleService());
		
		tfc.setContent(new Title(5, "인턴"));

		
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					Title title = tfc.getContent();
					JOptionPane.showMessageDialog(null, title);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc,btn);
	}

















	private static void TestDepartmentContent() {
		DepartmentContent tfc = new DepartmentContent();
		

		
		tfc.setContent(new Department(1, "개발", 10));
		
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					Department dept = tfc.getContent();
					JOptionPane.showMessageDialog(null, dept);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc,btn);
	}

















	private static void testTextFieldComponent() {
		TextFieldComponent tfc = new TextFieldComponent("테스트");
		tfc.setTextValue("재진");
		
		
		
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getTextValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContent(tfc,btn);
	}









	private static void testContent(JPanel tfc,JButton btn) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 200, 150);
		jf.add(tfc);
		jf.add(btn, BorderLayout.SOUTH);
		jf.setVisible(true);
		
		
	}

	
	
	
	
	
	
	
	
	private static void testEmployeeDao() {
		Employee emp = new Employee(5000, "아이유", new Title(5), new Employee(4377), 1000000, new Department(1));
		testInsert(emp);
		
		emp.setSalary(3000000);
		emp.setTitle(new Title(2));
		testUpdate(emp);
		
		testSelectEmpno(emp);
		
		testDelete(emp);
		
		testSelectAll();
		
		
		
		
		
	}

	private static void testSelectEmpno(Employee emp)  {
		
			try {
				JOptionPane.showMessageDialog(null, EmployeeDao.getInstance().selectItemByNo(emp));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

	private static void testSelectAll() {
		List<Employee> lists = null;	
		try {
			lists = EmployeeDao.getInstance().selectItemByAll();
			for(Employee e:lists){
				System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testUpdate(Employee emp) {
		try {
			EmployeeDao.getInstance().updateItem(emp);
			JOptionPane.showMessageDialog(null, "변경성공");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "변경실패.");
		}
	}

	private static void testDelete(Employee emp) {
		try {
			EmployeeDao.getInstance().deleteItem(emp);
			JOptionPane.showMessageDialog(null, "삭제 성공");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
		}
		
	}

	private static void testInsert(Employee emp) {
		try {
			EmployeeDao.getInstance().insertItem(emp);
			JOptionPane.showMessageDialog(null, "사원을 추가하였습니다.");
		} catch (SQLException e) {
			System.err.printf("%s %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "추가 실패");
		}
		
		
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
