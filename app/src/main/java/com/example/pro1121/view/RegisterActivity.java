package com.example.pro1121.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pro1121.R;
import com.example.pro1121.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity{
    private EditText edtFullnameRegis, edtAgeRegis, edtEmailRegis, edtPassRegis;
    private Button btnRegis;
    private TextView tvLogin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFullnameRegis = findViewById(R.id.edtFullNameRegis);
        edtAgeRegis = findViewById(R.id.edtAgeRegis);
        edtEmailRegis = findViewById(R.id.edtEmailRegis);
        edtPassRegis = findViewById(R.id.edtPassRegis);
        btnRegis = findViewById(R.id.btnRegis);
        tvLogin = findViewById(R.id.tvLogin);

        firebaseAuth = FirebaseAuth.getInstance();

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }


    private void register(){
        String email = edtEmailRegis.getText().toString().trim();
        String pass = edtPassRegis.getText().toString().trim();
        String fullname = edtFullnameRegis.getText().toString().trim();
        String age = edtAgeRegis.getText().toString().trim();


        //Validate
        if (fullname.isEmpty()){
            edtFullnameRegis.setError("Không để trống Username!");
            edtFullnameRegis.requestFocus();
            return;
        }
        if (age.isEmpty()){
            edtAgeRegis.setError("Không để trống Tuổi!");
            edtAgeRegis.requestFocus();
            return;
        }
        if (email.isEmpty()){
            edtEmailRegis.setError("Không để trống Email!");
            edtEmailRegis.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            edtPassRegis.setError("Không để trống Password!");
            edtPassRegis.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmailRegis.setText("Vui lòng cung cấp Email hợp lệ!");
            edtEmailRegis.requestFocus();
            return;
        }

        if (pass.isEmpty()){
            edtPassRegis.setError("Không để trống Password!");
            edtPassRegis.requestFocus();
            return;
        }
        if (pass.length() < 6){
            edtPassRegis.setError("Mật khẩu tối thiểu 6 kí tự");
            edtPassRegis.requestFocus();
            return;
        }

        //Tao tai khoan roi add len firebase
        firebaseAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    User user = new User(fullname,age,email,pass);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản không thành công!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                }else{
                    Toast.makeText(RegisterActivity.this, " Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}