public class MainSoldOutException {
    String message;
    public MainSoldOutException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
