package com.example.wes_o.testluckyapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wes_o.testluckyapp.Entities.Product;
import com.example.wes_o.testluckyapp.R;

import java.util.ArrayList;

/**
 * Created by wes_o on 6/04/2018.
 */

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ViewHolderProducts> {

    ArrayList<Product> productArrayList;

    public ListProductsAdapter(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @Override
    public ViewHolderProducts onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_products,null,false);
        return new ViewHolderProducts(view);

    }

    @Override
    public void onBindViewHolder(ViewHolderProducts holder, int position) {
        holder.codigo.setText(productArrayList.get(position).getId());
        holder.precio.setText(productArrayList.get(position).getPrecio());
        holder.stock.setText(productArrayList.get(position).getStock());

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ViewHolderProducts extends RecyclerView.ViewHolder {
        TextView  codigo, precio, stock;

        public ViewHolderProducts(View itemView) {
            super(itemView);
            codigo = (TextView) itemView.findViewById(R.id.textCodigo);
            precio = (TextView) itemView.findViewById(R.id.textPrecio);
            stock = (TextView) itemView.findViewById(R.id.textStock);
        }
    }
}
