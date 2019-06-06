public class NotFullyPaidException extends Throwable {

    private String message;
    private long remaining;

    public NotFullyPaidException(String message) {
        this.message = message;
        this.remaining = remaining;
    }

    public long getRemaining() {
        return remaining;
    }

    @Override
    public String getMessage() {
        return message + remaining;
    }
}
