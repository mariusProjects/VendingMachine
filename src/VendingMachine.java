import java.util.List;

public interface VendingMachine {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin (Coin c);
    public List<Coin> refund();
    public PurchaseAndCoins<Item, List<Coin>> collectItemAndCharge();
    public void reset();


    // void selectItemAndGetPrice(Item i);  SoldOutException
    // void insertCoin(Coin c);
    // List<Coin> refund;         NotSufficientChangeException - NotFulLyPaidException - custom exception sunt toate
    // PurchaseAndCoins<Item, List<Coin> collectItemAndChange();      //- fara parametru-return PurchaseAndCoins
    //void reset();
}
