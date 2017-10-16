package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Title;

public class TitleService {
	private SqlDao<Title> titleDao;

	public TitleService() {
		titleDao = TitleDao.getInstance();
	}
	
	public void insertTitle(Title title){
		try {
			titleDao.insertItem(title);
		} catch (SQLException e) {
			showMessage("추가완료");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public void deleteTitle(Title title){
		try {
			titleDao.deleteItem(title);
			showMessage("삭제완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Title> selectTitleAll(){
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
