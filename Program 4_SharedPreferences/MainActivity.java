package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.t1);
        EditText username = findViewById(R.id.edt1);
        EditText phone = findViewById(R.id.edt2);
        EditText email = findViewById(R.id.edt3);
        EditText password = findViewById(R.id.edt4);
        EditText confirm = findViewById(R.id.edt5);
        Button submit = findViewById(R.id.btn);

        sharedPreferences = getSharedPreferences("MyDetails",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usernames = username.getText().toString().trim();
                String mobile = phone.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String password1 = password.getText().toString().trim();
                String confirm1 = confirm.getText().toString().trim();

                if(usernames.isEmpty())
                {
                    username.setError("Username is Empty");
                    username.requestFocus();
                    return;
                }

                if(mobile.isEmpty())
                {
                    phone.setError("Mobile number is empty");
                    phone.requestFocus();
                    return;
                }
                if(emails.isEmpty())
                {
                    email.setError("EMail is empty");
                    email.requestFocus();
                    return;
                }

                if(password1.length()<6)
                {
                    password.setError("Length must be atleast 6 characters");
                    password.requestFocus();
                    return;
                }

                if(!password1.equals(confirm1))
                {
                    confirm.setError("Password doesnot match");
                    confirm.requestFocus();
                    return;
                }
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                editor.putString("keyusername",usernames);
                editor.putString("keyphone",mobile);
                editor.putString("keyemail",emails);
                editor.putString("keypassword",confirm1);
                editor.apply();
            }
        }
        );

    }
}