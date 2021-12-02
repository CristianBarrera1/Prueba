package manageErrors;

public class MissingDataException extends Exception{
  // public MissingDataException (){}
  public MissingDataException(String message){
    super (message);
  }
}
