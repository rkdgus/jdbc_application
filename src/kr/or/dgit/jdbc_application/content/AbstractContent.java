package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractContent<T> extends JPanel {
	

	
	
	
	public abstract T getContent() ;
	
	public abstract void setContent(T content);

	public abstract void isEmptyCheck() throws Exception;
	
	public abstract void clear();
	
	public abstract void changeContent(Object content);
	
	public abstract void enable (boolean ok);
}
