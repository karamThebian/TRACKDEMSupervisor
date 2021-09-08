package com.example.trackdem;

import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectedMission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_mission);
        Intent in=getIntent();
        int MissionIndex=in.getIntExtra("position",-1);
        final ArrayList<Missions> availableMissionsArray=new ArrayList();

        Resources res =getResources();
        String[] Missions;
        String[] Location;
        String[] Description;
        Missions = res.getStringArray(R.array.Missions);
        Location = res.getStringArray(R.array.Location);
        Description = res.getStringArray(R.array.Description);
        TextView missionField=(TextView)findViewById(R.id.missionField);
        TextView descriptionField=(TextView)findViewById(R.id.descriptionField);
        TextView locationField=(TextView)findViewById(R.id.locationField);
        missionField.setText(Missions[MissionIndex]);
        descriptionField.setText("Description: "+Description[MissionIndex]);
        locationField.setText("Location: "+Location[MissionIndex]);


    }
}
