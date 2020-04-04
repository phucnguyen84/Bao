package com.volio.bao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtPhone,edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=edtPhone.getText().toString();
                String pass=edtPass.getText().toString();
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        edtPhone=findViewById(R.id.edtPhone);
        edtPass=findViewById(R.id.edtPass);
        btnLogin=findViewById(R.id.btnLogin);
    }
}
