package com.nicoleandroid.checkoff;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * CheckOff
 *
 * Created by Nicole on 3/29/16
 * Copyright Narwhal Android 2016
 *
 */
public class CheckOffLab {
    private ArrayList<List> mTasks;

    private static CheckOffLab sCheckOffLab;
    private Context mAppContext;

    private CheckOffLab(Context appContext) {
        mAppContext = appContext;
        mTasks = new ArrayList<List>();
        for(int i = 0; i < 100; i++) {
            List t = new List();
            t.setTitle("Task #" + i);
            t.setCompleted(i % 2 == 0);
            mTasks.add(t);
        }
    }

    public static CheckOffLab get(Context l) {
        if(sCheckOffLab == null) {
            sCheckOffLab = new CheckOffLab(l.getApplicationContext());
        }
        return sCheckOffLab;
    }

    public ArrayList<List> getTasks() {
        return mTasks;
    }

    public List getList(UUID id) {
        // for-each loop
        for(List t : mTasks) {
            if(t.getId().equals(id)) {
                // compare the contents of the ids
                return t;
            }
        }
        return null;
    }
}