package com.basic;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private SectionsPageAdapter sectionsPageAdabter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        sectionsPageAdabter =new SectionsPageAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }


    public void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB 1");
        adapter.addFragment(new Tab2Fragment(), "TAB 2");
        adapter.addFragment(new Tab3Fragment(), "TAB 3");
        viewPager.setAdapter(adapter);
    }



}
