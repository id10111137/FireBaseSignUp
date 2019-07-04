package com.example.firebasesignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.IdUsername)
    EditText IdUsername;
    @BindView(R.id.IdPassword)
    EditText IdPassword;
    FirebaseAuth Auth;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Auth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.IdLogin)
    void GoLogin(){
        Auth.signInWithEmailAndPassword(IdUsername.getText().toString(), IdPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Mohon Maaf Login Gagal", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.IdGoRegister)
    void GoRegister(){
        mIntent = new Intent(this,RegisterActivity.class);
        startActivity(mIntent);
    }
}
