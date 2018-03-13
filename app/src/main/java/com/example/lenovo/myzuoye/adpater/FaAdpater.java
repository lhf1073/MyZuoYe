package com.example.lenovo.myzuoye.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2018/3/11.
 */

public class FaAdpater extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragmentlist;
    private ArrayList<String> stringlist;

    public FaAdpater(FragmentManager fm, ArrayList<Fragment> fragmentlist, ArrayList<String> stringlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
        this.stringlist = stringlist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringlist.get(position);
    }
}
