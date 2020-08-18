package com.jgerega107.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class ChatActivity extends AppCompatActivity {

    private FirebaseUser user;
    private CollectionReference chatMessageReference;
    private RecyclerView chatRecycler;
    private FirestoreRecyclerAdapter<Message, chatQueryViewHolder> adapter;
    private EditText textField;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        user = FirebaseAuth.getInstance().getCurrentUser();
        chatMessageReference = FirebaseFirestore.getInstance().collection("publicchat");

        chatRecycler = findViewById(R.id.chatrecycler);
        manager = new LinearLayoutManager(getApplicationContext());
        manager.setStackFromEnd(true);
        chatRecycler.setLayoutManager(manager);
        textField = findViewById(R.id.sendmessagedrawer_edittext);

        AlertDialog welcomeToChatAlert = new AlertDialog.Builder(
                ChatActivity.this).create();

        welcomeToChatAlert.setTitle("Welcome to quarantine chat!");
        welcomeToChatAlert.setMessage("You are now joining quarantine chat! Here you can ask others for advice regarding symptoms, quarantine, or just chat about day to day life!");
        welcomeToChatAlert.show();

        Query query = chatMessageReference.orderBy("timestamp", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<Message> options = new FirestoreRecyclerOptions.Builder<Message>()
                .setQuery(query, Message.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<Message, chatQueryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final chatQueryViewHolder viewHolder, int i, @NonNull final Message message) {
                viewHolder.setView(message.getAuthorName(), message.getMessage(), message.getTimestamp(), message.getPfpUrl());
            }

            @NonNull
            @Override
            public chatQueryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_query_layout, parent, false);
                return new chatQueryViewHolder(view);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public int getItemViewType(int position) {
                return position;
            }
        };

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onChanged();
                manager.smoothScrollToPosition(chatRecycler, null, adapter.getItemCount());
            }
        });
        chatRecycler.setAdapter(adapter);
    }

    public void sendMessage(View v) {
        if (!textField.getText().toString().equals("")) {
            Message message = new Message(textField.getText().toString(), user.getDisplayName());
            if (user.getPhotoUrl() != null) {
                message.setPfpUrl(user.getPhotoUrl().toString());
            }
            chatMessageReference.document().set(message);
            adapter.notifyDataSetChanged();
            textField.setText("");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.startListening();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}

