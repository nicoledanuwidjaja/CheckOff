package com.nicoleandroid.checkoff; /**
 *
 * CheckOff
 *
 * Created by Nicole on 3/29/16
 * Copyright Narwhal Android 2016
 *
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.nicoleandroid.checkoff.R;

public class CheckListFragment extends ListFragment {
    private ArrayList<List> mTasks;
    private static final String TAG = "CheckListFragment";
    private static final int REQUEST_LIST = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.tasks_title);
        mTasks = CheckOffLab.get(getActivity()).getTasks();

        CheckListAdapter adapter = new CheckListAdapter(mTasks);
        setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CheckListAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Get the Crime from the adapter
        List t = ((CheckListAdapter)getListAdapter()).getItem(position);
        // Log.d(TAG, c.getTitle() + " was clicked");
        // Start CrimeActivity
        Intent i = new Intent(getActivity(), ListActivity.class);
        // ISSUE WITH EXTRA_LIST_ID --> ListFragment.java
        // i.putExtra(ListFragment.EXTRA_LIST_ID, t.getId());
        startActivityForResult(i, REQUEST_LIST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LIST) {
            //Handle result
        }
    }

    private class CheckListAdapter extends ArrayAdapter<List> {

        public CheckListAdapter(ArrayList<List> tasks) {
            super(getActivity(), 0, tasks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If there isn't a View, inflate one
            if(convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_check, null);
            }

            // Configure the view for this Task
            List t = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.check_list_item_titleTextView);
            titleTextView.setText(t.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.check_list_item_dateTextView);
            dateTextView.setText(t.getDate().toString());

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.check_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(t.isCompleted());

            return convertView;

        }
    }
}
