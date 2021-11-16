public class OrderDetails {

    private final String firstName = "Allen";
    private final String lastName = "Wollf";
    private final String company = "AtlantBH";
    private final String address = "Fifth Avenue";
    private final String city = "New York,";
    private final String state = "New York";
    private final String zipCode = "10001";
    private final String country = "United States";
    private final String color = "Blue";
    private final String shippingPrice = "$2.00";
    private final String comment = "This is a test.";
    private String size;
    private String phone;
    private String unitPrice;
    private String quantity;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public String getShippingPrice() {
        return shippingPrice;
    }

    public String getComment() {
        return comment;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getFullPrice() {
        double value = Double.parseDouble(this.unitPrice.replace("$",""));
        String newValue = String.valueOf(value*Double.parseDouble(this.quantity)+2);
        return "$"+newValue;
    }

    public String fullPricePlusOne(){
        double value = Double.parseDouble(getFullPrice().replace("$",""));
        String plusValue = String.valueOf(value+Double.parseDouble(this.unitPrice.replace("$","")));
        return "$"+plusValue;
    }
}
