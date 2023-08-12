package com.example.project3.Service;

import com.example.project3.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();



    public ArrayList<MerchantStock> getAllMerchantStocks(){
        return merchantStocks;
    }

    public void addMerchantStock(MerchantStock newProduct){
        merchantStocks.add(newProduct);
    }

    public boolean updateMerchantStock(String id , MerchantStock product){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equals(id)){
                merchantStocks.set(i,product);
                return true;
            }

        }
        return false;

    }

    public boolean deleteMerchantStock(String id){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equals(id)){
                merchantStocks.remove(i);
                return true;
            }

        }
        return false;

    }


    public boolean additionalStok(String productId,String merchantId ,Integer additionalStok ){
        for (int i = 0; i < merchantStocks.size(); i++) {
            if(merchantStocks.get(i).getId().equals(productId)){
                merchantStocks.get(i).setStock(merchantStocks.get(i).getStock() + additionalStok);
                return true;
            }

        }
        return false;
    }

   public boolean buyProduct(String userId,String productId,String merchantId){


       for (int i = 0; i < merchantStocks.size(); i++) {
           if(merchantStocks.get(i).getMerchantid().equals(merchantId) && merchantStocks.get(i).getProductid().equals(productId)){
               if(merchantStocks.get(i).getStock() != 0) {
                   merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()-1);
                   return true;
               }
               return false;
           }

       }
       return false;
   }
}
