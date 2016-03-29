package checkoff.nicoleandroid.com.checkoff; /**
 *
 * CheckOff
 *
 * Created by Nicole on 3/29/16
 * Copyright Narwhal Android 2016
 *
 */
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

public class CheckListFragment extends ListFragment {
    private ArrayList<List> mTasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.tasks_title);
        mTasks = CheckOffLab.get(getActivity()).getTasks();
    }
}
