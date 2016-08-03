package siscom.service;

public class NegocioException extends RuntimeException {
	private NegocioException(String msg){
		super(msg);
	}
}
