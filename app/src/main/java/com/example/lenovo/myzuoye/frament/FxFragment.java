package com.example.lenovo.myzuoye.frament;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myzuoye.R;
import com.example.lenovo.myzuoye.adpater.FaAdpater;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FxFragment extends Fragment {


    private TabLayout tab;
    private ArrayList<Fragment> fragmentlist;
    private ArrayList<String> stringlist;
    private ViewPager vp;

    public FxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fx, container, false);
        initView(inflate);
        initData();
        initAdpater();
        return inflate;

    }

    private void initAdpater() {
        FaAdpater faAdpater = new FaAdpater(getFragmentManager(), fragmentlist, stringlist);
        vp.setAdapter(faAdpater);
        tab.setupWithViewPager(vp);
    }

    private void initData() {
        stringlist = new ArrayList<>();
        stringlist.add("专题活动");
        stringlist.add("人气宝贝");

        fragmentlist = new ArrayList<>();
        fragmentlist.add(new ZhuanTiFragment());
        fragmentlist.add(new RenQiFragment());


    }

    private void initView(View inflate) {
        tab = (TabLayout) inflate.findViewById(R.id.tab);
        vp = (ViewPager) inflate.findViewById(R.id.vp);
    }
}
