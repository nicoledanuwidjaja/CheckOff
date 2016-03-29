package checkoff.nicoleandroid.com.checkoff;

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
            List c = new List();
            c.setTitle("Crime #" + i);
            c.setCompleted(i % 2 == 0);
            mTasks.add(c);
        }
    }

    public static CheckOffLab get(Context c) {
        if(sCheckOffLab == null) {
            sCheckOffLab = new CheckOffLab(c.getApplicationContext());
        }
        return sCheckOffLab;
    }

    public ArrayList<List> getTasks() {
        return mTasks;
    }

    public List getList(UUID id) {
        // for-each loop
        for(List c : mTasks) {
            if(c.getId().equals(id)) {
                // compare the contents of the ids
                return c;
            }
        }
        return null;
    }
}