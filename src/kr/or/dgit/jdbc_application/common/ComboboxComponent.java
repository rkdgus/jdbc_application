package kr.or.dgit.jdbc_application.common;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboboxComponent<T> extends JPanel {
	private JComboBox<T> comboBox;
	
	

	public ComboboxComponent(String str) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lbl = new JLabel(str);
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbl);
		
		comboBox = new JComboBox<>();
		add(comboBox);

	}
	
	@SuppressWarnings("unchecked")
	public T getComboboxValue(){
		
		return (T)comboBox.getSelectedItem();
	}
	
	public void setComboboxValue(Object o){
		comboBox.setSelectedItem(o);
	}
	
	public void isEmptyCheck() throws Exception{
		if (comboBox.getSelectedIndex()==-1){
			comboBox.requestFocus();
			throw new Exception("선택 하지 않음");
		}
	}
	
	public void setComboBoxModel(Vector<T> lists){
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(model);
	}
	
	
	public void setSelectedItem(T item){
		comboBox.setSelectedItem(item);
	}
	
	
	public JComboBox<T> getCombo() {
		return comboBox;
	}
}
