package com.nicoleandroid.checkoff;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

import com.nicoleandroid.checkoff.R;

/**
 *
 * CheckOff
 *
 * Created by Nicole on 1/26/16
 * Copyright Narwhal Android 2016
 *
 */
public class ListFragment extends Fragment{
    public static final String EXTRA_LIST_ID = "com.nicoleandroid.checkoff.list_id";

    private List mList;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mCompletedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID ListId = (UUID)getArguments().getSerializable(EXTRA_LIST_ID);

        mList = CheckOffLab.get(getActivity()).getList(ListId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, parent, false);

        mTitleField = (EditText)v.findViewById(R.id.list_title);
        mTitleField.setText(mList.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mList.setTitle(c.toString());
            }
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // This space is intentionally left blank
            }
            public void afterTextChanged(Editable c) {
                // This space is intentionally left blank

            }
        });

        mDateButton = (Button)v.findViewById(R.id.list_date);
        mDateButton.setText(mList.getDate().toString());
        mDateButton.setEnabled(false);

        mCompletedCheckBox = (CheckBox)v.findViewById(R.id.list_completed);
        mCompletedCheckBox.setChecked(mList.isCompleted());
        mCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set the list's solved property
                mList.setCompleted(isChecked);
            }
        });
        return v;
    }

    public static ListFragment newInstance(UUID ListId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_LIST_ID, ListId);

        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public void returnResult() {
        getActivity().setResult(Activity.RESULT_OK, null);
    }
}
