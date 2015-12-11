// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.model;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class Track
{

    public final String albumKey;
    public final String albumName;
    public final String artistKey;
    public final String artistName;
    public final boolean canStream;
    public final int durationInSec;
    public final String icon200px;
    public final String key;
    public final String name;
    public final String radioKey;
    public final int trackIndex;

    protected Track(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            int j, String s6, boolean flag, String s7)
    {
        key = s;
        name = s1;
        albumKey = s2;
        albumName = s3;
        artistKey = s4;
        artistName = s5;
        trackIndex = i;
        durationInSec = j;
        icon200px = s6;
        canStream = flag;
        radioKey = s7;
    }

    public static Track extractTrack(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        String s;
        if (!jsonobject.has("radioKey"))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        s = jsonobject.getString("radioKey");
_L1:
        jsonobject = new Track(jsonobject.getString("key"), jsonobject.getString("name"), jsonobject.getString("albumKey"), jsonobject.getString("album"), jsonobject.getString("artistKey"), jsonobject.getString("artist"), jsonobject.getInt("trackNum"), jsonobject.getInt("duration"), jsonobject.getString("icon"), jsonobject.getBoolean("canStream"), s);
        return jsonobject;
        jsonobject;
        Log.e("rdio", "There was a problem while parsing the track data");
        return null;
        s = null;
          goto _L1
    }

    public String toString()
    {
        return (new StringBuilder("Track '")).append(name).append("' [").append(key).append("] from '").append(albumName).append("' [").append(albumKey).append("] by '").append(artistName).append("' [").append(artistKey).append("] @ ").append(durationInSec).append("s").toString();
    }
}
