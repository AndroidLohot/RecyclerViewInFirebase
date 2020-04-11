package com.example.myf.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myf.Person.User;
import com.example.myf.R;
import com.example.myf.ShowActivity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<User> userArrayList;
    private Context context;
    public static final String UserId="User_Id";

    public MyAdapter(ArrayList<User> userArrayList, Context context) {
        this.userArrayList = userArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final User user=userArrayList.get(position);

        holder.tvShowName.setText(user.getFirst_Name());

        holder.tvShowName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uId=user.getuId();

                Intent intent=new Intent(context, ShowActivity.class);

                intent.putExtra(UserId,uId);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvShowName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvShowName=itemView.findViewById(R.id.tvShowName);
        }
    }
}
