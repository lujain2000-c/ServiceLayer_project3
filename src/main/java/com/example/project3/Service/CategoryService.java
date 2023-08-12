package com.example.project3.Service;

import com.example.project3.Model.Category;
import com.example.project3.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();



    public ArrayList<Category> getAllCategories(){
        return categories;
    }

    public void addCategory(Category newCategory){
        categories.add(newCategory);
    }

    public boolean updateCategory(String id , Category category){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId().equals(id)){
                categories.set(i,category);
                return true;
            }

        }
        return false;

    }

    public boolean deleteCategory(String id){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId().equals(id)){
                categories.remove(i);
                return true;
            }

        }
        return false;

    }
}
