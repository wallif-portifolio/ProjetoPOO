package exception;

public class ReservaInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;

	public ReservaInvalidaException(String msg) {
        super(msg);
    }
}