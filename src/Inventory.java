import java.util.Map;
public class Inventory < T >{
    private Map<T, Integer> inventory;

    public Inventory() {

        this.inventory = inventory;
    }
    public int getQuantity(T item){
        int quantity = inventory.get(item);
        if(quantity <= 0){
            return 0;
        }
        return quantity;
    }

    public void add (T item){

        int count = inventory.get(item);                 // add item de catre admin
        inventory.put(item,count + 1);


    }

    public boolean hasItem(T item){
        return inventory.get(item) > 0;               //verif daca exista
    }

    public void decrease (T item){
        int count = inventory.get(item);      // scoatere item
        inventory.put(item, count - 1);
    }

    public void clear (){
        inventory.clear();
    }
    public void put(T item, int quantity){
        inventory.put (item, quantity);
    }
}
