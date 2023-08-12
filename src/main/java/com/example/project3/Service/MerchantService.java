package com.example.project3.Service;

import com.example.project3.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();



    public ArrayList<Merchant> getAllMerchants(){
        return merchants;
    }

    public void addMerchant(Merchant newMerchant){
        merchants.add(newMerchant);
    }

    public boolean updateMerchant(String id , Merchant product){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(id)){
                merchants.set(i,product);
                return true;
            }

        }
        return false;

    }

    public boolean deleteMerchant(String id){
        for (int i = 0; i < merchants.size(); i++) {
            if(merchants.get(i).getId().equals(id)){
                merchants.remove(i);
                return true;
            }

        }
        return false;

    }
}
