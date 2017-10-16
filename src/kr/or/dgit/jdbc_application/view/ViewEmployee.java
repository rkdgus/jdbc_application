package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService es;
	

	
	public ViewEmployee(String title) {
		super(title);
		es = new EmployeeService();
		}


	protected AbstractList createList() {
	
		ListEmployee pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}


	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent(es);
		return pContent;
	}


	@Override
	protected void createService() {
		es = new EmployeeService();
		
	}

}
