package model.exceptions;

//RuntimeException: compilador não obriga
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	public DomainException(String msg) {
		super(msg);
	}
	
	//Exception: compilador obriga a tratar ou propagar
	/*public class DomainException extends Exception {
		private static final long serialVersionUID = 1L;

		
		public DomainException(String msg) {
			super(msg);
		}*/
}
