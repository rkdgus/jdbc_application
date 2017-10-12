package kr.or.dgit.jdbc_application.common;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFieldComponent extends JPanel {
	private JTextField textField;
	

	public JTextField getTextField() {
		return textField;
	}


	public TextFieldComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTitle);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

	
	public String getTextValue(){
		return textField.getText().trim();
	}
	
	public void setTextValue(String value){
		 textField.setText(value);
	}
	
	public void isEmptyCheck() throws Exception{
		if(getTextValue().equals("")){
			textField.requestFocus();
			throw new Exception("공백존재");
		}
		
	}
	
}
























