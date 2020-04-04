package com.volio.bao;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.volio.fragmentHome.PagerAdapterHome;

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    Context context;

    public HomeFragment(Context context) {
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        viewPager=rootView.findViewById(R.id.viewPagerHome);
        tabLayout=rootView.findViewById(R.id.tabLayoutHome);
        FragmentManager manager = getFragmentManager();
        PagerAdapterHome adapter = new PagerAdapterHome(manager,context);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        return rootView;
    }
}
