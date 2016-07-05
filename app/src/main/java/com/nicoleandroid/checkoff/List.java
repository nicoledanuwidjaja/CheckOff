package com.nicoleandroid.checkoff;

import java.util.Date;
import java.util.UUID;

/**
 *
 * CheckOff
 *
 * Created by Nicole on 1/26/16
 * Copyright Narwhal Android 2016
 *
 */
public class List {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mCompleted;

    public List() {
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();

    }

    @Override
    public String toString() {
        return mTitle;
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

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        mCompleted = completed;
    }

}
