import java.util.*;

public class FlashSaleInventory {

    private HashMap<String,Integer> stock = new HashMap<>();
    private HashMap<String,Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId,int quantity){
        stock.put(productId,quantity);
        waitingList.put(productId,new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId,int userId){

        int current = stock.get(productId);

        if(current>0){
            stock.put(productId,current-1);
            return "Success, remaining: "+(current-1);
        }

        Queue<Integer> queue = waitingList.get(productId);
        queue.add(userId);

        return "Added to waiting list position "+queue.size();
    }

    public static void main(String[] args){

        FlashSaleInventory inv = new FlashSaleInventory();

        inv.addProduct("IPHONE15",2);

        System.out.println(inv.purchaseItem("IPHONE15",101));
        System.out.println(inv.purchaseItem("IPHONE15",102));
        System.out.println(inv.purchaseItem("IPHONE15",103));
    }
}