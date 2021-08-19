public class ItemInCart extends Item {
    private int quantity;

    public ItemInCart(String itemName, double cost, Boolean onOffer, int itemsLeft, int noOfItemInCart) {
        super(itemName, cost, onOffer, itemsLeft);
        this.quantity = noOfItemInCart;
        itemsLeft -= noOfItemInCart;
    }

    public ItemInCart(String itemName, double cost, int itemsLeft, int noOfItemInCart) {
        super(itemName, cost, itemsLeft);
        this.quantity = noOfItemInCart;
        itemsLeft -= noOfItemInCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int itemsToAdd) {
        this.quantity = itemsToAdd;
    }
}
