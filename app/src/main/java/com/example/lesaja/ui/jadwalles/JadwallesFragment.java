package com.example.lesaja.ui.jadwalles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.lesaja.R;
import com.example.lesaja.tab.PagesAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class JadwallesFragment extends Fragment {

	private JadwallesViewModel jadwallesViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		jadwallesViewModel =
				ViewModelProviders.of(this).get(JadwallesViewModel.class);
		View root = inflater.inflate(R.layout.fragment_jadwalles, container, false);

		TabLayout tabLayout = root.findViewById(R.id.tabLayout);
		TabItem rencana = root.findViewById(R.id.rencana);
		TabItem riwayat = root.findViewById(R.id.riwayat);
		ViewPager viewPager = root.findViewById(R.id.view_pager);
		PagesAdapter pageAdapter = new PagesAdapter(getFragmentManager(), tabLayout.getTabCount());
		viewPager.setAdapter(pageAdapter);
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		return root;
	}
}