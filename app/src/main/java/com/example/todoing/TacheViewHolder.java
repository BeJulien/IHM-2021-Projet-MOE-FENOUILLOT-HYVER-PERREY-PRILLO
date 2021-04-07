package com.example.todoing;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TacheViewHolder extends RecyclerView.ViewHolder{
    TextView title;

    // @itemView: recyclerview_item_layout.xml
    public TacheViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.title);
    }
}
