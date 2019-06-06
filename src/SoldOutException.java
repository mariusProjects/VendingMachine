public class SoldOutException extends Throwable {
    String message;
    public SoldOutException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
