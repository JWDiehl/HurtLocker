import java.util.HashMap;
import java.util.Map;

public class ItemSummary {
    private String name;
    private int count;
    private Map<Double, Integer> priceCountMap;

    public ItemSummary(String name) {
        this.name = name;
        this.count = 0;
        this.priceCountMap = new HashMap<>();
    }

    public void incrementCount() {
        count++;
    }

    public void addPrice(double price) {
        priceCountMap.put(price, priceCountMap.getOrDefault(price, 0) + 1);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Map<Double, Integer> getPriceCountMap() {
        return priceCountMap;
    }
}
