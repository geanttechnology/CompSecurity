// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;

class 
{

    private static final int DEFAULT_FREQUENCY = 0x36ee80;
    private static final String KEY_FREQUENCY = "frequency_get_cmd";
    private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
    private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";

    public static long getFrequency(Context context, SharedPreferences sharedpreferences)
    {
        long l = 0x36ee80L;
        if (sharedpreferences != null)
        {
            l = sharedpreferences.getLong("frequency_get_cmd", 0x36ee80L);
        }
        return l;
    }

    public static long getLastTime(Context context, SharedPreferences sharedpreferences)
    {
        long l = 0L;
        if (sharedpreferences != null)
        {
            l = sharedpreferences.getLong("last_time_get_cmd", 0L);
        }
        return l;
    }

    public static SharedPreferences getWeiboSdkSp(Context context)
    {
        return context.getSharedPreferences("com_sina_weibo_sdk", 0);
    }

    public static void saveFrequency(Context context, SharedPreferences sharedpreferences, long l)
    {
        if (sharedpreferences != null && l > 0L)
        {
            context = sharedpreferences.edit();
            context.g("frequency_get_cmd", l);
            context.();
        }
    }

    public static void saveLastTime(Context context, SharedPreferences sharedpreferences, long l)
    {
        if (sharedpreferences != null)
        {
            context = sharedpreferences.edit();
            context.g("last_time_get_cmd", l);
            context.();
        }
    }

    private ()
    {
    }
}
