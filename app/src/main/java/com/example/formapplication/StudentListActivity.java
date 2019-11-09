package com.example.formapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class StudentListActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
     FirebaseRecyclerOptions<Student> options;
    FirebaseRecyclerAdapter<Student,MyRecyclerViewHolder> adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("EDMT_FIREBASE");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayStudent();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                displayStudent();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    protected void onStop() {
        if (adapter != null)
            adapter.stopListening();
        super.onStop();

    }

    public void displayStudent()
    {
         options = new FirebaseRecyclerOptions.Builder<Student>().setQuery(databaseReference,Student.class).build();

        adapter = new FirebaseRecyclerAdapter<Student, MyRecyclerViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyRecyclerViewHolder myRecyclerViewHolder, int i, @NonNull Student student) {
                myRecyclerViewHolder.tv_name.setText(student.getName());
                Log.d("Itt","Eljutott1");
                myRecyclerViewHolder.tv_location.setText(student.getLocation());
                Log.d("Itt","Eljutott2");
                myRecyclerViewHolder.tv_date.setText(student.getBirthDate());
                Log.d("Itt","Eljutott");
                myRecyclerViewHolder.tv_gender.setText(student.getGender());
                myRecyclerViewHolder.tv_hobby.setText(student.getHobbies());
                myRecyclerViewHolder.tv_department.setText(student.getDepartment());
                myRecyclerViewHolder.tv_year.setText(student.getYearOfStudy());
                myRecyclerViewHolder.tv_expectations.setText(student.getExpectations());

            }

            @NonNull
            @Override
            public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
                View itemView = LayoutInflater.from(getBaseContext()).inflate(R.layout.student_item,viewGroup,false);
                return new MyRecyclerViewHolder(itemView);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

}

