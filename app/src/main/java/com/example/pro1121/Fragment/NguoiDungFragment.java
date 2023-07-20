package com.example.pro1121.Fragment;


import static com.example.pro1121.view.MainActivity.MY_REQUEST_CODE;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.bumptech.glide.Glide;
import com.example.pro1121.R;
import com.example.pro1121.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import de.hdodenhof.circleimageview.CircleImageView;

public class NguoiDungFragment extends Fragment {

    private ImageView imgAvatarinProFile;
    private EditText edtNameinProFile, edtEmailinProFile;
    private Button btnProFileUpdate, btnProFileEditEmail;
    private Uri mUri;
    private MainActivity mMainActivity;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nguoidung, container, false);

        imgAvatarinProFile = view.findViewById(R.id.imgAvatarinProFile);
        edtNameinProFile = view.findViewById(R.id.edtNameinProFile);
        edtEmailinProFile = view.findViewById(R.id.edtEmailinProFile);
        btnProFileUpdate = view.findViewById(R.id.btnProFileUpdate);
        btnProFileEditEmail = view.findViewById(R.id.btnProFileEditEmail);

        mMainActivity = (MainActivity) getActivity();
        progressDialog = new ProgressDialog(getActivity());

        setProFile();
        imgAvatarinProFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });

        btnProFileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickUpdateProFile();
            }
        });

        btnProFileEditEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditEmail();
            }
        });

        return view;
    }

    // set Thông tin
    private void setProFile() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return;
        }
        edtNameinProFile.setText(user.getDisplayName());
        edtEmailinProFile.setText(user.getEmail());
        Glide.with(getActivity()).load(user.getPhotoUrl()).error(R.drawable.ic_avatar);
        Log.d("<><><><><>TAG", "setProFile: ");
    }

    private void openAlbum() {
        if (mMainActivity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) { // < hon android 6
            mMainActivity.openGallery();
            return;
        }
        if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            mMainActivity.openGallery();
        } else {
            String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
            getActivity().requestPermissions(permission, MY_REQUEST_CODE);

        }
    }

    public void setBitmapImageView(Bitmap bitmapImageView) {
        imgAvatarinProFile.setImageBitmap(bitmapImageView);
    }

    public void setUri(Uri mUri) {
        this.mUri = mUri;
    }

    private void onClickUpdateProFile() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            return;
        }
        progressDialog.setTitle("Update Profile...");
        progressDialog.show();
        String strFullName = edtNameinProFile.getText().toString().trim();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(strFullName)
                .setPhotoUri(mUri)
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Update Profile thành công !!!", Toast.LENGTH_SHORT).show();
                            mMainActivity.showProfile();
                        }
                    }
                });

    }


    private void onClickEditEmail(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        String newEmail = edtEmailinProFile.getText().toString().trim();
        progressDialog.setTitle("Chỉnh sửa Email...");
        progressDialog.show();
        user.updateEmail(newEmail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(mMainActivity, "Chỉnh sửa Email thành công !!!", Toast.LENGTH_SHORT).show();
                            mMainActivity.showProfile();
                        }else{
                            Toast.makeText(mMainActivity, "Chỉnh sửa Email thất bại !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
