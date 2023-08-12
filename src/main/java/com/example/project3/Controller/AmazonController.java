package com.example.project3.Controller;

import com.example.project3.ApiResponse.ApiResponse;
import com.example.project3.Model.Category;
import com.example.project3.Model.Product;
import com.example.project3.Model.Merchant;
import com.example.project3.Model.MerchantStock;
import com.example.project3.Model.User;
import com.example.project3.Service.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor
public class AmazonController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;
    private final UserService userService;

   //product
    @GetMapping("/getproduct")
   public ArrayList<Product> getAllProduct(){
       return productService.getAllProducts();
   }

   @PostMapping("/addproduct")
   public ResponseEntity addProduct(@RequestBody @Valid Product newProduct, Errors errors){
     if(errors.hasErrors()){
         String message = errors.getFieldError().getDefaultMessage();
         return ResponseEntity.status(400).body(message);
     }
     productService.addProduct(newProduct);
      return ResponseEntity.status(200).body(new ApiResponse("The product has been added"));

   }

   @PutMapping("/updateproduct/{id}")
   public ResponseEntity updateProduct(@PathVariable String id , @RequestBody @Valid Product product, Errors errors){
       if(errors.hasErrors()){
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       boolean isUpdated = productService.updateProduct(id,product);
       if(isUpdated){
           return ResponseEntity.status(200).body(new ApiResponse("The product has be updated"));

       }
       return ResponseEntity.status(400).body(new ApiResponse(" update failed"));
   }

   @DeleteMapping("/deleteproduct/{id}")
   public ResponseEntity deleteProduct(@PathVariable String id){
       boolean isDeleted = productService.deleteProduct(id);
       if(isDeleted){
           return ResponseEntity.status(200).body(new ApiResponse("The product has be deleted"));

       }
       return ResponseEntity.status(400).body(new ApiResponse(" delete failed"));
   }


   //Category

   @GetMapping("/getcategory")
   public ArrayList<Category> getAllCategory(){
       return categoryService.getAllCategories();
   }

    @PostMapping("/addcategory")
    public ResponseEntity addCategory(@RequestBody @Valid Category newCategory, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(newCategory);
        return ResponseEntity.status(200).body(new ApiResponse("The category has been added"));

    }

    @PutMapping("/updatecategory/{id}")
    public ResponseEntity updateCategory(@PathVariable String id , @RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = categoryService.updateCategory(id,category);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("The category has be updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" update failed"));
    }

    @DeleteMapping("deletecategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isDeleted = categoryService.deleteCategory(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The category has be deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" delete failed"));
    }


    //Merchant

    @GetMapping("/getmerchant")
    public ArrayList<Merchant> getAllMerchants(){
        return merchantService.getAllMerchants();
    }

    @PostMapping("/addmerchant")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant newMerchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(newMerchant);
        return ResponseEntity.status(200).body(new ApiResponse("The merchant has been added"));

    }

    @PutMapping("/updatemerchant/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id , @RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchant(id,merchant);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("The merchant has be updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" update failed"));
    }

    @DeleteMapping("deletemerchant/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean isDeleted = merchantService.deleteMerchant(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The merchant has be deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" delete failed"));
    }


    //MerchantStock

    @GetMapping("/getmerchantstock")
    public ArrayList<MerchantStock> getAllMerchantStocks(){
        return merchantStockService.getAllMerchantStocks();
    }

    @PostMapping("/addmerchantstock")
    public ResponseEntity addMerchant(@RequestBody @Valid MerchantStock newMerchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

       merchantStockService.addMerchantStock(newMerchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("The merchantStock has been added"));

    }

    @PutMapping("/updatemerchantstock/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id , @RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("The merchantStock has be updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" update failed"));
    }

    @DeleteMapping("deletemerchantstock/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The merchantStock has be deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" delete failed"));
    }



    //User

    @GetMapping("/getuser")
    public ArrayList<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    public ResponseEntity addUser(@RequestBody @Valid User newUser, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isAdd = userService.addUser(newUser);
        if(isAdd) {
            return ResponseEntity.status(200).body(new ApiResponse("The User has been added"));
        }else{
            return ResponseEntity.status(400).body(new ApiResponse("The User not added the role should be Admin or Customer"));
        }

    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity updateUser(@PathVariable String id , @RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id,user);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("The User has be updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" update failed"));
    }

    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("The merchantStock has be deleted"));

        }
        return ResponseEntity.status(400).body(new ApiResponse(" delete failed"));
    }

    @PutMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity buy(@PathVariable String productId,@PathVariable String userId,@PathVariable String merchantId){

        if (userService.userBalance(userId,productService.productPrice(productId))){
           if(merchantStockService.buyProduct(userId,productId,merchantId)){
               return ResponseEntity.status(200).body(new ApiResponse("Purchase completed successfully"));
           }
        }
        return ResponseEntity.status(400).body(new ApiResponse(" buying process is failed "));
    }








}
