package Lab5;

public class ShoppingListApp {
    private ProductList productList;
    private ShoppingList shoppingList = new ShoppingList();

    public static void displayMenu(){
        System.out.println("\nSelect operation to perform on your shopping list");
        System.out.println("1) Load product list from the file");
        System.out.println("2) Add product to your shopping list");
        System.out.println("3) Display all products on your shopping list");
        System.out.println("4) Remove product from your shopping list");
        System.out.println("5) Save the shopping list");
        System.out.println("6) Exit the program\n");
    }

    private void addItemToShoppingList(){
        String category, item;
        this.productList.printCategories();
        category = this.productList.getCategories().get(StreamOperator.readInt(
                "Enter category number",
                1, this.productList.getCategories().size()) - 1);
        this.productList.printItems(category);
        item = this.productList.getItems(category).get(StreamOperator.readInt(
                "Enter product number",
                1, this.productList.getItems(category).size()) - 1);
        this.shoppingList.addItem(category, item);
        System.out.println("Item " + item + " (" + category + ") was added to your shopping List");
    }

    private void removeItemFromShoppingList(){
        String category, item;
        this.shoppingList.printItemsWithIndexes();
        category = this.shoppingList.getCategories().get(StreamOperator.readInt(
                "Enter category number",
                1, this.shoppingList.getCategories().size()) - 1);
        this.shoppingList.printItems(category);
        item = this.shoppingList.getItems(category).get(StreamOperator.readInt(
                "Enter product number",
                1, this.shoppingList.getItems(category).size()) - 1);
        this.shoppingList.removeItem(category, item);
        System.out.println("Item " + item + " (" + category + ") was removed from your shopping List");
    }

    public void run(){
        int operation;

        this.productList = new ProductList();
        while (true){
            displayMenu();
            operation = Integer.parseInt(
                StreamOperator.readValidatedInput("Choose an operation", StreamOperator.NUMBER_REGEX)
            );
            switch (operation){
                case 1:
                    this.productList.readProductsWrapper();
                    this.productList.printItems();
                    break;
                case 2:
                    this.addItemToShoppingList();
                    break;
                case 3:
                    this.shoppingList.printItems();
                    break;
                case 4:
                    this.removeItemFromShoppingList();
                    break;
                case 5:
                    this.shoppingList.saveListWrapper();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingListApp app = new ShoppingListApp();
        app.run();
    }
}
