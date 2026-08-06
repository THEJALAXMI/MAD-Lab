package com.example.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView usernames, mobile, emails, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usernames = findViewById(R.id.intName);
        mobile = findViewById(R.id.intMobile);
        emails = findViewById(R.id.intEmail);
        password1 = findViewById(R.id.intPassword);

        String username = getIntent().getStringExtra("username");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");

        usernames.setText("Username:"+ username);
        mobile.setText("Phone:"+ phone);
        emails.setText("Email:"+ email);
        password1.setText("Password:"+ password);









    }
}