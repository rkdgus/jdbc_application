package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {

	

	
	public ViewEmployee(String title) {
		super(title);
		}


	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee();
		return pList;
	}


	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent();
		return pContent;
	}

}
