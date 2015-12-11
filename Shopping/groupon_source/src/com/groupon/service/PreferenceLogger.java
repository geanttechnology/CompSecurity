// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import com.groupon.tracking.mobile.sdk.Logger;

public class PreferenceLogger
{

    private Logger logger;
    private SharedPreferences prefs;

    public PreferenceLogger()
    {
    }

    public void logAppPrefs(boolean flag)
    {
        if (flag)
        {
            if (!prefs.contains("dealNotification"))
            {
                logger.logGeneralEvent("app_prefs", "", "isPushEnabled", 1, Logger.NULL_NST_FIELD);
                prefs.edit().putBoolean("dealNotification", true).apply();
            }
            if (!prefs.contains("silentNotifications"))
            {
                logger.logGeneralEvent("app_prefs", "", "isSilent", 0, Logger.NULL_NST_FIELD);
                prefs.edit().putBoolean("silentNotifications", true).apply();
            }
            return;
        }
        flag = prefs.getBoolean("dealNotification", true);
        boolean flag1 = prefs.getBoolean("silentNotifications", true);
        Logger logger1 = logger;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        logger1.logGeneralEvent("app_prefs", "", "isPushEnabled", i, Logger.NULL_NST_FIELD);
        logger1 = logger;
        if (flag1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        logger1.logGeneralEvent("app_prefs", "", "isSilent", i, Logger.NULL_NST_FIELD);
    }
}
