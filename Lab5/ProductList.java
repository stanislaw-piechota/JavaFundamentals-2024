package Lab5;

import java.util.Map;
import java.util.List;

import java.io.IOException;

public class ProductList extends ItemList {
    private List<String> categories = super.getCategories();
    private Map<String, List<String>> items = super.getItems();

    public ProductList() {
        super();
        this.readProductsWrapper();
    }

    private void readProducts(String filename) throws IOException {
        this.categories.clear();
        this.items.clear();

        for (String[] line: StreamOperator.readCsv(filename)){
            super.addItem(line[0], line[1]);
        }
    }

    public void readProductsWrapper(){
        String filename = "";
        while (true){
            try {
                filename = StreamOperator.readValidatedInput(
                        "Enter product list filename", 
                        StreamOperator.PATH_REGEX
                );
                this.readProducts(filename);
                return;
            } catch (Exception e) {
                System.err.println("File " + filename + " doesnt exist, try again");
            }
        }
    }
}
