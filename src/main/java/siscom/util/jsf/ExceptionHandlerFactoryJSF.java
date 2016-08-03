package siscom.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class ExceptionHandlerFactoryJSF extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;
	
	public ExceptionHandlerFactoryJSF(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new ExceptionHandlerJSF(parent.getExceptionHandler());
		
	}

}
