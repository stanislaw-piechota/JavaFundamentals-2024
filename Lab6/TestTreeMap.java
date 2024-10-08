package Lab6;

import java.util.TreeMap;
import java.util.Map;

public class TestTreeMap {
    private Map<TelephoneNumber, TelephoneEntry> treeMap = new TreeMap<>();
    
    private void addPerson(String name, String lastName, String address, String number){
        Person newPerson = new Person(name, lastName, address, number);
        this.treeMap.put(newPerson.getNumber(), newPerson);
    } 

    private void printTreeMap(){
        for (Map.Entry<TelephoneNumber, TelephoneEntry> entry : this.treeMap.entrySet()) {
            System.out.println(String.format(
                "Person registered under %s\n%s\n\n",
                entry.getKey().toString(),
                entry.getValue().description()
            ));
        }
    }

    public TestTreeMap(){}

    public static void main(String[] args) {
        TestTreeMap testMap = new TestTreeMap();
        testMap.addPerson("Stanislaw", "Piechota", "Poland Lodz Politechniki 3", "+48123456789");
        testMap.addPerson("Jakub", "Nowak", "Germany Berlin Hauptstrasse 47", "35123456789");
        testMap.addPerson("Jacob", "Smaruj-Rogala", "USA Masachussets Street 56", "+1 123456789");
        testMap.printTreeMap();
    }
}
