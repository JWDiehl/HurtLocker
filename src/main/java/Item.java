public class Item {
    private String name;
    private double price;
    private String type;
    private String expiration;

    public Item(String name, double price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//    public String getType() {
//        return type;
//    }
//
//    public String getExpiration() {
//        return expiration;
//    }
}