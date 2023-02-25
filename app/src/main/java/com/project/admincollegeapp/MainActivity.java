package com.project.admincollegeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.admincollegeapp.Ebook.EbookActivity;
import com.project.admincollegeapp.faculty.UpdateFaculty;
import com.project.admincollegeapp.gallery.GalleryFragment;
import com.project.admincollegeapp.image.UploadImage;
import com.project.admincollegeapp.notice.DeleteNoticeActivity;
import com.project.admincollegeapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, addEbook, faculty, deleteNotice, deleteImage, deleteEbook, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById((R.id.addNotice));
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);
        deleteImage = findViewById(R.id.deleteImage);
        deleteEbook = findViewById(R.id.deleteEbook);
        logout = findViewById(R.id.logout);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        deleteImage.setOnClickListener(this);
        deleteEbook.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    private void openlogin() {
        startActivity(new Intent(MainActivity.this, Login.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addNotice:
                intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;
            case R.id.addEbook:
                intent = new Intent(MainActivity.this, UploadPdfActivity.class);
                startActivity(intent);
                break;
            case R.id.faculty:
                intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;
            case R.id.deleteNotice:
                intent =new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

            case R.id.deleteImage:
//                intent = new Intent(MainActivity.this, GalleryFragment.class);
//                startActivity(intent);

                //activity bata Fragment call garne esari haina ni ta.
                //                intent =new Intent(MainActivity.this, DeleteNoticeActivity.class);
                //                startActivity(intent);

                //first: kun fragment lai activity bata open garne ho tyo fragment ko instance define garne
                GalleryFragment galleryFragment = new GalleryFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction()  ;

                transaction.add(R.id.mainActivity_root_layout, galleryFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                //yo 3 wota lines lai autai ma method chaining pani garna sakinchha hai. like
                //                transaction.add(galleryFragment, "galleryFrag")
                //                        .addToBackStack(null)
                //                        .commit();

                break;
            case R.id.deleteEbook:
                intent = new Intent(MainActivity.this, EbookActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to Logout and Exit the app?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.super.finishAndRemoveTask();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                /*finishAndRemoveTask();*/
                break;


        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }
}