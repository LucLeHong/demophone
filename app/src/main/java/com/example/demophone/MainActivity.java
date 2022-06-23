package com.example.demophone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.demophone.loadPhone.PhoneActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnPhone).setOnClickListener(view ->
                startActivity(new Intent(this, PhoneActivity.class))
        );
        findViewById(R.id.btnPerson).setOnClickListener(view ->
                startActivity(new Intent(this,PersonActivity.class)));
    }
}