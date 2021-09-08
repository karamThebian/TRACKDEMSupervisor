package com.example.trackdem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);
        Button regBtn=(Button) findViewById(R.id.regBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText regFullName=(EditText) findViewById(R.id.FullName);
                EditText regUserName=(EditText) findViewById(R.id.username);
                EditText regPhoneNumber=(EditText) findViewById(R.id.phoneNumber);
                EditText regPassword=(EditText) findViewById(R.id.password);


                FirebaseDatabase rootNode;
                DatabaseReference reference;
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("Employees");

                final String fullName = regFullName.getText().toString();
                final String password= regPassword.getText().toString();
                final String phoneNumber = regPhoneNumber.getText().toString();
                final String userName = regUserName.getText().toString();
                UserHelperClass helperClass = new UserHelperClass(fullName,password,phoneNumber,userName);
                reference.child(userName).setValue(helperClass);
                Intent startIntent =new Intent(getApplicationContext(),SupervisorOptions.class);
                Toast.makeText(registerEmployeeActivity.this,"Employee Susscessfuly added",Toast.LENGTH_SHORT).show();
                startActivity(startIntent);

            }
        });
    }
}