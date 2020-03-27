package exceptions;

public class BusinessServiceException extends Exception {

	public BusinessServiceException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public BusinessServiceException(String message)
	{
		super(message);
	}

	public BusinessServiceException(Throwable cause)
	{
		super(cause);
	}

}
