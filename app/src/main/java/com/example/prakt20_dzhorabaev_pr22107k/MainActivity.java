package com.example.prakt20_dzhorabaev_pr22107k;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText edName, edSecondName,edEmail;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        edName = findViewById((R.id.edName));
        edSecondName = findViewById((R.id.edSecondName));
        edEmail = findViewById((R.id.edEmail));
        mDataBase= FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    public void onClickSave(View view)
    {
        String id = mDataBase.getKey();
        String name =  edName.getText().toString();
        String sec_name =  edSecondName.getText().toString();
        String email =  edEmail.getText().toString();
        User newUser = new User(id,name,sec_name,email);
        mDataBase.push().setValue(newUser);

    }
    public void onClickRead(View view)
    {

    }
}