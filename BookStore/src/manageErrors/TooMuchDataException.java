package manageErrors;

public class TooMuchDataException extends Exception{
  public TooMuchDataException(String message){
	    super(message);
  }
}