package com.nicoleandroid.checkoff;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 *
 * CheckOff
 *
 * Created by Nicole on 1/26/16
 * Copyright Narwhal Android 2016
 *
 */
public class ListActivity extends SingleFragmentActivity {

    @Override

    protected Fragment createFragment() {

        UUID ListId = (UUID)getIntent().getSerializableExtra(ListFragment.EXTRA_LIST_ID);

        return ListFragment.newInstance(ListId);
    }
}
