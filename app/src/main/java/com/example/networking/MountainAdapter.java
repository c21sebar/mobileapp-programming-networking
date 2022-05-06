package com.example.networking;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MountainAdapterViewHolder> {
    private List<Mountain> bergLista;
    private MainActivity mainActivity;
    public void setBergLista(List<Mountain> bergLista) {
        this.bergLista = bergLista;
    }

    public MountainAdapter(List<Mountain> berg, MainActivity activity){
        this.bergLista = berg;
        this.mainActivity = activity;
    }

    @NonNull
    @Override
    public MountainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new MountainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainAdapterViewHolder holder, int position) {
        holder.MountainTextView.setText("Berg: " + (1 + bergLista.indexOf(bergLista.get(position))));
        holder.ID.setText("ID: " + bergLista.get(position).getID());
        holder.name.setText("Namn: " + bergLista.get(position).getName());
        holder.type.setText("Typ: " + bergLista.get(position).getType());
        holder.company.setText("Company: " + bergLista.get(position).getCompany());
        holder.location.setText("Location: " + bergLista.get(position).getLocation());
        holder.category.setText("Category: " + bergLista.get(position).getCategory());
        holder.size.setText("Meter: " + bergLista.get(position).getSize());
        holder.cost.setText("Feet?: " + bergLista.get(position).getCost());
        holder.wiki.setText("wiki: " + bergLista.get(position).getAuxData().getWiki());
        holder.img.setText("img: " + bergLista.get(position).getAuxData().getImg());
    }

    @Override
    public int getItemCount() {

        return bergLista.size();
    }

    public class MountainAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView MountainTextView;
        TextView ID;
        TextView name;
        TextView type;
        TextView company;
        TextView location;
        TextView category;
        TextView size;
        TextView cost;

        TextView wiki;
        TextView img;

        public MountainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            MountainTextView = itemView.findViewById(R.id.bergListTextItem);
            ID = itemView.findViewById(R.id.ID);
            name = itemView.findViewById(R.id.name);
            type = itemView.findViewById(R.id.type);
            company = itemView.findViewById(R.id.company);
            location = itemView.findViewById(R.id.location);
            category = itemView.findViewById(R.id.category);
            size = itemView.findViewById(R.id.size);
            cost = itemView.findViewById(R.id.cost);
            wiki = itemView.findViewById(R.id.wiki);
            img = itemView.findViewById(R.id.img);
           // img.setWebViewClient(new WebViewClient());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("RecyclerView", "onClick：" + getBindingAdapterPosition());
                    clickToSecond();

                }
            });

        }
        void clickToSecond(){
            Log.d("RecyclerView", "onClick：START SECOND ACTIVITY");
            Intent intent = new Intent(mainActivity, SecondActivity.class);
            intent.putExtra("Test", "" + name.getText());
            mainActivity.startActivity(intent);
        }
    }
}
