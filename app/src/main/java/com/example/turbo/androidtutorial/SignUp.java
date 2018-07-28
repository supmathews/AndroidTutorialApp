package com.example.turbo.androidtutorial;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private Button signup;
    private EditText fName, email, pno, pass, confirmPass, user;
    private SharedPreferences pref;
    private String fullName, eid, phnum, password, cpassword, userName;

    //Progress dialog
    private ProgressDialog progressDialog;

    //Firebase Authentication Object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //FindView items
        fName = (EditText)findViewById(R.id.fullName);
        email = (EditText)findViewById(R.id.emailID);
        pno = (EditText)findViewById(R.id.phnum);
        pass = (EditText)findViewById(R.id.pass);
        confirmPass = (EditText)findViewById(R.id.confirmPass);
        user = (EditText)findViewById(R.id.user);
        signup = (Button)findViewById(R.id.sign);

        //Progress dialog
        progressDialog = new ProgressDialog(this);

        //Firebase Auth Initialisation
        firebaseAuth = FirebaseAuth.getInstance();


        pref = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEmpty(fName))
                    Toast.makeText(getApplicationContext(), "Please Enter Full Name!", Toast.LENGTH_SHORT).show();

                else if(isEmpty(email))
                    Toast.makeText(getApplicationContext(), "Please Enter Email ID!", Toast.LENGTH_SHORT).show();

                else if(isEmpty(pno))
                    Toast.makeText(getApplicationContext(), "Please Enter Phone number!", Toast.LENGTH_SHORT).show();

                else if(isEmpty(pass))
                    Toast.makeText(getApplicationContext(), "Please Enter A Password!", Toast.LENGTH_SHORT).show();

                else if(isEmpty(confirmPass))
                    Toast.makeText(getApplicationContext(), "Please Confirm the Password!", Toast.LENGTH_SHORT).show();

                else
                {
                    Intent toLogin = new Intent(SignUp.this, LoginPage.class);

                    //Shared Preference code

                     SharedPreferences.Editor editor = pref.edit();
                     editor.putString("userName", user.getText().toString());
                     editor.putString("pass", pass.getText().toString());
                     editor.commit();


                    //Username and password string objects for server storage
                    eid = email.getText().toString().trim();
                    password = pass.getText().toString().trim();

                    //progress dialog message during registration
                    progressDialog.setMessage("Registering User. . . ");
                    progressDialog.show();

                    //Register the user with the Firebase server

                     firebaseAuth.createUserWithEmailAndPassword(eid, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {

                             if(task.isSuccessful())
                                 Toast.makeText(SignUp.this, "Registered Successfully!", Toast.LENGTH_LONG).show();
                             else
                                 Toast.makeText(SignUp.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                         }
                     });

                    startActivity(toLogin);
                }
            }
        });

    }

    private boolean isEmpty(EditText etText)
    {
        return etText.getText().toString().trim().length() == 0;
    }
}
