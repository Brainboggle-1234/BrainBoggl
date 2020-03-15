package com.example.brainboggle3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    FirebaseFirestore db;

    private EditText name;
    private EditText rollno;
    private EditText email;
    private EditText password;
    private Button sign_up_button;
    private Button sign_in_button;
    private Spinner s1, s2, s3;
    boolean x1, x2, x3, x4;
    String a, b, c, d;
    String m = "";
    String p = "";
    String u = "";
    String r = "";
    String batch[] = {"2016-2020", "2017-2021", "2018-2022", "2019-2023"};
    String semester[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
    String section[] = {"A", "B", "C", "D", "E", "F"};
    String one = "";
    String two = "";
    String three = "";
    private static final String TAG = "MyActivity";
    private ProgressDialog mProgress;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        mProgress = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        name = (EditText) findViewById((R.id.name));
        rollno = findViewById((R.id.rollno));
        email = findViewById((R.id.email));
        password = findViewById((R.id.password));
        sign_up_button = findViewById(R.id.sign_up_button);
        sign_in_button = findViewById(R.id.sign_in_button);
        s1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> ad1 = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_activated_1, batch);
        s1.setAdapter(ad1);
        s1.setOnItemSelectedListener(this);
        s2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_activated_1, semester);
        s2.setAdapter(ad2);
        s2.setOnItemSelectedListener(this);
        s3 = findViewById(R.id.spinner3);
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_activated_1, section);
        s3.setAdapter(ad3);
        s3.setOnItemSelectedListener(this);

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegistration();
                a = email.getText().toString().trim();
                b = password.getText().toString().trim();
                if (x1 = (check1(a)) && ( x2= check2(b))) {
                    Intent myintent = new Intent(MainActivity.this, login.class);
                    startActivity(myintent);
                    mProgress.dismiss();

                }

            }
        });
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
            }
        });
    }

    private void startRegistration() {
        final String n = name.getText().toString().trim();
        final String p = password.getText().toString().trim();
        final String e = email.getText().toString().trim();
        final String r = rollno.getText().toString().trim();
        final String one = s1.getSelectedItem().toString();
        final String two = s2.getSelectedItem().toString();
        final String three = s3.getSelectedItem().toString();

//        c = CHECK1(r);



        if (x1=check15(n,p,e,r,one,two,three)) {
            mProgress.setMessage("registaring....");
            mProgress.show();
            mProgress.setCanceledOnTouchOutside(false);
            mAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    x3 = task.isSuccessful();
                    if ((x4 = check3(x3))) {
                        Toast.makeText(MainActivity.this, "Invalid email or already existed email!", Toast.LENGTH_SHORT).show();
                    } else {
                        HashMap<String, Object> user = new HashMap<>();
                        user.put("rollno", r);
                        user.put("name", n);
                        user.put("email", e);
                        user.put("password", p);
                        user.put("batch", one);
                        user.put("semester", two);
                        user.put("section", three);

                        db.collection("student-registration")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });
                    }
                }
            });
        }

    }

    public boolean check15(String w1, String w2, String w3, String w4, String w5, String w6, String w7) {
        if((w1.length() == 0) && (w2.length() == 0) && (w3.length() == 0) && (w4.length() == 0) && (w5.length() == 0)&& (w6.length() ==0) && (w7.length() == 0)){

            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public boolean check1(String w1) {
        if ( (w1.startsWith("cb.en.")) && w1.endsWith("@cb.students.amrita.edu"))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean check2(String w2) {
        if (w2.length() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean check3(boolean w3) {
        if (w3 == false)
        {
            return true;
        }
        else
        {
            return false;
        }

    }




}




