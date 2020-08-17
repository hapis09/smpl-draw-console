package hfz.code.smpldrawconsole.exception;

public class InvalidCommandException extends Exception{

    public InvalidCommandException(String message){
        super(message);
    }

    public InvalidCommandException(String message, Throwable throwable){
        super(message, throwable);
    }
}
