// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.Context;
import android.content.SharedPreferences;
import com.target.ui.util.q;

public class b
{

    private static final String KEY_GOOGLE_NOW_ALARM_ENABLED = "googleNowAlarmEnabled";
    private static final String KEY_GOOGLE_NOW_PREFS = "googleNowSharedPrefs";
    private static final String KEY_WAS_GUEST_INSIDE_STORE = "wasGuestInsideStore";
    public static final String TAG = "GoogleNowCreateAlarmListener";

    public static Boolean a(Context context)
    {
        boolean flag = false;
        context = c(context);
        if (context != null)
        {
            flag = context.getBoolean("wasGuestInsideStore", false);
        }
        return Boolean.valueOf(flag);
    }

    public static void a(Context context, Boolean boolean1)
    {
        context = c(context);
        if (context != null)
        {
            context.edit().putBoolean("wasGuestInsideStore", boolean1.booleanValue()).apply();
        }
    }

    public static Boolean b(Context context)
    {
        boolean flag = false;
        context = c(context);
        if (context != null)
        {
            flag = context.getBoolean("googleNowAlarmEnabled", false);
        }
        return Boolean.valueOf(flag);
    }

    public static void b(Context context, Boolean boolean1)
    {
        context = c(context);
        if (context != null)
        {
            context.edit().putBoolean("googleNowAlarmEnabled", boolean1.booleanValue()).apply();
        }
    }

    private static SharedPreferences c(Context context)
    {
        context = context.getSharedPreferences("googleNowSharedPrefs", 0);
        if (context == null)
        {
            q.a("GoogleNowCreateAlarmListener", "Google Now shared pref not present");
        }
        return context;
    }
}
