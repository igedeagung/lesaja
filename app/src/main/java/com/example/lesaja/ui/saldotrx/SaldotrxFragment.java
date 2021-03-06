package com.example.lesaja.ui.saldotrx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.lesaja.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SaldotrxFragment extends Fragment {

    private SaldotrxViewModel saldotrxViewModel;
    private String uid;
    private TextView saldotext;
    private Button topup;
    private int keys;
    private DatabaseReference ref;
    private String fill;
    private String erpe;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        saldotrxViewModel =
                ViewModelProviders.of(this).get(SaldotrxViewModel.class);
        View root = inflater.inflate(R.layout.fragment_saldotrx, container, false);

        saldotext= root.findViewById(R.id.textView12);
        topup=root.findViewById(R.id.button3);
        erpe="Rp ";
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref= FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("saldo");
        ref.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                keys=dataSnapshot.getValue(int.class);
                fill=Integer.toString(keys);
                fill=erpe+fill;
                saldotext.setText(fill);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keys+=100000;
                ref.setValue(keys);
                fill=Integer.toString(keys);
                fill=erpe+fill;
                saldotext.setText(fill);
            }
        });
        return root;
    }
}