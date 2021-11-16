public class StringResources {

    public static String imgError = "Pop-Up item images are the same!";

    public static String priceMatchAdditionError = "Full price doesn't match! after addition!";

    public static String priceMatchSubtractionError = "Full price doesn't match after minus!";

    public static String tosError = "Terms of service is not displayed correctly!";

    public static String itemStockError = "Item not in Stock!";

    public static String orderDetailsError(String element){
        return "Error Order Details " + element + " is incorrect!";
    }

    public static String itemInspectError(String element){
        return "Error Item inspection page " + element + " is incorrect!";
    }

    public static String pageDidntLoad(String page){
        return "Error Page Element didnt load properly: "+ page +"!";
    }
}
