package checkoff.nicoleandroid.com.checkoff;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

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
        return new ListFragment();
    }
}
