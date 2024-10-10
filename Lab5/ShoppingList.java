package Lab5;

import java.util.Map;
import java.util.List;

import java.io.IOException;

public class ShoppingList extends ItemList {
    private Map<String, List<String>> items = super.getItems();

    public ShoppingList(){
        super();
    }

    public void printItemsWithIndexes(){
        int counter = 0;
        System.out.println();

        if (this.items.isEmpty()) {
            System.out.println("This list is empty");
            return;
        }

        for (Map.Entry<String, List<String>> entry : this.items.entrySet()) {
            System.out.println(++counter + ") " + entry.getKey());
            for (String item : entry.getValue()) {
                System.out.println("- " + item);
            }
        }

        System.out.println();
    }

    public void saveListWrapper(){
        try {
            String filename = StreamOperator.readValidatedInput(
                "Enter filename to save you shopping list", 
                StreamOperator.PATH_REGEX);
            StreamOperator.writeCsv(filename, this.items);
            System.out.println("Your shopping list was saved in " + filename);
        } catch (IOException e) {
            System.err.println("There was an error while saving your list, try again");
        }
    }
}
