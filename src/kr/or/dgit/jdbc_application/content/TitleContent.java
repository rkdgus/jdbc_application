package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings("serial")
public class TitleContent extends JPanel {
	private TextFieldComponent pTitleNo;
	private TextFieldComponent pTitleName;

	
	public TitleContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직급번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직급");
		add(pTitleName);

	}
	
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		return new Title(titleNo, titleName);
	}
	
	public void setContent(Title title){
		pTitleNo.setTextValue(title.getTitleNo()+"");
		pTitleName.setTextValue(title.getTitleName());
	}

	public void isEmptyCheck() throws Exception{
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}
}
