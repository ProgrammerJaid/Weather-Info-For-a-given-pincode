package ai.freightfox.payload;

public class ErrorBody extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cod;

	private String message;

	public ErrorBody(String cod, String message) {
		this.cod = cod;
		this.message = message;
	}

	public ErrorBody() {
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCod() {
		return cod;
	}

	public String getMessage() {
		return message;
	}

}
