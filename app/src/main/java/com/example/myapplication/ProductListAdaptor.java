package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdaptor extends RecyclerView.Adapter<ProductListAdaptor.ProductViewHolder> {

    class ProductViewHolder extends RecyclerView.ViewHolder{    //implements View.OnClickListener
        CardView cv;
        TextView productName;
        TextView productDesc;
        ImageView productImage;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            productName = itemView.findViewById(R.id.productName);
            //productInfo = itemView.findViewById(R.id.productInfo);
            productImage = itemView.findViewById(R.id.productImage);
//            itemView.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product currentProduct = productList.get(getAdapterPosition());
                    Intent detailIntent = new Intent(itemView.getContext(), ProductDetail.class);
                    detailIntent.putExtra("name", currentProduct.getName());
                    detailIntent.putExtra("image_resource", currentProduct.getImageResource());
                    detailIntent.putExtra("desc", currentProduct.getDesc());
                    detailIntent.putExtra("menu", currentProduct.getMenu());
                    itemView.getContext().startActivity(detailIntent);
                }
            });
        }

//        @Override
//        public void onClick(View v) {
//            // Get the position of the item that was clicked.
//            int pPosition = getLayoutPosition();
//
//            // Use that to access the affected item in productList.
//            String element = productList.get(pPosition);
//
//            // Change the product in the productList.
//            productList.set(pPosition, "Clicked! " + element);
//
//            // Notify the adapter, that the data has changed so it can
//            // update the RecyclerView to display the data.
//            pAdaptor.notifyDataSetChanged();
//        }
    }

    private final ArrayList<Product> productList;

    public ProductListAdaptor(ArrayList<Product> productList) {
        //pInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View pItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist_item, parent,false);
        return new ProductViewHolder(pItemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.productName.setText(productList.get(position).getName());
        //holder.productInfo.setText(productList.get(position).getInfo());
        holder.productImage.setImageResource(productList.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView rv){
        super.onAttachedToRecyclerView(rv);
    }
}
