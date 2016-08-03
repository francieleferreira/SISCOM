package siscom.util.jsf;




import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class ExceptionHandlerJSF extends ExceptionHandlerWrapper {
	private ExceptionHandler wrapped;
	
	public ExceptionHandlerJSF(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public javax.faces.context.ExceptionHandler getWrapped() {
		
		return this.wrapped;
	}
	
	@Override
	//metodo chamado quando ocorre uma exceção
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		while (events.hasNext()) {
			ExceptionQueuedEvent        event   = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable exception = context.getException();
			boolean handle = false;
			try{
				//Tratar Exceção redirecionando para a pagina inicial;
				if(exception instanceof ViewExpiredException){
					handle = true;
					redirect("/");
				}
				else{
					handle  = true;
					redirect("/erro.xhtml");
				}
			}finally{
				if(handle){
					events.remove();	
				}
			}
		}
		getWrapped().handle();
	}
	
	private void redirect(String page){
		try{
			FacesContext    facesContext    = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();
			
			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		}catch(IOException e){
			throw new FacesException(e);
		}
		
	}

}
