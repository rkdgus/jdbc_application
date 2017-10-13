package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {

	

	
	public ViewTitle(String title) {
		super(title);
		}


	protected AbstractList createList() {
		ListTitle pList = new ListTitle();
		return pList;
	}


	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}
