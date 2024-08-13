import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {

    private List<Item> itemList;
    private Map<String, ItemSummary> itemCounter;
    private int errorCount;

    public JerkSONParser() {
        this.itemList = new ArrayList<>();
        this.itemCounter = new HashMap<>();
        this.errorCount = 0;
    }

    //Starting off by splitting rawData string by ##
    public String[] splitData(String rawData) {
        return rawData.split("\\s*##\\s*");
    }

    //Then will createItems from th rawData file
    public void createItem(String rawData) {
        String[] items = splitData(rawData);
        //for each loop to iterate through
        for (String itemData : items) {
            //conditional to ensure field has a value
            if (!itemData.trim().isEmpty()) {
                try {
                    Item item = parseItem(itemData);
                    if (item != null) {
                        addItemToList(item);
                    }
                    //exception !!
                } catch (Exception e) {
                    System.err.println("Error parsing item data: " + itemData);
                    System.err.println("Exception: " + e.getMessage());
                    errorCount++;
                }
            }
        }
    }

    // Next - parse an individual item from the string data
    private Item parseItem(String itemData) throws Exception {
        //based on item class - sep by name, price, type, expiration
        String name = findItemField(itemData, "name");
        String priceStr = findItemField(itemData, "price");
        String type = findItemField(itemData, "type");
        String expiration = findItemField(itemData, "expiration");

        //check to ensure that if any of these field are empty - throw an EXCEPTION if so
        if (name.isEmpty() || type.isEmpty() || expiration.isEmpty()) {
            throw new Exception("Missing required field");
        }

        //More exceptions
        double price;
        try {
            if (priceStr.isEmpty()) {
                throw new Exception("Price is missing");
            }
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid price format: " + priceStr);
        }

        //Return new items
        return new Item(name, price, type, expiration);
    }

    //REGEX Time - find item fields
    public String findItemField(String data, String field) {
        //PATTERN / MATCHER methods
        //Pattern compiles the regex into a patt object
        Pattern pattern = Pattern.compile(field + ":(.*?)(?=[;^%*@]|$)", Pattern.CASE_INSENSITIVE);
        //Which then can be used to create a matcher object
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        //if no match is found - return an emtpy string
        return "";
    }

    //adds item to list and update item counter
    public void addItemToList(Item item) {
        itemList.add(item);
        //change case so that we can count
        String key = item.getName().toLowerCase();
        ItemSummary summary = itemCounter.getOrDefault(key, new ItemSummary(item.getName()));
        summary.incrementCount();
        summary.addPrice(item.getPrice());
        itemCounter.put(key, summary);
    }

    //SUMMARY of grocery list - structured similar to output.txt
    public String groceryListConstructor() {
        //build summary string
        StringBuilder summary = new StringBuilder();

        //forEACH loop ----
        //this will iterate over each item in the itemCounter map
        for (ItemSummary itemSummary : itemCounter.values()) {

            //formats and appends the item name and count to summary
            summary.append(String.format("name: %s\t\t seen: %d times\n", itemSummary.getName(), itemSummary.getCount()));
            //appends a line of equal signs for separation
            summary.append("=============\t\t =============\n");


            //map of prices and each counts for the current item sum
            Map<Double, Integer> priceCountMap = itemSummary.getPriceCountMap();
            for (Map.Entry<Double, Integer> entry : priceCountMap.entrySet()) {
                //formats and APpends the price and then counts
                summary.append(String.format("Price:\t%.2f\t\t seen: %d times\n", entry.getKey(), entry.getValue()));
                summary.append(entry.getValue() > 1 ? "-------------\t\t -------------\n" : "-------------\t\t -------------\n");
            }

            summary.append("\n");
        }

        //erorr count - siimilar to output.txt
        if (errorCount > 0) {
            summary.append(String.format("Errors\t\t seen: %d times\n", errorCount));
        }

        return summary.toString();
    }

    public List<Item> getListOfItems() {
        return itemList;
    }
}