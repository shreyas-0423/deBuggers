package com.example.naman.firebasedatabase;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class CallReceiver extends com.example.naman.firebasedatabase.PhonecallReceiver {

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("phonecall");

    public static void updateFirebase (String s){

        databaseReference.setValue(s);
    }

    public static void getPhoneState(final Context ctx) {

        databaseReference.addValueEventListener(new ValueEventListener() {

            boolean flag = false;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(flag) {
                    String phonecall = dataSnapshot.getValue(String.class);
                    Toast.makeText(ctx, phonecall, Toast.LENGTH_SHORT).show();
                }
                else
                    flag = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



    @Override
    protected void onIncomingCallReceived(Context ctx, String number, Date start)
    {
        //Context context;

        //Toast.makeText(ctx," Incoming Receiver start ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Incoming Receiver start ");
    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start)
    {
        //Toast.makeText(ctx," Incoming Call Picked ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Incoming Call Picked ");
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end)
    {
        //Toast.makeText(ctx,"Incoming Call Ended ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Incoming Call Ended ");
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start)
    {
        //Toast.makeText(ctx," Outgoing Call Started ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Outgoing Call Started ");
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end)
    {
        //Toast.makeText(ctx," Outgoing Call Ended ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Outgoing Call Ended ");
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start)
    {
        //Toast.makeText(ctx," Missed Call ",Toast.LENGTH_SHORT).show();
        updateFirebase(UserActivity.name + " : Missed Call ");
    }

}