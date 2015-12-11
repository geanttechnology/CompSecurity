// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class PlayProgressItem
{

    private static final String DURATION_IN_SECONDS = "DurationInSeconds";
    private static final String ID = "MediaId";
    private static final String TIMESTAMP = "TimeStamp";
    private String mID;
    private String mPosition;
    private long mTimeStamp;

    public PlayProgressItem(JSONObject jsonobject)
        throws JSONException
    {
        mID = jsonobject.getString("MediaId");
        mPosition = jsonobject.getString("DurationInSeconds");
        try
        {
            mTimeStamp = Long.parseLong(jsonobject.getString("TimeStamp").split("\\(")[1].split("\\)")[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    public String getID()
    {
        return mID;
    }

    public String getPosition()
    {
        return mPosition;
    }

    public long getTimeStamp()
    {
        return mTimeStamp;
    }
}
