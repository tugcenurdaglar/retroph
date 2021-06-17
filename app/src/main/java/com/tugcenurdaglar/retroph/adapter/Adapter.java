package com.tugcenurdaglar.retroph.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tugcenurdaglar.retroph.R;
import com.tugcenurdaglar.retroph.models.Info;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.InfoLayoutNesneler> {
    private Context mContext;
    private List<Info> infoList;

    public Adapter(Context mContext, List<Info> infoList) {
        this.mContext = mContext;
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public InfoLayoutNesneler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_layout,parent,false);

        return new InfoLayoutNesneler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoLayoutNesneler holder, int position) {

        Info info = infoList.get(position);

        holder.postId.setText(String.valueOf(info.postId));
        holder.id.setText(String.valueOf(info.id));
        holder.name.setText(info.name);
        holder.email.setText(info.email);
        holder.body.setText(info.body);
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public  class InfoLayoutNesneler extends RecyclerView.ViewHolder{

        public TextView postId;
        public TextView id;
        public TextView name;
        public TextView email;
        public TextView body;

        public InfoLayoutNesneler(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.postId);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
