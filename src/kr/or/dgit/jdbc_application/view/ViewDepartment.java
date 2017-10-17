package kr.or.dgit.jdbc_application.view;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.dto.Department;
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
		service = new DepartmentService();
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}


	@SuppressWarnings("unchecked")
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}


	@Override
	protected void createService() {
		service = new DepartmentService();
		
	}


	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department) content);
		
	}


	@Override
	protected void deleteContent(Object item) {
		service.deleteDepartment((Department) item);
		
	}


	@Override
	protected void updateContent(Object item) {
		service.updateDepartment((Department) item);
		
	}


	@Override
	protected Department searchContent(int item) {
		return service.selectDepartmentByNo(new Department(item));
		// TODO Auto-generated method stub
		
	}

}
