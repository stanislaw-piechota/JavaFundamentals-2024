package Lab6;

public class Person extends TelephoneEntry {
    private String name;
    private String lastName;
    private String address;
    private TelephoneNumber number;

    public Person(String name, String lastName, String address, String number){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.number = TelephoneNumber.fromString(number);
    }

    public TelephoneNumber getNumber() {
        return this.number;
    }

    @Override
    public String description(){
        return String.format(
            "Name: %s\nSurname: %s\nAddress: %s\nPhone: %s", 
            this.name, this.lastName, 
            this.address, this.number.toString());
    }
}