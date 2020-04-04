package com.volio.fragmentHome;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapterHome extends FragmentStatePagerAdapter {
    Context context;
    public PagerAdapterHome(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new Fragment1(context);
                break;
            case 1:
                frag = new Fragment2();
                break;
            case 2:
                frag = new Fragment3();
                break;
            case 3:
                frag = new Fragment4();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="Tất cả";
                break;
            case 1:
                title="Tin mới";
                break;
            case 2:
                title="Thể thao";
                break;
            case 3:
                title="Giải trí";
                break;
        }
        return title;
    }
}
