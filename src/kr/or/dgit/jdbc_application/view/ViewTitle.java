package kr.or.dgit.jdbc_application.view;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
	
	

	
	public ViewTitle(String title) {
		super(title);
		}


	protected AbstractList createList() {
		pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}


	@SuppressWarnings("unchecked")
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent(service);
		return (AbstractContent<Title>) pContent;
	}


	@Override
	protected void createService() {
		service = new TitleService();
		
		
	}


	@Override
	protected void insertContent(Object content) {
		service.insertTitle((Title) content);
		
	}


	@Override
	protected void deleteContent(Object item) {
		service.deleteTitle((Title) item);
		
	}


	@Override
	protected void updateContent(Object item) {
		
		service.updateTitle((Title) item);
	}


	@Override
	protected Title searchContent(int item) {
		return service.selectTitleByNo(new Title(item));
		
	}





	

}
