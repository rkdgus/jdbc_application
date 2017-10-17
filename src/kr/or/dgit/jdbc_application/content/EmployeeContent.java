package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import kr.or.dgit.jdbc_application.common.ComboboxComponent;
import kr.or.dgit.jdbc_application.common.SpinnerContent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeContent extends AbstractContent<Employee> implements ActionListener {
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboboxComponent<Title> pTitle;
	private ComboboxComponent<Employee> pManager;
	private SpinnerContent pSalary;
	private ComboboxComponent<Department> pDno;
	private EmployeeService service;
	private Department dept = new Department(1);
	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("성명");
		add(pEmpName);
		
		pTitle = new ComboboxComponent("직급");
		add(pTitle);
		
		pDno = new ComboboxComponent("부서");
		pDno.getCombo().addActionListener(this);
		add(pDno);
		
		pManager = new ComboboxComponent("직속상사");
		add(pManager);
		
		pSalary = new SpinnerContent("급여");
		add(pSalary);
		
		
		
		
		
		setDepartModel();
		
		setTitleMOdel();
		
	}
	
	


	private void setManagerModel() {
		List<Employee> lists = service.selectEmployeeByDno(dept);
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
	
	
	
	public Employee getContent(){
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


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pDno.getCombo()) {
			pDnoComboActionPerformed(e);
		}
	}
	protected void pDnoComboActionPerformed(ActionEvent e) {
		
		dept = pDno.getComboboxValue();
		setManagerModel();
	}







	@Override
	public void clear() {
		pEmpNo.setTextValue("");
		pEmpName.setTextValue("");
		pTitle.setComboboxValue(0);
		pManager.setComboboxValue(0);
		pSalary.setSpinner(1500000);
		pDno.setComboboxValue(0);
		
	}
}
