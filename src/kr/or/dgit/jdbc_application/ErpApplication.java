package kr.or.dgit.jdbc_application;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.view.ViewDepartment;
import kr.or.dgit.jdbc_application.view.ViewEmployee;
import kr.or.dgit.jdbc_application.view.ViewTitle;

@SuppressWarnings("serial")
public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnDept;
	private JButton btnEmp;
	private ViewTitle titlefr;
	private ViewDepartment deptfr;
	private ViewEmployee empfr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErpApplication() {
		setTitle("회사 ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnEmp = new JButton("사원관리");
		btnEmp.addActionListener(this);
		contentPane.add(btnEmp);
		
		btnDept = new JButton("부서관리");
		btnDept.addActionListener(this);
		contentPane.add(btnDept);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmp) {
			btnEmpActionPerformed(e);
		}
		if (e.getSource() == btnDept) {
			btnDeptActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
	}
	

	
	
	protected void btnTitleActionPerformed(ActionEvent e) {
		if(titlefr==null){
			titlefr = new ViewTitle("직책관리");
		}
		
		titlefr.setVisible(true);
	}
	protected void btnDeptActionPerformed(ActionEvent e) {
		if(deptfr==null){
			deptfr = new ViewDepartment("부서관리");
		}
		
		deptfr.setVisible(true);
	}
	protected void btnEmpActionPerformed(ActionEvent e) {
		if(empfr==null){
			empfr = new ViewEmployee("사원관리");
		}
		
		empfr.setVisible(true);
	}
}
