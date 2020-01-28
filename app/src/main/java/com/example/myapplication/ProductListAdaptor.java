package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ProductListAdaptor extends RecyclerView.Adapter<ProductListAdaptor.ProductViewHolder> {

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ProductViewHolder(View itemView, ProductListAdaptor adapter) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.product);
            this.pAdaptor = adapter;
            itemView.setOnClickListener(this);
        }
        public final TextView productItemView;
        final ProductListAdaptor pAdaptor;

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int pPosition = getLayoutPosition();

            // Use that to access the affected item in productList.
            String element = productList.get(pPosition);

            // Change the product in the productList.
            productList.set(pPosition, "Clicked! " + element);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            pAdaptor.notifyDataSetChanged();
        }
    }

    private final LinkedList<String> productList;
    private LayoutInflater pInflater;

    public ProductListAdaptor(Context context,
                              LinkedList<String> productList) {
        pInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View pItemView = pInflater.inflate(R.layout.productlist_item,
                parent, false);
        return new ProductViewHolder(pItemView, this);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        String pCurrent = productList.get(position);
        holder.productItemView.setText(pCurrent);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
