package com.example.wes_o.testluckyapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wes_o.testluckyapp.Entities.Market;
import com.example.wes_o.testluckyapp.R;

import java.util.ArrayList;

/**
 * Created by wes_o on 5/04/2018.
 */

public class ListMarketAdapter extends RecyclerView.Adapter<ListMarketAdapter.ViewHolderMarkets> {

    ArrayList<Market> marketList;

    public ListMarketAdapter(ArrayList<Market> marketList) {
        this.marketList = marketList;
    }

    @Override
    public ViewHolderMarkets onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_market,null,false);
        return new ViewHolderMarkets(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderMarkets holder, int position) {
        holder.nombre.setText(marketList.get(position).getNombre());
        holder.direccion.setText(marketList.get(position).getDireccion());
        holder.distrito.setText(marketList.get(position).getDistrito());

    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

    public class ViewHolderMarkets extends RecyclerView.ViewHolder {
        TextView nombre, direccion, distrito;


        public ViewHolderMarkets(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            direccion = (TextView) itemView.findViewById(R.id.textDireccion);
            distrito = (TextView) itemView.findViewById(R.id.textDistrito);

        }
    }
}
