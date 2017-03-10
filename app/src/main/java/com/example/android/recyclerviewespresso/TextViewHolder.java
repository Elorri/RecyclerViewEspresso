package com.example.android.recyclerviewespresso;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TextViewHolder extends RecyclerView.ViewHolder {
    public View itemView;
    public Button button1;
    public Button button2;
    public TextView textView;

    public TextViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        textView = (TextView) itemView.findViewById(R.id.text);
        button1=(Button)itemView.findViewById(R.id.text1);
        button2=(Button)itemView.findViewById(R.id.text2);
    }
}