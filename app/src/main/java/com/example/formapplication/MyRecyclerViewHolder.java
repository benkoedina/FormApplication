package com.example.formapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {


    TextView tv_name;
    TextView tv_location;
    TextView tv_date;
    TextView tv_gender;
    TextView tv_hobby;
    TextView tv_department;
    TextView tv_year;
    TextView tv_expectations;


    public MyRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        tv_name=itemView.findViewById(R.id.tv_name);
        tv_location=itemView.findViewById(R.id.tv_location);
        tv_date=itemView.findViewById(R.id.tv_birthDate);
        tv_gender=itemView.findViewById(R.id.tv_gender);
        tv_hobby=itemView.findViewById(R.id.tv_hobby);
        tv_department=itemView.findViewById(R.id.tv_department);
        tv_year=itemView.findViewById(R.id.tv_year);
        tv_expectations=itemView.findViewById(R.id.tv_expectations);

    }


}
