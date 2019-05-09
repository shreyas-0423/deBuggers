package com.example.naman.firebasedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {


    public static String name;
    private static EditText nameEditText;
    private static Button submitButton;
    int i=0;
    @Override
    public void onBackPressed(){
           i++;
           if(i==2) {

               System.exit(0);
           }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        CallReceiver.getPhoneState(this);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        submitButton = (Button) findViewById(R.id.submitButton);

        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
                name = nameEditText.getText().toString();
                Intent i = new Intent(UserActivity.this, WorkspaceActivity.class);
                startActivity(i);
            }
        });



    }

}





