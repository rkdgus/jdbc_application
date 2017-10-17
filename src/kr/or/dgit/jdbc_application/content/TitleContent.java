package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.TitleService;

@SuppressWarnings("serial")
public class TitleContent extends AbstractContent<Title> {
	private TextFieldComponent pTitleNo;
	private TextFieldComponent pTitleName;

	public TitleContent(TitleService service) {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleNo = new TextFieldComponent("직급번호");
		add(pTitleNo);
		
		pTitleName = new TextFieldComponent("직급");
		add(pTitleName);

	}
	@Override
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleNo.getTextValue());
		String titleName = pTitleName.getTextValue();
		return new Title(titleNo, titleName);
	}
	@Override
	public void setContent(Title title){
		pTitleNo.setTextValue(title.getTitleNo()+"");
		pTitleName.setTextValue(title.getTitleName());
	}
	@Override
	public void isEmptyCheck() throws Exception{
		pTitleNo.isEmptyCheck();
		pTitleName.isEmptyCheck();
	}
	@Override
	public void clear(){
		pTitleNo.setTextValue("");
		pTitleName.setTextValue("");
	}
}
