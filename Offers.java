public interface Offers {

    public void bogof();

    public void threeForTwo();

    public default int discount() {
        return 0;
    }
}
