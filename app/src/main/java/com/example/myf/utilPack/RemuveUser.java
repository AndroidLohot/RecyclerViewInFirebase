package com.example.myf.utilPack;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class RemuveUser {

    public static Task rUser(String id)
    {
        Task task= FirebaseDatabase.getInstance().getReference("User").child(id).setValue(null);

        return task;
    }
}
