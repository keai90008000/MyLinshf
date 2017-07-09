package com.example.uu.mylinshf.activite;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.uu.mylinshf.R;
import com.example.uu.mylinshf.fragment.Fragment_home;
import com.example.uu.mylinshf.fragment.Fragment_remen;
import com.example.uu.mylinshf.fragment.Fragment_zhuti;
import com.example.uu.mylinshf.fragment.Fragment_zuanlan;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;

    private String[] titles = new String[]{"最新日报","专栏","热门","主题日报"};
    private TabLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        table = (TabLayout) findViewById(R.id.table);
        table.setupWithViewPager(viewpager);


        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case  0:
                       fragment = new Fragment_home();
                        break;
                    case 1:
                        fragment = new Fragment_zuanlan();
                        break;
                    case 2:
                        fragment = new Fragment_remen();
                        break;
                    case 3:
                        fragment = new Fragment_zhuti();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
    }
}
