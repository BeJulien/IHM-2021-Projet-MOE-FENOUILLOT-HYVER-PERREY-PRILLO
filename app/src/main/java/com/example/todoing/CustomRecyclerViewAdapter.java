package com.example.todoing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<TacheViewHolder>{

    private List<Tache> taches;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public CustomRecyclerViewAdapter(Context context, List<Tache> datas ) {
        this.context = context;
        this.taches = datas;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TacheViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // Inflate view from recyclerview_item_layout.xml
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recyclerview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        return new TacheViewHolder(recyclerViewItem);
    }


    @Override
    public void onBindViewHolder(TacheViewHolder holder, int position) {
        // Cet country in countries via position
        Tache tache = this.taches.get(position);

        // Bind data to viewholder
        holder.title.setText(tache.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.taches.size();
    }

    // Find Image ID corresponding to the name of the image (in the directory drawable).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("MainActivity.LOG_TAG", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    // Click on RecyclerView Item.
    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Tache tache  = this.taches.get(itemPosition);
        Toast.makeText(this.context, tache.getTitle(), Toast.LENGTH_LONG).show();
    }
}
