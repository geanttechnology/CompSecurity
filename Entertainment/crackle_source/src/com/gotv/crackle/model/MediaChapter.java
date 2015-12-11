// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class MediaChapter
{

    private static final String NAME = "Name";
    private static final String SHOW_AD_BEFORE = "ShowAdBefore";
    private static final String START_TIME = "StartTime";
    private static final String START_TIME_IN_MILLISECONDS = "StartTimeInMilliSeconds";
    private String mName;
    private Boolean mShowAdBefore;
    private String mStartTime;
    private Integer mStartTimeMilliSeconds;

    public MediaChapter(JSONObject jsonobject)
        throws JSONException
    {
        mName = jsonobject.getString("Name");
        mStartTime = jsonobject.getString("StartTime");
        mStartTimeMilliSeconds = Integer.valueOf(jsonobject.getInt("StartTimeInMilliSeconds"));
        mShowAdBefore = Boolean.valueOf(jsonobject.getBoolean("ShowAdBefore"));
    }

    public String getName()
    {
        return mName;
    }

    public Boolean getShowAdBefore()
    {
        return mShowAdBefore;
    }

    public String getStartTime()
    {
        return mStartTime;
    }

    public Integer getStartTimeMilliSeconds()
    {
        return mStartTimeMilliSeconds;
    }
}
