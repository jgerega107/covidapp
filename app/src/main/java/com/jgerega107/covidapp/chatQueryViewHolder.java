package com.jgerega107.covidapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DateFormat;

public class chatQueryViewHolder extends RecyclerView.ViewHolder {
    private View view;
    private String author;
    private long timestamp;
    private String pfpUrl;
    private String message;


    public chatQueryViewHolder(View itemView){
        super(itemView);
        view = itemView;
    }

    public void setView(String author, String message, long timestamp, String pfpUrl){
        this.author = author;
        this.message = message;
        this.timestamp = timestamp;
        this.pfpUrl = pfpUrl;

        ImageView pfp = view.findViewById(R.id.authorpfp);
        TextView messagetext = view.findViewById(R.id.message_textview);
        TextView authordate = view.findViewById(R.id.authordate_textview);

        if(!pfpUrl.equals("")){
            Glide.with(view).load(pfpUrl).into(pfp);
        }
        messagetext.setText(message);
        StringBuilder authorAndDate = new StringBuilder();
        authorAndDate.append(author);
        authorAndDate.append(" at ");
        authorAndDate.append(DateFormat.getInstance().format(timestamp));

        authordate.setText(authorAndDate);

    }

}
