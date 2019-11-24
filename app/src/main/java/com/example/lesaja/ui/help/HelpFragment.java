package com.example.lesaja.ui.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.lesaja.R;

public class HelpFragment extends Fragment {

  private HelpViewModel helpViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    helpViewModel =
            ViewModelProviders.of(this).get(HelpViewModel.class);
    View root = inflater.inflate(R.layout.fragment_help, container, false);
    final TextView textView = root.findViewById(R.id.text_help);
    helpViewModel.getText().observe(this, new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}