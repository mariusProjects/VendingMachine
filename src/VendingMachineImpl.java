import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    Inventory<Coin> cashInventory = new Inventory<Coin>();
    Inventory<Item> itemInventory = new Inventory<Item>();
    long totalSales;
    Item currentItem;
    long currentBalance;

    public void VM() {
        initialize();
    }

    public void initialize() {
        for (Coin coin : Coin.values()) {
            cashInventory.put(coin, 5);
        }
        for (Item item : Item.values()) {
            itemInventory.put(item, 5);
        }

    }

    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item) == true) {
            currentItem = item;
        }
        return currentItem.getPrice();

    }

    public void insertCoins(Coin coin) {
        currentBalance = currentBalance + coin.getValue();
        cashInventory.add(coin);
    }

    public void updateCashInventory(List<Coin> change){
        for(Coin coin : change){
            cashInventory.decrease(coin);

        }

    }
    public boolean isFullyPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }

    private List<Coin> getChange(long amount) {
        List<Coin> changes = Collections.EMPTY_LIST;
        long balance = amount;
        while (balance > 0) {
            if (balance >= Coin.FIFTY.getValue() && cashInventory.hasItem(Coin.FIFTY)) {
                changes.add(Coin.FIFTY);
                balance = balance - Coin.FIFTY.getValue();
                continue;

            } else if (balance >= Coin.TWENTY.getValue() && cashInventory.hasItem(Coin.TWENTY)) {
                changes.add(Coin.TWENTY);
                balance = balance - Coin.TWENTY.getValue();
                continue;

            } else if (balance >= Coin.TEN.getValue() && cashInventory.hasItem(Coin.TEN)) {
                changes.add(Coin.TEN);
                balance = balance - Coin.TEN.getValue();
                continue;

            } else if (balance >= Coin.FIVE.getValue() && cashInventory.hasItem(Coin.FIVE)) {
                changes.add(Coin.FIVE);
                balance = balance - Coin.FIVE.getValue();
                continue;

            }


        }
        return changes;
    }


    public boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);

        } catch (Exception e) {
            e.printStackTrace();
            return hasChange = false;
        }
        return hasChange;
    }
    public boolean hasSufficientChange(){
        long suficientChange = currentBalance - currentItem.getPrice();
//        long currentItemPrice = currentItem.getPrice();
        if(suficientChange <= 0 ){
            return false;
        }
        return true;
    }
    public Item collectItem(){
        if(isFullyPaid()== true && hasSufficientChange()){
            itemInventory.decrease(currentItem);
        }
        return currentItem;
    }
    public List<Coin> collectChange(){
        long changeAmount = currentBalance - currentItem.getPrice();
//        getChange(changeAmount);
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;

    }
    public PurchaseAndCoins<Item, List<Coin>> collectItemAndChange(){
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        PurchaseAndCoins<Item, List<Coin>> collectitemAndChange1 = new PurchaseAndCoins<Item, List<Coin>>(item, change);
        return  collectitemAndChange1;

    }
    public List<Coin> refund(){
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }
    public void reset(){
        itemInventory.clear();
        cashInventory.clear();
        totalSales = 0;
        currentBalance = 0;
        currentItem = null;

    }
    public void printStats(){
        System.out.println("Total sales: " + totalSales);
        System.out.println("Current Item inventory: " + itemInventory);
        System.out.println("Current Cash Inventory: " + cashInventory);
    }
    public long getTotalSales(){
        return totalSales;

    }

}
