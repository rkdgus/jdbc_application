package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {

	

	
	public ViewDepartment(String title) {
		super(title);
		}


	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment();
		return pList;
	}


	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

}
