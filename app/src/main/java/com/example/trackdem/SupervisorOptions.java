package com.example.trackdem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupervisorOptions extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SupervisorOptions.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_options);
        Button viewMissionsBtn=(Button) findViewById(R.id.viewMissionsBtn);
        Button registerEmployeesBtn=(Button) findViewById(R.id.registerEmployeeBtn);
        Button addMissionBtn=(Button) findViewById(R.id.addMissionBtn);
        Button truckMapbtn=(Button) findViewById(R.id.truckMapBtn);
        viewMissionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showAvailableMission =new Intent(getApplicationContext(),AvailableMissions.class);
                startActivity(showAvailableMission);
            }
        });
        registerEmployeesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerEmployee =new Intent(getApplicationContext(),registerEmployeeActivity.class);
                startActivity(registerEmployee);
            }
        });
        addMissionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMissions =new Intent(getApplicationContext(),addMissionActivity.class);
                startActivity(addMissions);
            }
        });
        truckMapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent truckMap =new Intent(getApplicationContext(),TruckMapActivity.class);
                startActivity(truckMap);
            }
        });


    }
}