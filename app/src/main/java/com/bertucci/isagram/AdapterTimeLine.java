package com.bertucci.isagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
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
    boolean doubleClick = false;
    boolean isLiked = false;

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
    public void onBindViewHolder(@NonNull final AdapterTimeLine.MyViewHolder holder, int position) {
        holder.userName.setText(data1[position]);
        holder.userNameDescription.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.imagePost.setImageResource(images[position]);
        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLiked){
                    isLiked = false;
                    holder.imgLike.setImageDrawable(context.getDrawable(R.drawable.like));
                }else {
                    isLiked = true;
                    holder.imgLike.setImageDrawable(context.getDrawable(R.drawable.liked));
                }
            }
        });

        holder.imagePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("adapter", "doubleClick: "+doubleClick);
                if (isLiked){
                    isLiked = false;
                    holder.imgLike.setImageDrawable(context.getDrawable(R.drawable.like));
                } else{
                    isLiked = true;
                    holder.imgLike.setImageDrawable(context.getDrawable(R.drawable.liked));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName, description, userNameDescription;
        ImageView imagePost, imgLike;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.txtUserName);
            userNameDescription = itemView.findViewById(R.id.txtUserNameDescription);
            description = itemView.findViewById(R.id.txtDescription);
            imagePost = itemView.findViewById(R.id.imagePost);
            imgLike = itemView.findViewById(R.id.imgLike);
        }
    }
}
