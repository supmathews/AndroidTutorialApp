package com.example.turbo.androidtutorial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class WelcomePage extends AppCompatActivity {

    private Button start;
    private SharedPreferences pref;
    private String name;
    private TextView nameUser;
    private FirebaseAuth  firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        nameUser = (TextView)findViewById(R.id.nameHere);
        start = (Button)findViewById(R.id.startButton);

        pref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        name = pref.getString("userName", null).toUpperCase();

        nameUser.setText(name);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toLists = new Intent(WelcomePage.this, ListPage.class);
                startActivity(toLists);
            }
        });
    }
}
