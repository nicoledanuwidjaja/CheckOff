package com.nicoleandroid.checkoff;

import android.support.v4.app.Fragment;

/**
 * CheckOff
 * <p/>
 * Created by Nicole on 3/29/16
 * Copyright Narwhal Android 2016
 */
public class CheckListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CheckListFragment();
    }
}
