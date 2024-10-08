package Lab6;

public class Address {
    private String country;
    private String city;
    private String street;
    private int number;

    public Address(String country, String city, String street, String number){
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = Integer.parseInt(number);
    }

    public String toString(){
        return String.format(
            "%s, %s, %s %d",
            this.country, this.city,
            this.street, this.number
        );
    }

    public static Address fromString(String address) throws IllegalArgumentException{
        String[] data = address.split(" ");
        return new Address(data[0], data[1], data[2], data[3]);
    }
}
