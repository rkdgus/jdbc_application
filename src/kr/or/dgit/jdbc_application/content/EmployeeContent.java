package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.ComboboxComponent;
import kr.or.dgit.jdbc_application.common.SpinnerContent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeContent extends JPanel {
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboboxComponent<Title> pTitle;
	private ComboboxComponent<Employee> pManager;
	private SpinnerContent pSalary;
	private ComboboxComponent<Department> pDno;
	private EmployeeService service;

	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("성명");
		add(pEmpName);
		
		pTitle = new ComboboxComponent("직급");
		add(pTitle);
		
		pManager = new ComboboxComponent("직속상사");
		add(pManager);
		
		pSalary = new SpinnerContent("급여");
		add(pSalary);
		
		pDno = new ComboboxComponent("부서");
		add(pDno);
		
		setManagerModel();
		setTitleMOdel();
		setDepartModel();
	}
	
	


	private void setManagerModel() {
		List<Employee> lists = service.selectEmployeeByAll();
		Vector<Employee> emp = new Vector<>(lists);
		
		pManager.setComboBoxModel(emp);				
	}

	private void setTitleMOdel() {
		List<Title> lists = service.selectTitleByAll();
		Vector<Title> titles = new Vector<>(lists);
		pTitle.setComboBoxModel(titles);		
	}

	public void setDepartModel(){
		List<Department> lists = service.selectDepartmentByAll();
		Vector<Department> dept = new Vector<>(lists);
		
		pDno.setComboBoxModel(dept);
	}
	
	
	
	public Employee getContent() throws SQLException{
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title =  (Title) pTitle.getComboboxValue();
		Employee manager =(Employee) pManager.getComboboxValue();
		int salary = (int)pSalary.getSpinner();
		Department dno =(Department) pDno.getComboboxValue(); 
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pTitle.setComboboxValue(employee.getTitle());
		pManager.setComboboxValue(employee.getManager());
		pSalary.setSpinner(employee.getSalary());
		pDno.setComboboxValue(employee.getDno());
	}
	
	public void isEmptyCheck() throws Exception{
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		
		
	}


}
