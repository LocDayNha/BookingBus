package com.example.pro1121.view;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.pro1121.Fragment.DoiPassFragment;
import com.example.pro1121.Fragment.FeedBackFragment;
import com.example.pro1121.Fragment.NguoiDungFragment;
import com.example.pro1121.Fragment.TimChuyenFragment;
import com.example.pro1121.Fragment.TimTramFragment;
import com.example.pro1121.Fragment.TimVeFragment;
import com.example.pro1121.Fragment.TrangChuFragment;
import com.example.pro1121.R;
import com.example.pro1121.news.TinTucActivity;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final int MY_REQUEST_CODE = 10;
    final private NguoiDungFragment mNguoiDungFragment = new NguoiDungFragment();


    private ImageView img_avatar;
    private TextView txtTen, txtTuoi, txtEmail;
    Button btnLogOut;
    GoogleApiClient mGoogleApiClient;
    DrawerLayout drawerLayout;



    final private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                if (intent == null){
                    return;
                }
                // set anh len profile
                Uri uri = intent.getData();
                mNguoiDungFragment.setUri(uri);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    mNguoiDungFragment.setBitmapImageView(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolBar);
        FrameLayout layout = findViewById(R.id.frLayout);
        NavigationView navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.drawerLayout);
        View headerLayout = navigationView.getHeaderView(0);
        txtTen = headerLayout.findViewById(R.id.txtTen);
        txtEmail = headerLayout.findViewById(R.id.txtEmail);
        img_avatar = headerLayout.findViewById(R.id.img_avatar);

        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeAsUpIndicator(R.drawable.ic_menu);


        showProfile();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frLayout, new TrangChuFragment())
                .commit();
        toolbar.setTitle("Trang Chủ");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.mTrangChu:
                        fragment = new TrangChuFragment();
                        break;
                    case R.id.mDatVe:
                        fragment = new TimChuyenFragment();

                        break;
                    case R.id.mThongTinTramXe:
                        fragment = new TimTramFragment();
                        break;
                    case R.id.mThongTinVeXe:
                        fragment = new TimVeFragment();
                        break;
                    case R.id.mTinTuc:
                        Intent i = new Intent(MainActivity.this, TinTucActivity.class);
                        startActivity(i);
                        break;
                    case R.id.mThoat:
                        //Logout google
                        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                                new ResultCallback<Status>() {
                                    @Override
                                    public void onResult(Status status) {
                                        // ...
                                        Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT).show();
                                        Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                                        //Sau khi out khỏi account sẽ trở về màn hình điện thoại, không trở về main
                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(i);
                                    }
                                });

                        //Logout facebook..
                        LoginManager.getInstance().logOut();

                    case R.id.mThongTinNguoiDung:
                        fragment = mNguoiDungFragment;
                        break;

                    case R.id.mFeedBack:
                        fragment = new FeedBackFragment();
                        break;

                    case R.id.mDoiPass:
                        fragment = new DoiPassFragment();
                        break;

                    default:
                        fragment = new TrangChuFragment();
                        break;
                }
                if (fragment != null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frLayout, fragment)
                            .commit();
                    toolbar.setTitle(item.getTitle()); // lay ten
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });



    }


    //Sự kiện cho nút menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_REQUEST_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openGallery();
            }else{
                Toast.makeText(this, "Vui lòng cho phép cấp quền truy cập !!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openGallery(){ // mo thu vien de chon anh
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(i, "Select Picture"));
    }

    public void showProfile(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            return;
        }
        String name = user.getDisplayName();
        String email = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();

        if (name == null){
            txtTen.setVisibility(View.GONE);
        }else {
            txtTen.setVisibility(View.VISIBLE);
            txtTen.setText(name);
        }
        txtTen.setText(name);
        txtEmail.setText(email);
        Glide.with(this).load(photoUrl).error(R.drawable.ic_avatar).into(img_avatar);
    }

}
