package com.example.myf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.myf.Adapter.MyAdapter;
import com.example.myf.Person.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference myRef;
    private EditText edName,edLastName,edSalory,edPhone,edAge;

    private void inView()
    {
        edLastName=findViewById(R.id.edLastName);
        edName=findViewById(R.id.edName);
        edSalory=findViewById(R.id.edSalory);
        edAge=findViewById(R.id.edAge);
        edPhone=findViewById(R.id.edPhone);
        myRef = FirebaseDatabase.getInstance().getReference("User");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inView();

    }

    public void saveF(View view) {

        String fName=edName.getText().toString();
        if (TextUtils.isEmpty(fName)) { edName.setError("Enter the first name"); return; }

        String lName=edLastName.getText().toString();
        if (TextUtils.isEmpty(lName)) { edName.setError("Enter the last name"); return; }

        String salory=edSalory.getText().toString();
        if (TextUtils.isEmpty(salory)) { edSalory.setError("Enter the salory name"); return; }

        String age=edAge.getText().toString();
        if (TextUtils.isEmpty(salory)) { edAge.setError("Enter the age name"); return; }

        String phone=edPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) { edPhone.setError("Enter the phone name"); return; }

        float salory2 = Float.parseFloat(salory);
        int age2=Integer.parseInt(age);

        String key=myRef.push().getKey();

        User user=new User(fName,lName,age2,salory2,phone);

        myRef.child(key).setValue(user);

        edName.setText("");
        edLastName.setText("");
        edSalory.setText("");
        edPhone.setText("");
        edAge.setText("");

    }

    public void showListF(View view) {

        Intent intent=new Intent(MainActivity.this,ListActivity.class);

        startActivity(intent);
    }
}
