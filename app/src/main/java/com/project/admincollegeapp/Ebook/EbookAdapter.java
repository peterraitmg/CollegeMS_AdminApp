package com.project.admincollegeapp.Ebook;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.admincollegeapp.R;
import com.project.admincollegeapp.notice.NoticeData;

import java.util.ArrayList;
import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    private Context context;
    private List<EbookData> list;

    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent, false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {
        EbookData currentItem = list.get(position);
//        holder.ebookName.setText(currentItem.getEbookName());


        holder.ebookName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfViewerActivity.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                context.startActivity(intent);
            }
        });

        holder.ebookDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

//        holder.ebookDelete.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
//                builder.setTitle("Are you sure?");
//                builder.setMessage("Deleted data can't be Undo.");
//
//                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Notice");
//                        reference.child(currentItem.getKey()).removeValue()
//                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        Toast.makeText(context, "Deleted.", Toast.LENGTH_SHORT).show();
//                                    }
//                                }).addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(context, "Something is wrong.", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//                        notifyItemRemoved(position);
//
////                        FirebaseDatabase.getInstance().getReference().child("pdf")
////                                .child(getRef(position).getKey()).removeValue();
//
////                        list.remove(position);
////                        notifyDataSetChanged();
////                        Toast.makeText(context, "PDF deleted.", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(holder.itemView.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                builder.show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void Filteredlist(ArrayList<EbookData> filterlist) {
        list = filterlist;
        notifyDataSetChanged();
    }

    public class EbookViewHolder extends RecyclerView.ViewHolder {

        private TextView ebookName;
        private ImageView ebookDownload, ebookDelete;


        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);

            ebookName = itemView.findViewById(R.id.ebookName);
            ebookDownload = itemView.findViewById(R.id.ebookDownload);
//            ebookDelete = itemView.findViewById(R.id.ebookDelete);

        }
    }
}

//
