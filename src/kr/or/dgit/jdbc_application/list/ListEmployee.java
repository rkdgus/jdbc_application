package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class ListEmployee extends AbstractList {
	private EmployeeService empService;
	
	
	



	public ListEmployee(EmployeeService empService) {
		this.empService = empService;
		
	}

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,100,100,150,150,50);
		setAlign(SwingConstants.CENTER,0,1,2,3,5);
		setAlign(SwingConstants.RIGHT,4);

	}

	@Override
	protected Object[][] getData() {
		List<Employee> lists = empService.selectEmployeeByAll();

		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			Employee emp = lists.get(i);
			datas[i] = emp.toArray();
			datas[i][2] = getTitle(emp.getTitle());
			datas[i][3] = getManager(emp.getManager());
			datas[i][4] = String.format("%,d", datas[i][4]);
			datas[i][5] = getDno(emp.getDno());
		}
		return datas;
	}

	private String getDno(Department dno) {
		return empService.selectDepartmentByNo(dno).getDeptName();
	}

	private String getManager(Employee manager) {
		Employee emp = (Employee) empService.selectEmployeeByNo(manager);
		if (emp == null) {
			return String.format("%s", "");
		}
		return String.format("%s(%d)", emp.getEmpName(), emp.getEmpNo());
	}

	private String getTitle(Title title) {
		return empService.selectTitleByNo(title).getTitleName();
	}
	
	@Override
	protected Object[] getColumnNames() {
		
		return  new String[]{"사원번호","성명","직급","직속상사","급여","부서"};
	}

	
	
	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(seletedIndex, 0);
		return empService.selectEmployeeByNo(new Employee(empNo));
	}

}















