package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dto.Department;

public class DepartmentService {
	
	private SqlDao<Department> deptDao;

	public DepartmentService() {
		deptDao = DepartmentDao.getInstance();
	}
	
	public void insertDepartment(Department dept){
		try {
			deptDao.insertItem(dept);
			showMessage("추가완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	public	void deleteDepartment(Department dept){
		try {
			deptDao.deleteItem(dept);
			showMessage("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public	void updateDepartment(Department dept){
		try {
			deptDao.updateItem(dept);
			showMessage("업데이트 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Department>  selectDepartment(){
		try {
		return deptDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Department selectDepartmentByNo(Department dept){
		try {
			return	deptDao.selectItemByNo(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
