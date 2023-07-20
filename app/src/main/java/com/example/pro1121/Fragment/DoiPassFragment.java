package com.example.pro1121.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pro1121.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoiPassFragment extends Fragment {
    private EditText edtOldPass,edtNewPass1, edtNewPass2;
    private Button btnUpdatePass;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doipass, container, false);

        progressDialog = new ProgressDialog(getActivity());
        btnUpdatePass = view.findViewById(R.id.btnUpdatePass);
        edtNewPass1 = view.findViewById(R.id.edtNewPass1);
        edtNewPass2 = view.findViewById(R.id.edtNewPass2);

        btnUpdatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickChangePassword();
            }
        });

        return view;
    }

    private void onClickChangePassword(){
        String new1 = edtNewPass1.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String new2 = edtNewPass2.getText().toString().trim();

        if (new1.isEmpty()){
            Toast.makeText(getActivity(), "Vui lòng nhập Password mới !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (new1.length() < 6){
            Toast.makeText(getActivity(), "Mật khẩu mới phải từ 6 kí tự !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (new2.isEmpty()){
            Toast.makeText(getActivity(), "Vui lòng nhập lại Password mới !!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (new1.equals(new2) == true){
            progressDialog.setTitle("Cập nhật mật khẩu...");
            progressDialog.show();

            user.updatePassword(new1)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Cập nhật mật khẩu mới thành công !!!", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            } else {
                                // show dialog reAuthentication\\
                                Toast.makeText(getActivity(), "Cập nhật thất bại !!!\n Vui lòng kiểm tra lại !!!", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });

        }else {
            Toast.makeText(getActivity(), "Cập nhật thất bại !!!\n Vui lòng kiểm tra lại !!!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void reAuthentication(){  // Xac thuc nguoi dung khi da lau ko dang nhap
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        AuthCredential credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234");

        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            onClickChangePassword();
                            Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                        }else {

                        }
                    }
                });

    }

}
