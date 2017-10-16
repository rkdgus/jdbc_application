package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	

	
	public ViewDepartment(String title) {
		super(title);
		}


	protected AbstractList createList() {
		DepartmentService ds = new DepartmentService();
		ListDepartment pList = new ListDepartment(ds);
		pList.loadData();
		return pList;
	}


	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}


	@Override
	protected void createService() {
		service = new DepartmentService();
		
	}

}
