package com.example.trackdem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class addMissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mission);
        Button regBtn=(Button) findViewById(R.id.regBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText fromText=(EditText) findViewById(R.id.fromText);
                final EditText toText=(EditText) findViewById(R.id.toText);
                final EditText descText=(EditText) findViewById(R.id.descText);
                final int[] counter = new int[1];
                final DatabaseReference missionsReference = FirebaseDatabase.getInstance().getReference("Missions");
                missionsReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int missionCount=(int) dataSnapshot.getChildrenCount();


                        counter[0] =missionCount+1;



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                final String From = fromText.getText().toString().trim();
                final String To = toText.getText().toString().trim();
                final String Description = descText.getText().toString().trim();

                MissionHelperClass helperClass = new MissionHelperClass(From,To,Description,"NA","NA","NA","NA","NA","NA","NA","3","NA","NA","NA","NA");
                String mission= "Mission"+counter[0];
                missionsReference.child(mission).setValue(helperClass);
                Intent startIntent =new Intent(getApplicationContext(),SupervisorOptions.class);
                Toast.makeText(addMissionActivity.this,"Mission Susscessfuly added",Toast.LENGTH_SHORT).show();
                startActivity(startIntent);

            }
        });
    }
}