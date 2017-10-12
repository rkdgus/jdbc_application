package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.ComboboxComponent;
import kr.or.dgit.jdbc_application.common.SpinnerContent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings("serial")
public class EmployeeContent extends JPanel {
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboboxComponent pTitle;
	private ComboboxComponent pManager;
	private SpinnerContent pSalary;
	private ComboboxComponent pDno;

	
	public EmployeeContent() {
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
		Vector<Employee> lists = new Vector<>();
		lists.add(new Employee(1, "서현진",new Title(1, "사장"),new Employee(1), 100000, new Department(1)));
		lists.add(new Employee(2, "아이유",new Title(1, "사장"),new Employee(1), 100000, new Department(1)));
		lists.add(new Employee(3, "이효리",new Title(1, "사장"),new Employee(1), 100000, new Department(1)));
		pManager.setComboBoxModel(lists);				
	}

	private void setTitleMOdel() {
		Vector<Title> lists = new Vector<>();
		lists.add(new Title(1, "사장"));
		lists.add(new Title(2, "부장"));
		lists.add(new Title(3, "사원"));
		pTitle.setComboBoxModel(lists);		
	}

	public void setDepartModel(){
		Vector<Department> lists = new Vector<>();
		lists.add(new Department(1, "개발1", 11));
		lists.add(new Department(2, "개발2", 12));
		lists.add(new Department(3, "개발3", 13));
		pDno.setComboBoxModel(lists);
	}
	
	
	
	public Employee getContent() throws SQLException{
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title =  new Title((int)pTitle.getComboboxValue());
		Employee manager = new Employee((int)pManager.getComboboxValue());
		int salary = (int)pSalary.getSpinner();
		Department dno =new Department((int)pDno.getComboboxValue()); 
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
