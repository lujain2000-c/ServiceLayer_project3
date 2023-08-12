package com.example.project3.Service;

import com.example.project3.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();



    public ArrayList<User> getAllUsers(){
        return users;
    }

    public boolean addUser(User newUser){

        if(newUser.getRole().equalsIgnoreCase("Admin") || newUser.getRole().equalsIgnoreCase("Customer")) {
            users.add(newUser);
            return true;
        }
        return false;
    }

    public boolean updateUser(String id , User newUser){

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                if(newUser.getRole().equalsIgnoreCase("Admin") || newUser.getRole().equalsIgnoreCase("Customer")) {
                    users.set(i, newUser);
                    return true;
                }
                break;
            }

        }
        return false;

    }

    public boolean deleteUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }

        }
        return false;

    }

    public boolean userBalance(String userId , Double productPrice){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(userId)) {
                if (users.get(i).getBalance() >= productPrice) {
                    users.get(i).setBalance(users.get(i).getBalance() - productPrice);
                    return true;
                }
                break;
            }

        }
        return false;
    }
}
