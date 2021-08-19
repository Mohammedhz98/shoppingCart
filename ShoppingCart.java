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
        while(quantity > product.getQuantityInStock()) {
                System.out.println("I'm sorry we cannot add " + quantity + " '" + product.getName() + "' to your basket as" +
                        " we only have " + product.getQuantityInStock() + " '" + product.getName() + "'s' in stock" +
                        " please input a quantity less than the amount in stock.");
                howMany = new Scanner(System.in);
                quantity = howMany.nextInt();
        }
        shoppingBasket.add(new ItemInCart(product.getName(),product.getPrice(),product.getSale(),product.getQuantityInStock(),quantity));
        System.out.println(quantity + " '" + product.getName() + "'s' added to the basket.");
    }

    public void removeItemFromCart(Item product) {
        int itemQuantity = 0;
        for(ItemInCart i: shoppingBasket) {
            if(i.getName().equals(product.getName())) {
                itemQuantity = i.getQuantity();
            }
        }
        System.out.println("How many '" + product.getName() + "' would you like to remove form the basket? ");
        Scanner howMany = new Scanner(System.in);
        int remove = howMany.nextInt();
        while(remove > itemQuantity) {
            System.out.println("You cannot remove " + remove + " '" + product.getName() + "'s' from your basket" +
                               " due to there being only " + itemQuantity + " '" + product.getName() + "'s' in your" +
                               " basket. Please input an amount either less than or the same as the amount in your" +
                               " basket." );
            howMany = new Scanner(System.in);
            remove = howMany.nextInt();
        }
        for(ItemInCart i: shoppingBasket) {
            if(i.getName().equals(product.getName()) && itemQuantity == remove) {
                shoppingBasket.remove(i);
                System.out.println(i.getName() + " has been removed from the basket.");
            }
            else if(i.getName().equals(product.getName())){
                int itemsLeft = itemQuantity - remove;
                i.setQuantity(itemsLeft);
                System.out.println(remove + " '" + product.getName() + "'s' have been removed from your basket. There" +
                                   " are now " + i.getQuantity() + " '" + " '" + i.getName() + "'s' left in your " +
                                   " basket." );
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
        StringBuilder itemList = new StringBuilder();
        for(ItemInCart i: shoppingBasket) {
            if(i == shoppingBasket.get(shoppingBasket.size() -1)) {
                itemList.append(" "+ i.getQuantity() + " " + i.getName() + "'s.");
            }
            else {
                itemList.append(" " + i.getQuantity() + " " + i.getName() + "'s,");
            }
        }
        if(shoppingBasket.isEmpty()) {
            return "Your shopping basket is currently empty.";
        }
        else
          return "Your shopping basket currently has the following items:" + itemList + " Which comes to a total price" +
                  " of \u00A3" + ShoppingCart.this.totalCartPrice();
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
        //System.out.println(myStuff.totalCartPrice());
        //System.out.println(String.valueOf(myBasket));
    }
}
