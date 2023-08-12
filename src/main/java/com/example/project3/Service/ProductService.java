package com.example.project3.Service;

import com.example.project3.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();



    public ArrayList<Product> getAllProducts(){
        return products;
    }

    public void addProduct(Product newProduct){
        products.add(newProduct);
    }

    public boolean updateProduct(String id , Product product){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(id)){
                products.set(i,product);
                return true;
            }

        }
       return false;

    }

    public boolean deleteProduct(String id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() .equals(id)){
                products.remove(i);
                return true;
            }

        }
        return false;

    }

    public Double productPrice(String productId){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId().equals(productId)) {
                    return products.get(i).getPrice();
                }

            }

        return 0.0;
    }


}
