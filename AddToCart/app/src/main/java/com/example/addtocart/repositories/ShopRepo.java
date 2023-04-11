package com.example.addtocart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.addtocart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }
    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(),"Red Velvet", 199000, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"Black Forest", 269000, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"RedVelvet", 199, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"RedVelvet", 199, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"RedVelvet", 199, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"RedVelvet", 199, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        productList.add(new Product(UUID.randomUUID().toString(),"RedVelvet", 199, "https://imgtr.ee/images/2023/04/10/nQASc.png"));
        mutableProductList.setValue(productList);
    }
}
