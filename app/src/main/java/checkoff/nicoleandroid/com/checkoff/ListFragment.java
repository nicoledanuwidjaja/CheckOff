package checkoff.nicoleandroid.com.checkoff;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Nicole on 1/26/16.
 */
public class ListFragment extends Fragment{
    private List mList;
    private EditText mTitleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new List();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, parent, false);

        mTitleField = (EditText)v.findViewById(R.id.list_title);
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

        return v;
    }

}
