package com.example.trackdem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class TruckMapActivity extends FragmentActivity implements OnMapReadyCallback {
    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_map2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final double[] lat644 = new double[1];
        final double[] lat645 = new double[1];
        final double[] lat646 = new double[1];
        final double[] long644 = new double[1];
        final double[] long645 = new double[1];
        final double[] long646 = new double[1];











        DatabaseReference missionsReference = FirebaseDatabase.getInstance().getReference("Missions");
        missionsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    int missionCount=(int) dataSnapshot.getChildrenCount();

                    for (int i=1;i<=missionCount;i++){

                        if(dataSnapshot.child("Mission" + i).child("status").getValue(String.class).equals("ongoing")) {

                                        if(dataSnapshot.child("Mission" + i).child("truck").getValue(String.class).equals("644")){
                                            lat644[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("lat").getValue(String.class));
                                            long644[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("long").getValue(String.class));

                                        }
                                        if(dataSnapshot.child("Mission" + i).child("truck").getValue(String.class).equals("645")){
                                            lat645[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("lat").getValue(String.class));
                                            long645[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("long").getValue(String.class));

                                        }
                                        if(dataSnapshot.child("Mission" + i).child("truck").getValue(String.class).equals("646")){
                                            lat646[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("lat").getValue(String.class));
                                            long646[0] =Double.parseDouble(dataSnapshot.child("Mission" + i).child("long").getValue(String.class));

                                        }

                                    }




                    }
                    startRepeatingTask();




                }
                else{
                    Toast.makeText(TruckMapActivity.this, "No Available Data", Toast.LENGTH_SHORT).show();

                }
            }
            private final static int INTERVAL = 1000 * 5 *5;
            Handler mHandler = new Handler();

            Runnable mHandlerTask = new Runnable()
            {
                @Override
                public void run() {
                    showMap();
                    mHandler.postDelayed(mHandlerTask, INTERVAL);
                }
            };

            void startRepeatingTask()
            {
                mHandlerTask.run();
            }

            void stopRepeatingTask()
            {
                mHandler.removeCallbacks(mHandlerTask);
            }

private void showMap(){
    LatLng lv644 = new LatLng(lat644[0], long644[0]);
    Marker v644= mMap.addMarker(new MarkerOptions().position(lv644).title("644"));
    v644.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker",150,150)));

       final LatLng[] lv645 = {new LatLng(lat645[0], long645[0])};
        Marker v645= mMap.addMarker(new MarkerOptions().position(lv645[0]).title("645"));
        v645.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker",150,150)));

        final LatLng[] lv646 = {new LatLng(lat646[0], long646[0])};
        Marker v646= mMap.addMarker(new MarkerOptions().position(lv646[0]).title("646"));
        v646.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("marker",150,150)));
    Toast.makeText(TruckMapActivity.this, "Updated location", Toast.LENGTH_SHORT).show();
    mMap.moveCamera(CameraUpdateFactory.newLatLng(lv644));
    mMap.setMinZoomPreference(10);

}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















    }
}