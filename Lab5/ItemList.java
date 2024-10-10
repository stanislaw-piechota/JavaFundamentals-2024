package Lab5;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class ItemList {
    private List<String> categories = new ArrayList<>();
    private Map<String, List<String>> items = new TreeMap<>();

    public Map<String, List<String>> getItems() {
        return this.items;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public List<String> getItems(String category) {
        return this.items.get(category);
    }

    public void printCategories() {
        printList(this.categories);
    }

    public void printItems(String category) {
        printList(this.getItems(category));
    }

    public static void printList(List<String> list){
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ") " + list.get(i));
        }
        System.out.println();
    }

    public void printItems() {
        System.out.println();

        if (this.items.isEmpty()){
            System.out.println("This list is empty");
            return;
        }
        
        for (Map.Entry<String, List<String>> entry : this.items.entrySet()) {
            System.out.println(entry.getKey());
            for (String item : entry.getValue()) {
                System.out.println("- " + item);
            }
        }

        System.out.println();
    }

    public void addItem(String category, String item){
        if (!this.items.containsKey(category)){
            this.categories.add(category);
            this.items.put(category, new ArrayList<>());
        }
        this.getItems(category).add(item);
    }

    public void removeItem(String category, String item){
        if (this.getItems(category) == null)
            return;

        this.getItems(category).remove(item);
        if (this.getItems(category).isEmpty()){
            this.getCategories().remove(category);
            this.getItems().remove(category);
        }
    }
}
