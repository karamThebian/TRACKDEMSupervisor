package com.example.trackdem;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            //final ArrayList<Person> myPeople=new ArrayList();


/*
       Person p1=new Person("karam","Thebian","1999","1","1111");
        myPeople.add(p1);
        Person p2=new Person("khaled","Atallah","1999","2","2222");
        myPeople.add(p2);
        Person p3=new Person("Ayad","Nasr","1999","3","3333");
        myPeople.add(p3);*/


        Button loginBtn = (Button) findViewById(R.id.loginBtn);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameField=(EditText) findViewById(R.id.usernameField);
                EditText passField=(EditText) findViewById(R.id.passField);
                final String userEnteredUsername=usernameField.getText().toString().trim();
                final String userEnteredPass= passField.getText().toString().trim();
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Supervisors");
                Query checkSupervisor=reference.orderByChild("username").equalTo(userEnteredUsername);
                checkSupervisor.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String passwordFromDB=dataSnapshot.child(userEnteredUsername).child("password").getValue().toString();
                            if (passwordFromDB.equals(userEnteredPass)){
                                String nameFromDB=dataSnapshot.child(userEnteredUsername).child("FullName").getValue().toString();
                                Intent startIntent =new Intent(getApplicationContext(),SupervisorOptions.class);
                                Toast.makeText(MainActivity.this,"Welcome Mr."+nameFromDB+"!",Toast.LENGTH_SHORT).show();
                                startActivity(startIntent);
                                finish();


                            }
                            else{
                                Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this,"Invalid Username",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });














            }
        });
    }
}
