// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.reporting:
//            PlayEventType

public class PlayEvent
{

    private JSONObject json;
    public int playTimeMs;
    private long timestamp;
    private PlayEventType type;

    public PlayEvent(PlayEventType playeventtype)
    {
        type = playeventtype;
        json = new JSONObject();
        timestamp = System.currentTimeMillis() / 1000L;
    }

    public PlayEventType getEventType()
    {
        return type;
    }

    public void put(String s, int i)
    {
        try
        {
            json.put(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void put(String s, String s1)
    {
        try
        {
            json.put(s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void put(String s, boolean flag)
    {
        try
        {
            json.put(s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public JSONObject toJson()
    {
        try
        {
            json.put("type", type.toServerString());
            json.put("timestamp", timestamp);
            json.put("playTime", Math.round(playTimeMs / 1000));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return json;
    }
}
