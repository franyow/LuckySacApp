package com.example.wes_o.testluckyapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wes_o.testluckyapp.Entities.Market;
import com.example.wes_o.testluckyapp.Activities.MapsActivity;
import com.example.wes_o.testluckyapp.Activities.ProductsActivity;
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
    public void onBindViewHolder(ViewHolderMarkets holder, final int position) {
        holder.nombre.setText(marketList.get(position).getNombre());
        holder.direccion.setText(marketList.get(position).getDireccion());
        holder.distrito.setText(marketList.get(position).getDistrito());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Bundle positionG = new Bundle();

                switch(position){
                    case 0:

                        Intent i = new Intent(context, ProductsActivity.class);

                        positionG.putInt("positionA",1);
                        i.putExtras(positionG);
                        context.startActivity(i);
                        break;

                    case 1:
                        Intent j = new Intent(context, ProductsActivity.class);
                        positionG.putInt("positionA",2);
                        j.putExtras(positionG);
                        context.startActivity(j);
                        break;

                    case 2:
                        Intent k = new Intent(context, ProductsActivity.class);
                        positionG.putInt("positionA",3);
                        k.putExtras(positionG);
                        context.startActivity(k);
                        break;
                }
            }

        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Bundle positionG = new Bundle();


                switch(position){
                    case 0:

                        Intent i = new Intent(context, MapsActivity.class);

                        positionG.putInt("positionA",1);
                        i.putExtras(positionG);
                        context.startActivity(i);
                        break;

                    case 1:
                        Intent j = new Intent(context, MapsActivity.class);
                        positionG.putInt("positionA",2);
                        j.putExtras(positionG);
                        context.startActivity(j);
                        break;

                    case 2:
                        Intent k = new Intent(context, MapsActivity.class);
                        positionG.putInt("positionA",3);
                        k.putExtras(positionG);
                        context.startActivity(k);
                        break;
                }

            }
        });










    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

    public class ViewHolderMarkets extends RecyclerView.ViewHolder {

        TextView nombre, direccion, distrito;
        public LinearLayout linearLayout;

        public ImageView imageView;








        public ViewHolderMarkets(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            direccion = (TextView) itemView.findViewById(R.id.textDireccion);
            distrito = (TextView) itemView.findViewById(R.id.textDistrito);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);

            imageView = (ImageView) itemView.findViewById(R.id.imgMarca);

            //imageView.setOnClickListener((View.OnClickListener) this);







        }



        };




    }

