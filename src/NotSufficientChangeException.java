public class NotSufficientChangeException extends Throwable {
    String message;

    public NotSufficientChangeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
