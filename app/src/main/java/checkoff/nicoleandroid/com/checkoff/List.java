package checkoff.nicoleandroid.com.checkoff;

import java.util.UUID;

/**
 * Created by Nicole on 1/20/16.
 */
public class List {

    private UUID mId;
    private String mTitle;

    public List() {
        // Generate unique identifier
        mId = UUID.randomUUID();

    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
