package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.service.DepartmentService;

@SuppressWarnings("serial")
public class ListDepartment extends AbstractList {
	private DepartmentService service;


	public ListDepartment(DepartmentService service) {
		this.service = service;
	}



	@Override
	protected void setAlignWidth() {
		setCellWidth(100,150,50);
		setAlign(SwingConstants.CENTER,0,2);
		setAlign(SwingConstants.RIGHT,1);
		
	}



	protected Object[][] getData() {
		List<Department> lists = service.selectDepartment();
		Object[][] datas =new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}


	protected Object[] getColumnNames() {
		
		return new String[]{"부서번호","부서명","위치"};
	}



	@Override
	public Object getSelectedItem() {
		int selectIndex = table.getSelectedRow();
		int deptNo = (int) table.getValueAt(selectIndex, 0);
		String deptName = (String) table.getValueAt(selectIndex, 1);
		int floor = (int) table.getValueAt(selectIndex, 2);
		return new Department(deptNo, deptName, floor);
	}

}









