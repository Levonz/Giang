package com.example.addtocart.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.addtocart.models.Product;
import com.example.addtocart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts(){

        return shopRepo.getProducts();
    }
}
