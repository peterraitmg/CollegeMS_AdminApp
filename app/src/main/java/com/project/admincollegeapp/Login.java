package com.project.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.collection.LLRBNode;

public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton,exitbtn;
    private TextView tvShow;

    TextView remaining;
    int counter = 3;
    String user,pass;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("isLogin","false").equals("yes")){
            openDash();
        }


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        tvShow = findViewById(R.id.txt_show);
        loginButton = findViewById(R.id.btnLogin);
        remaining = (TextView) findViewById(R.id.tvNumber);
        exitbtn = findViewById(R.id.exit);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    tvShow.setVisibility(View.VISIBLE);
                else
                    tvShow.setVisibility(View.INVISIBLE);

            }
        });

        tvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getInputType() == 144){
                    password.setInputType(129);
                    tvShow.setText("Show");
                }else {
                    password.setInputType(144);
                    tvShow.setText("Hide");
                }
                password.setSelection(password.getText().length());
            }
        });
       /* remaining.setVisibility(View.GONE);*/
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty()){
                    username.setError("Required");
                    username.requestFocus();
                }else if (password.getText().toString().isEmpty()) {
                    password.setError("Required");
                    password.requestFocus();
                }else if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(Login.this, "Login Successful!.", Toast.LENGTH_SHORT).show();
                    openDash();
                } else{

                    Toast.makeText(Login.this, "Incorrect username/password!.", Toast.LENGTH_SHORT).show();

                    remaining.setVisibility(View.VISIBLE);
                    remaining.setTextColor(Color.RED);
                    counter--;
                    remaining.setText(Integer.toString(counter));
                    if(counter ==0){
                        loginButton.setEnabled(false);
                        Toast.makeText(Login.this, "ACCESS DENIED!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void openDash() {

        startActivity(new Intent(Login.this,MainActivity.class));
        finish();
    }

}