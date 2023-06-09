package com.example.addtocart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.addtocart.R;
import com.example.addtocart.adapters.CartListAdapter;
import com.example.addtocart.databinding.FragmentCartBinding;
import com.example.addtocart.models.CartItem;
import com.example.addtocart.viewmodel.ShopViewModel;

import java.util.List;


public class CartFragment extends Fragment implements  CartListAdapter.CartInterface{

    private static final String TAG = "CartFragment";
    ShopViewModel shopViewModel;
    FragmentCartBinding fragmentCartBinding;



    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = FragmentCartBinding.inflate(inflater,container,false);
        return fragmentCartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final CartListAdapter cartListAdapter = new CartListAdapter(this);
        fragmentCartBinding.CartItemRecView.setAdapter(cartListAdapter);

        fragmentCartBinding.CartItemRecView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL ));
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCart().observe(getViewLifecycleOwner(), cartItems -> cartListAdapter.submitList(cartItems));
    }

    @Override
    public void deleteItem(CartItem cartItem) {
        shopViewModel.removeItemFromCart(cartItem);
    }
}