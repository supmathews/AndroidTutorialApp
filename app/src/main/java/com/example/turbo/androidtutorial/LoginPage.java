package com.example.turbo.androidtutorial;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private EditText pass;
    private EditText emailid;
    private Button login;
    private String getEmailID, getPassword, userName, password;
    private TextView sign_upButton;
    private SharedPreferences pref;

    //Firebase object
    private FirebaseAuth firebaseAuth;

    //Progress dialog object
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        sign_upButton = (TextView)findViewById(R.id.signUp);
        login = (Button) findViewById(R.id.loginButton);
        emailid = (EditText)findViewById(R.id.getEmailId);
        pass = (EditText)findViewById(R.id.getPass);

        //Progress dialog initialisation
        progressDialog = new ProgressDialog(this);

        //pref = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        //Firebase initialisation
        firebaseAuth = FirebaseAuth.getInstance();

        //When Sign up button is clicked
        sign_upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignupPage = new Intent(LoginPage.this, SignUp.class);
                startActivity(toSignupPage);
            }
        });


        //When Login button is clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getEmailID = emailid.getText().toString().trim();
                getPassword = pass.getText().toString().trim();

                //userName = pref.getString("userName", null);
                //password = pref.getString("pass", null);


                /*if((getUsername.equals(userName))&&getPassword.equals(password))
                {
                    Intent toHome = new Intent(LoginPage.this, WelcomePage.class);
                    startActivity(toHome);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please re-type the right credentials!", Toast.LENGTH_SHORT).show();
                }*/


                firebaseAuth.signInWithEmailAndPassword(getEmailID, getPassword).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Intent toHome = new Intent(LoginPage.this, WelcomePage.class);
                            progressDialog.setMessage("Logging in. . .");
                            progressDialog.show();
                            startActivity(toHome);
                        }
                        else
                            Toast.makeText(LoginPage.this, "Please re-type the right credentials!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}
