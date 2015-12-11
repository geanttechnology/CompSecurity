// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;

import org.json.JSONException;
import org.json.JSONObject;

class ServerLogEntry
{

    private int mLogLevel;
    private String mMessage;
    private SupersonicLogger.SupersonicTag mTag;
    private String mTimetamp;

    public ServerLogEntry(SupersonicLogger.SupersonicTag supersonictag, String s, String s1, int i)
    {
        mTag = supersonictag;
        mTimetamp = s;
        mMessage = s1;
        mLogLevel = i;
    }

    public int getLogLevel()
    {
        return mLogLevel;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("timestamp", mTimetamp);
            jsonobject.put("tag", mTag);
            jsonobject.put("level", mLogLevel);
            jsonobject.put("message", mMessage);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }
}
