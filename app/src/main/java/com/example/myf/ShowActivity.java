package com.example.myf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myf.Adapter.MyAdapter;
import com.example.myf.Person.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowActivity extends AppCompatActivity {

    private TextView tvShowName,tvShowLastName,tvShowSalory,tvShowAge,tvShowPhone;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvShowName=findViewById(R.id.tvShowName);
        tvShowAge=findViewById(R.id.tvShowAge);
        tvShowLastName=findViewById(R.id.tvShowLastName);
        tvShowSalory=findViewById(R.id.tvShowSalory);
        tvShowPhone=findViewById(R.id.tvShowPhone);

        String User_Id=getIntent().getStringExtra(MyAdapter.UserId);

        myRef= FirebaseDatabase.getInstance().getReference("User").child(User_Id);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User user=dataSnapshot.getValue(User.class);

                String name=user.getFirst_Name();
                String lName=user.getLast_Name();
                String age=String.valueOf(user.getAge());
                String phone=user.getPhone();
                String salary=String.valueOf(user.getSalory());

                tvShowName.setText("First name "+name);
                tvShowLastName.setText("Last name "+lName);
                tvShowAge.setText("Age "+age);
                tvShowSalory.setText("Salary "+salary);
                tvShowPhone.setText("Phone "+phone);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });









    }
}
