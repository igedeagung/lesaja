package com.example.lesaja.tab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lesaja.Les;
import com.example.lesaja.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Rencana extends Fragment {

    private String uid;
    private DatabaseReference ref;
    private TextView rencana;
    private View root;
    private int i;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.rencana_fragment, container, false);
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        i=0;
//                rencana = root.findViewById(R.id.textView15);
//                rencana.setText("HHHHHHHH");
        // Get your reference to the node with all the entries
        ref = FirebaseDatabase.getInstance().getReference().child("les");

        // Query for all entries with a certain child with value equal to something
        Query allPostFromAuthor = ref.orderByChild("uid").equalTo(uid);

        // Add listener for Firebase response on said query
        allPostFromAuthor.addValueEventListener( new ValueEventListener(){
            String[] hasil;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot post : dataSnapshot.getChildren() ){
                    // Iterate through all posts with the same author
                    hasil[i]=post.getValue().toString() ;
                    i++;
                }
                rencana = root.findViewById(R.id.textView15);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
        return root;

    }
}
