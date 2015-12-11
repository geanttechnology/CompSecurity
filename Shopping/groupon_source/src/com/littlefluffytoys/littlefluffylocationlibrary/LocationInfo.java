// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import java.io.Serializable;

public class LocationInfo
    implements Serializable
{

    public int lastAccuracy;
    public float lastLat;
    public long lastLocationBroadcastTimestamp;
    public long lastLocationUpdateTimestamp;
    public float lastLong;
    public String lastProvider;

    public LocationInfo(Context context)
    {
        refresh(context);
    }

    public static String formatTimeAndDay(long l, boolean flag)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("kk:mm");
        String s;
        if (flag)
        {
            s = ".ss";
        } else
        {
            s = "";
        }
        return DateFormat.format(stringbuilder.append(s).append(", E").toString(), l).toString();
    }

    protected static String formatTimestampForDebug(long l)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(l).append(" (");
        String s;
        if (l > 0L)
        {
            s = formatTimeAndDay(l, true);
        } else
        {
            s = "the dawn of time";
        }
        return stringbuilder.append(s).append(")").toString();
    }

    public void refresh(Context context)
    {
        context = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        lastLocationUpdateTimestamp = context.getLong("LFT_SP_KEY_LAST_LOCATION_UPDATE_TIME", 0L);
        lastLocationBroadcastTimestamp = context.getLong("LFT_SP_KEY_LAST_LOCATION_SUBMIT_TIME", 0L);
        lastLat = (float)(int)(context.getFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LAT", -2.147484E+09F) * 1000000F) / 1000000F;
        lastLong = (float)(int)(context.getFloat("LFT_SP_KEY_LAST_LOCATION_UPDATE_LNG", -2.147484E+09F) * 1000000F) / 1000000F;
        lastAccuracy = context.getInt("LFT_SP_KEY_LAST_LOCATION_UPDATE_ACCURACY", 0x7fffffff);
        lastProvider = context.getString("LFT_SP_KEY_LAST_LOCATION_UPDATE_PROVIDER", null);
    }

    public String toString()
    {
        String s;
        String s1;
        if (lastLocationUpdateTimestamp != 0L)
        {
            s = formatTimeAndDay(lastLocationUpdateTimestamp, true);
        } else
        {
            s = "none";
        }
        if (lastLocationBroadcastTimestamp != 0L)
        {
            s1 = formatTimeAndDay(lastLocationBroadcastTimestamp, true);
        } else
        {
            s1 = "none";
        }
        return String.format("lastLocationUpdateTimestamp=%1$s lastLocationBroadcastTimestamp=%2$s lastLat=%3$.6f lastLong=%4$.6f lastAccuracy=%5$d", new Object[] {
            s, s1, Float.valueOf(lastLat), Float.valueOf(lastLong), Integer.valueOf(lastAccuracy)
        });
    }
}
