package com.project.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.project.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView coDepartment,javaDepartment,dsaDepartment,calDepartment,dbDepartment;
    private LinearLayout coNoData,javaNoData,dsaNoData,calNoData,dbNoData;
    private List<TeacherData> list1,list2,list3,list4,list5;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main Menu");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        coDepartment =findViewById(R.id.coDepartment);
        javaDepartment =findViewById(R.id.javaDepartment);
        dsaDepartment =findViewById(R.id.dsaDepartment);
        calDepartment =findViewById(R.id.calDepartment);
        dbDepartment =findViewById(R.id.dbDepartment);


        coNoData =findViewById(R.id.coNoData);
        javaNoData =findViewById(R.id.javaNoData);
        dsaNoData =findViewById(R.id.dsaNoData);
        calNoData =findViewById(R.id.calNoData);
        dbNoData =findViewById(R.id.dbNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        coDepartment();
        javaDepartment();
        dsaDepartment();
        calDepartment();
        dbDepartment();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
    }

    private void coDepartment() {
        dbRef = reference.child("COA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    coNoData.setVisibility(View.VISIBLE);
                    coDepartment.setVisibility(View.GONE);
                }else{
                    coNoData.setVisibility(View.GONE);
                    coDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data =snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    coDepartment.setHasFixedSize(true);
                    coDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1,UpdateFaculty.this,"COA"); //missing category"COA"
                    coDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void javaDepartment() {
        dbRef = reference.child("Java");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    javaNoData.setVisibility(View.VISIBLE);
                    javaDepartment.setVisibility(View.GONE);
                }else{
                    javaNoData.setVisibility(View.GONE);
                    javaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data =snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    javaDepartment.setHasFixedSize(true);
                    javaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2,UpdateFaculty.this,"Java");
                    javaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dsaDepartment() {
        dbRef = reference.child("DSA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    dsaNoData.setVisibility(View.VISIBLE);
                    dsaDepartment.setVisibility(View.GONE);
                }else{
                    dsaNoData.setVisibility(View.GONE);
                    dsaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data =snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    dsaDepartment.setHasFixedSize(true);
                    dsaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3,UpdateFaculty.this,"DSA");
                    dsaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void calDepartment() {
        dbRef = reference.child("Calculus");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    calNoData.setVisibility(View.VISIBLE);
                    calDepartment.setVisibility(View.GONE);
                }else{
                    calNoData.setVisibility(View.GONE);
                    calDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data =snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    calDepartment.setHasFixedSize(true);
                    calDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4,UpdateFaculty.this,"Calculus");
                    calDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dbDepartment() {
        dbRef = reference.child("DBMS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    dbNoData.setVisibility(View.VISIBLE);
                    dbDepartment.setVisibility(View.GONE);
                }else{
                    dbNoData.setVisibility(View.GONE);
                    dbDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        TeacherData data =snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    dbDepartment.setHasFixedSize(true);
                    dbDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5,UpdateFaculty.this,"DBMS");
                    dbDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}