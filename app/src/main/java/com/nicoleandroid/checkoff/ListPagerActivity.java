package com.nicoleandroid.checkoff;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * CheckOff
 * <p>
 * Created by Nicole on 7/16/16
 * Copyright Narwhal Android 2016
 */
public class ListPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ArrayList<List> mTasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mTasks = CheckOffLab.get(this).getTasks();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            // fetches instance for given position
            public Fragment getItem(int position) {
                List list = mTasks.get(position);
                return ListFragment.newInstance(list.getId());
            }

            @Override
            // returns how many items in the array
            public int getCount() {
                return mTasks.size();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) { }

            public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) { }

            public void onPageSelected(int pos) {
                List list = mTasks.get(pos);
                if(list.getTitle() != null) {
                    setTitle(list.getTitle());
                }
            }
        });

        //find index of crime by looping through each task's id
        UUID ListId = (UUID)getIntent().getSerializableExtra(ListFragment.EXTRA_LIST_ID);
        for(int i = 0; i < mTasks.size(); i++) {
            if(mTasks.get(i).getId().equals(ListId)) {
                // if match, set current item to task index
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}