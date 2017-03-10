package com.example.android.recyclerviewespresso;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumberedAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private List<String> labels;

    public NumberedAdapter(int count) {
        labels = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            labels.add(String.valueOf(i));
        }
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TextViewHolder holder, final int position) {
        final String label = labels.get(position);
        holder.textView.setText(label);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("App", Thread.currentThread().getStackTrace()[2] + "item clicked at " + position + " position");
                ((TextView) v).setText(String.valueOf(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

}