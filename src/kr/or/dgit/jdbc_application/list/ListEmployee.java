package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class ListEmployee extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,100,100,150,150,50);
		setAlign(SwingConstants.CENTER,0,1,2,3,5);
		setAlign(SwingConstants.RIGHT,4);

	}

	@Override
	protected Object[][] getData() {
		Object[][] datas={
				{1,"아이유","사원","이효리",1000000,"영업"},
				{2,"이효리","회장","이효리",3000000,"영업"},
				{3,"이상순","사장","이상순",2000000,"영업"},
		};
		return datas;
	}

	@Override
	protected Object[] getColumnNames() {
		
		return  new String[]{"사원번호","성명","직급","직속상사","급여","부서"};
	}

	@Override
	public Object getSelectedItem() {
		int selectIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(selectIndex, 0);
		String empName = (String) table.getValueAt(selectIndex, 1);
		Title title = (Title) table.getValueAt(selectIndex, 2);
		Employee manager = (Employee) table.getValueAt(selectIndex, 3);
		int salary = (int) table.getValueAt(selectIndex, 4);
		Department dno= (Department) table.getValueAt(selectIndex, 5);
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}















