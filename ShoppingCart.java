import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    ArrayList<ItemInCart> shoppingBasket;

    public ShoppingCart(ArrayList<ItemInCart> customerBasket) {
        this.shoppingBasket = customerBasket;
    }


    public void addItemToCart(Item product) {
        System.out.println("How many '" + product.getName() + "'s' would you like to add to your basket? ");
        Scanner howMany = new Scanner(System.in);
        int quantity = howMany.nextInt();
        shoppingBasket.add(new ItemInCart(product.getName(),product.getPrice(),product.getSale(),product.getQuantityInStock(),quantity));
    }

    public void removeItemFromCart(Item product) {
        for(ItemInCart i: shoppingBasket) {
            if(i.getName().equals(product.getName())) {
                shoppingBasket.remove(i);
            }
        }
    }

    public double totalCartPrice() {
        double totalCost = 0;
        for(ItemInCart i: shoppingBasket) {
            totalCost += (i.getPrice()*i.getQuantity());
        }
        return totalCost;
    }

    public ArrayList<ItemInCart> showCart() {
       return shoppingBasket;
    }

    public String toString() {
        String itemList = "";
        for(Item i: shoppingBasket) {
            if(i == shoppingBasket.get(shoppingBasket.size() -1)) {
                itemList += " " + i.getName() + ".";
            }
            else {
                itemList += " " + i.getName() + ",";
            }
        }
        if(shoppingBasket.isEmpty()) {
            return "Your shopping basket is currently empty.";
        }
        else
          return "Your shopping basket currently has the following items:" + itemList;
    }

    public static void main(String[] args) {
        ArrayList<ItemInCart> myBasket = new ArrayList<ItemInCart>();
        Item fish = new Item("Cod",5.80,5);
        Item steak = new Item("Rib-eye",18.99,3);
        Item chicken = new Item("Whole chicken",10.99,12);
        ShoppingCart myStuff = new ShoppingCart(myBasket);
        System.out.println(myStuff);
        myStuff.addItemToCart(fish);
        myStuff.addItemToCart(steak);
        System.out.println(myStuff);
        myStuff.addItemToCart(chicken);
        System.out.println(myStuff);
        myStuff.removeItemFromCart(steak);
        System.out.println(myStuff);
        System.out.println(myStuff.totalCartPrice());
        System.out.println(String.valueOf(myBasket));
    }
}
