package Lab6;
import Lab6.TelephoneNumber;

public class Company extends TelephoneEntry {
    private String name;
    private String address;
    private TelephoneNumber number;
    
    public Company(String name, String address, String number){
        this.name = name;
        this.address = address;
        this.number = TelephoneNumber.fromString(number);
    }

    @Override
    public String description(){
        return String.format(
            "%s, %s, %s", this.name, this.address, 
            this.number.toString()
        );
    }
}