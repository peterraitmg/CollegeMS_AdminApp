package com.project.admincollegeapp.Ebook;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.admincollegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;

    ShimmerFrameLayout shimmer;
    LinearLayout shimmerLayout;

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main Menu");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ebookRecycler = findViewById(R.id.ebookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        shimmer = findViewById(R.id.shimmer_view_container);
        shimmerLayout = findViewById(R.id.shimmer_layout);
        search = findViewById(R.id.searchText);

        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot snapshot :datasnapshot.getChildren() ) {
                    EbookData data = snapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(EbookActivity.this, list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);
                shimmer.stopShimmer();
                shimmerLayout.setVisibility(View.GONE);
                search.setVisibility(View.VISIBLE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });
    }

    private void filter(String text) {
        ArrayList<EbookData> filterlist = new ArrayList<>();
        for (EbookData item: list){
            if (item.getPdfTitle().toLowerCase().contains(text.toLowerCase())){
                filterlist.add(item);
            }
        }
        adapter.Filteredlist(filterlist);

    }

    @Override
    protected void onPause() {
        shimmer.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmer.startShimmer();
        super.onResume();
    }
}