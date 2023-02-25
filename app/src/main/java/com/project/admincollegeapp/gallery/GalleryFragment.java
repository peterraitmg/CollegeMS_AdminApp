package com.project.admincollegeapp.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.admincollegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView tourRecycler, userAppSliderRecycler,bootcampRecycler,teachersDayRecycler,farewellRecycler,otherEventsRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        tourRecycler = view.findViewById(R.id.tourRecycler);
        userAppSliderRecycler = view.findViewById(R.id.userAppSliderRecycler);
        bootcampRecycler = view.findViewById(R.id.bootcamprecycler);
        teachersDayRecycler = view.findViewById(R.id.teachersDayRecycler);
        farewellRecycler = view.findViewById(R.id.FarewellRecycler);
        otherEventsRecycler = view.findViewById(R.id.otherEventsRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getTourImage();
        getUserAppSlider();
        getBootcamp();
        getTeachersDay();
        getFarewell();
        getOtherEvents();

        return view;
    }

    private void getUserAppSlider() {
        reference.child("User App Slider").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                userAppSliderRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                userAppSliderRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getTourImage() {
        reference.child("Tour").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                tourRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                tourRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getBootcamp() {
        reference.child("Bootcamp").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                bootcampRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                bootcampRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getTeachersDay() {
        reference.child("Teacher's Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                teachersDayRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                teachersDayRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getFarewell() {
        reference.child("Farewell").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                farewellRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                farewellRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getOtherEvents() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                otherEventsRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherEventsRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}




