public class PurchaseAndCoins <T1, T2> {
    private T1 Item;
    private T2 Coins;

    public PurchaseAndCoins(T1 item, T2 coins) {
        Item = item;
        Coins = coins;

    }

    public T1 getItem() {

        return Item;
    }

    public T2 getCoins() {

        return Coins;
    }

}
