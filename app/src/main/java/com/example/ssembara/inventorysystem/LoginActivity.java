package com.example.ssembara.inventorysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = Username.getText().toString();
                String Pass = Password.getText().toString();

                if(User.equalsIgnoreCase("admin") && Pass.equalsIgnoreCase("123")){
                    Toast.makeText(LoginActivity.this,"Login Berhasl Cuk!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"Login Gagal Cuk!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
