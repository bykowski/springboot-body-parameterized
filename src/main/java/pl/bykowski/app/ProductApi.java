package pl.bykowski.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {

    private List<Product> itemList;

    public ProductApi() {
        itemList = new ArrayList<>();
        itemList.add(new Product("TV", 100));
        itemList.add(new Product("PC", 200));
        itemList.add(new Product("Keyboard", 10));
    }

    @GetMapping("/getProductList")
    public List<Product> getProductList() {
        return itemList;
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        itemList.add(product);
    }
}