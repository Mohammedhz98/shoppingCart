public class Item  {
    private String name;
    private double price;
    private Boolean sale;
    private int quantityInStock;


    public Item(String itemName, double cost, Boolean onOffer, int itemsLeft) {
        this.name = itemName;
        this.price = cost;
        this.sale = onOffer;
        this.quantityInStock = itemsLeft;
    }

    public Item(String itemName, double cost, int  itemsLeft) {
        this(itemName,cost,false,itemsLeft);
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double itemPrice) {
        this.price = itemPrice;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean onSale) {
        this.sale = onSale;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int itemsLeft) {
        this.quantityInStock = itemsLeft;
    }

    public String toString() {
        return "The item you have selected '" + this.getName() + "' currently has: " + this.getQuantityInStock() +
                " items in stock at a price of \u00A3" + this.getPrice() + ".";
    }

    public static void main(String[] args) {
        Item meat = new Item("sirloin Steak",15.99,false,8);
        System.out.println(meat);
    }
}
