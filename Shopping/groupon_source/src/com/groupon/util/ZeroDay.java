// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.SharedPreferences;
import java.util.Date;

public class ZeroDay
{

    private SharedPreferences prefs;

    public ZeroDay()
    {
    }

    public boolean isFirstTimeUser()
    {
        boolean flag1 = true;
        Date date = new Date();
        long l = prefs.getLong("InstallDate", date.getTime());
        boolean flag;
        if (date.getTime() - l > 0xa4cb800L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (date.getTime() == l)
        {
            prefs.edit().putLong("InstallDate", date.getTime()).apply();
        }
        if (!prefs.getBoolean("first_time_user", true) || flag)
        {
            prefs.edit().putBoolean("first_time_user", false).apply();
            flag1 = false;
        }
        return flag1;
    }
}
