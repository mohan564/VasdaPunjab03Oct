package com.example.harpreet.vasdapunjab;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up_Activity extends AppCompatActivity {

    EditText user,pasword,name,cpassword;
    FirebaseAuth Auth;
    ProgressDialog progressDialog;
    FirebaseUser firebaseUser;
    Pattern pattern;
    Button signup;
    String email;
    Matcher matcher;
    Boolean flag1=false,flag2=false,flag3=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_);

        initialize();

    }

    public void signup(View view)
    {

        email = user.getText().toString().trim();
        String password = pasword.getText().toString().trim();

        progressDialog.setMessage("Signing Up");
        progressDialog.show();
        ;

        Auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Sign_Up_Activity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    firebaseUser = Auth.getCurrentUser();
                    progressDialog.dismiss();
                    Toast.makeText(Sign_Up_Activity.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                    verify();

                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(Sign_Up_Activity.this, "Not Done", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void initialize()
    {
        user = findViewById(R.id.email);
        pasword = findViewById(R.id.password);
        name  =findViewById(R.id.EditName);
        cpassword = findViewById(R.id.confirmPassword);
        Auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        signup = findViewById(R.id.signup);


    }

    public void verify()
    {
        firebaseUser.sendEmailVerification().addOnCompleteListener(Sign_Up_Activity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Sign_Up_Activity.this, "Verification Email Sent To "+email, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Sign_Up_Activity.this, "Email Sending Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
