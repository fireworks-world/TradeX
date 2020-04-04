package com.example.tradex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.MyViewHolder> {

    private ArrayList<String> baseAsset= new ArrayList<String>();
    private ArrayList<String> quoteAsset= new ArrayList<String>();
    private ArrayList<String> price=new ArrayList<>();
    private Context context;

    public AdapterCardView(ArrayList<String> baseAsset, ArrayList<String> quoteAsset, ArrayList<String> price, Context context) {
        this.baseAsset.addAll(baseAsset);
        this.quoteAsset.addAll(quoteAsset);
        this.price.addAll(price);
        this.context=context;
    }

    public void setItems(ArrayList<String> price1) {
        this.price = new ArrayList<>(price1);
    }


    @Override
    public AdapterCardView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Text2.setText(quoteAsset.get(position));
        holder.Text3.setText(baseAsset.get(position));
        holder.Text1.setText(price.get(position));

       }


    @Override
    public int getItemCount() {
        return baseAsset.size();
    }

    public void notifyDataSetChanged(ArrayList<String> price) {
    }

    public void notify(ArrayList<String> price) {
        this.price.addAll(price);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Text1,Text2,Text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.Text1=(TextView) itemView.findViewById(R.id.textView1);
            this.Text2=(TextView)itemView.findViewById(R.id.textView2);
            this.Text3=(TextView)itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new TradeXSingleItem();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frmlyout, myFragment).addToBackStack(null).commit();


                }
            });
        }
    }
}
