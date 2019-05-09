package com.example.naman.firebasedatabase;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class WorkspaceActivity extends AppCompatActivity {

    private static EditText workspace;
    private static DatabaseReference databaseReference;


    public static void updateFirebase (String s){

        WorkSpace work = new WorkSpace();
        work.work = s;
        databaseReference.child("-LboEi2euNhbVw20HOXJ").setValue(work);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workspace);


        databaseReference = FirebaseDatabase.getInstance().getReference("workspace");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                WorkSpace work = dataSnapshot.child("-LboEi2euNhbVw20HOXJ").getValue(WorkSpace.class);
                workspace.setText(work.work);
                workspace.setSelection(work.work.length());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        workspace = (EditText) findViewById(R.id.workspace);
        workspace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateFirebase(workspace.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



    }
}
