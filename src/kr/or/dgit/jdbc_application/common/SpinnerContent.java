package kr.or.dgit.jdbc_application.common;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SpinnerContent extends JPanel {
	private JSpinner spinner;

	public SpinnerContent(String str) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lbl = new JLabel(str);
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl.setEnabled(true);
		add(lbl);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1500000), null, null, new Integer(100000)));
		add(spinner);

	}
	
	public Object getSpinner(){
		return spinner.getValue(); 
	}
	
	public void setSpinner(Object value){
		spinner.setValue(value);
	}
	

}
