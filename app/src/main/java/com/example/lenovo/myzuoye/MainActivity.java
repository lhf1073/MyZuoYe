package com.example.lenovo.myzuoye;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.myzuoye.adpater.MainAdpater;
import com.example.lenovo.myzuoye.frament.CzFragment;
import com.example.lenovo.myzuoye.frament.FxFragment;
import com.example.lenovo.myzuoye.frament.MeFragment;
import com.example.lenovo.myzuoye.frament.ZyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioButton zy;
    private RadioButton fx;
    private RadioButton cz;
    private RadioButton me;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdpater();
    }

    private class myCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.zy:
                    //ViewPager显示第一个Fragment且关闭页面切换动画效果
                    vp.setCurrentItem(0,false);
                    break;
                case R.id.fx:
                    vp.setCurrentItem(1,false);
                    break;
                case R.id.cz:
                    vp.setCurrentItem(2,false);
                    break;
                case R.id.me:
                    vp.setCurrentItem(3,false);
                    break;
            }
        }
    }

    private class myOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    radioGroup.check(R.id.zy);
                    break;
                case 1:
                    radioGroup.check(R.id.fx);
                    break;
                case 2:
                    radioGroup.check(R.id.cz);
                    break;
                case 3:
                    radioGroup.check(R.id.me);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    }



    private void initAdpater() {
        MainAdpater mainAdpater = new MainAdpater(getSupportFragmentManager(),fragmentList);
        vp.setAdapter(mainAdpater);
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        ZyFragment zyFragment = new ZyFragment();
        FxFragment fxFragment = new FxFragment();
        CzFragment czFragment = new CzFragment();
        MeFragment meFragment = new MeFragment();
        fragmentList.add(zyFragment);
        fragmentList.add(fxFragment);
        fragmentList.add(czFragment);
        fragmentList.add(meFragment);
        vp.setCurrentItem(0);
        radioGroup.setOnCheckedChangeListener(new myCheckChangeListener());
        vp.setOnPageChangeListener(new myOnPageChangeListener());
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        zy = (RadioButton) findViewById(R.id.zy);
        fx = (RadioButton) findViewById(R.id.fx);
        cz = (RadioButton) findViewById(R.id.cz);
        me = (RadioButton) findViewById(R.id.me);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }
}
