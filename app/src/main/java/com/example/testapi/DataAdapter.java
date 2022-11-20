package com.example.testapi;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    ArrayList<DataModal> dataModalArrayList;

    public DataAdapter(ArrayList<DataModal> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModal dataModal = dataModalArrayList.get(position);
        holder.textID.setText(Integer.toString(dataModal.getPostID()));
        holder.textTitle.setText(dataModal.getPostTitle());
        holder.textBody.setText(dataModal.getPostBody());
    }

    @Override
    public int getItemCount() {
        return dataModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textID, textTitle, textBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textID = itemView.findViewById(R.id.textID);
            textTitle = itemView.findViewById(R.id.textTitle);
            textBody = itemView.findViewById(R.id.textBody);
        }
    }
}
