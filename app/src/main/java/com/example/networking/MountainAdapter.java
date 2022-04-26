package com.example.networking;

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
    private List<String> berg;
    private List<Mountain> bergLista;

    public void setBergLista(List<Mountain> bergLista) {
        this.bergLista = bergLista;
    }
// public MountainAdapter(List<String> berg){

      //  this.berg = berg;
    //}
    public MountainAdapter(List<Mountain> berg){

        this.bergLista = berg;
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
        holder.ID.setText(bergLista.get(position).getID());
        holder.name.setText(bergLista.get(position).getName());
        holder.type.setText(bergLista.get(position).getType());
        holder.company.setText(bergLista.get(position).getCompany());
        holder.location.setText(bergLista.get(position).getLocation());
        holder.category.setText(bergLista.get(position).getCategory());
        holder.size.setText("" + bergLista.get(position).getSize());
        holder.cost.setText("" + bergLista.get(position).getCost());
        holder.wiki.setText(bergLista.get(position).getAuxData().getWiki());
        holder.img.setText(bergLista.get(position).getAuxData().getImg());
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

        }
    }
}
