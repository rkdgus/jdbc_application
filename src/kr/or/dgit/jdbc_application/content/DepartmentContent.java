package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;

@SuppressWarnings("serial")
public class DepartmentContent extends AbstractContent<Department> {
	private TextFieldComponent pDeptNo;
	private TextFieldComponent pDeptName;
	private TextFieldComponent pFloor;

	
	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pDeptNo = new TextFieldComponent("부서번호");
		add(pDeptNo);
		
		pDeptName = new TextFieldComponent("부서명");
		add(pDeptName);
		
		pFloor = new TextFieldComponent("위치");
		add(pFloor);
	}
	
	public Department getContent(){
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		return new Department(deptNo, deptName, floor);
	}
	
	public void setContent(Department department){
		pDeptNo.setTextValue(department.getDeptNo()+"");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor()+"");
	}
	
	public void isEmptyCheck() throws Exception{
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
		
	}

	@Override
	public void clear() {
		pDeptNo.setTextValue("");
		pDeptName.setTextValue("");
		pFloor.setTextValue("");
		
	}

	@Override
	public void changeContent(Object content) {
		pDeptNo.getTextField().setEnabled(false);
		setContent((Department) content);
	}

	@Override
	public void enable(boolean ok) {
		pDeptNo.getTextField().setEnabled(ok);
		pDeptName.getTextField().setEnabled(ok);
		pFloor.getTextField().setEnabled(ok);
		
	}

}














