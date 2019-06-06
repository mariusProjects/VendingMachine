import java.util.List;

public interface VendingMachine {
    public long selectItemAndGetPrice(Item item) throws SoldOutException, NotSufficientChangeException ;
    public void insertCoins (Coin coin);
    public List<Coin> refund() throws NotSufficientChangeException;
    public PurchaseAndCoins<Item, List<Coin>> collectItemAndChange() throws NotSufficientChangeException, NotFullyPaidException;
    public void reset();
    public void printStats();


    // void selectItemAndGetPrice(Item i);  SoldOutException
    // void insertCoin(Coin c);
    // List<Coin> refund;         NotSufficientChangeException - NotFulLyPaidException - custom exception sunt toate
    // PurchaseAndCoins<Item, List<Coin> collectItemAndChange();      //- fara parametru-return PurchaseAndCoins
    //void reset();
}
