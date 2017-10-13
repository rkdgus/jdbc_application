package kr.or.dgit.jdbc_application.view;

import java.awt.EventQueue;

public class TestView {
	 
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ViewTitle frame = new ViewTitle("직책관리");
						ViewDepartment frame1 = new ViewDepartment("부서관리");
						ViewEmployee frame2 = new ViewEmployee("사원관리");
						frame.setVisible(true);
						frame1.setVisible(true);
						frame2.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
