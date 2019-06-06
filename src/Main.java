public class Main {
    public static void main(String[] args) throws SoldOutException, NotSufficientChangeException {

        VendingMachine vm = new VendingMachineImpl();
        vm.selectItemAndGetPrice(Item.MARS);
        System.out.println(vm.selectItemAndGetPrice(Item.BOUNTY));
        System.out.println(vm.selectItemAndGetPrice(Item.TWIX));
        System.out.println(vm.selectItemAndGetPrice(Item.MARS));
        vm.insertCoins(Coin.TEN);
        vm.insertCoins(Coin.TWENTY);
        vm.printStats();




    }
}
