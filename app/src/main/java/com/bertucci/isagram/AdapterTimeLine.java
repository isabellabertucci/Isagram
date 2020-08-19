package com.bertucci.isagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTimeLine extends RecyclerView.Adapter<AdapterTimeLine.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;


    public AdapterTimeLine(Context ct, String s1[], String s2[], int img []) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public AdapterTimeLine.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_timeline, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull AdapterTimeLine.MyViewHolder holder, int position) {
        holder.userName.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.imagePost.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName, description;
        ImageView imagePost;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.txtUserName);
            description = itemView.findViewById(R.id.txtDescription);
            imagePost = itemView.findViewById(R.id.imagePost);
        }
    }
}
