// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.ui_stuff.samsungbadger;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences
{

    public static final String PREFERENCES_FILE = "Badge.Main";
    private static final String PREF_IS_BADGING_SUPPORTED = "isBadgingSupported";
    private static Preferences sPreferences;
    final SharedPreferences mSharedPreferences;

    private Preferences(Context context)
    {
        mSharedPreferences = context.getSharedPreferences("Badge.Main", 0);
    }

    public static Preferences getPreferences(Context context)
    {
        com/ebay/mobile/ui_stuff/samsungbadger/Preferences;
        JVM INSTR monitorenter ;
        if (sPreferences == null)
        {
            sPreferences = new Preferences(context);
        }
        context = sPreferences;
        com/ebay/mobile/ui_stuff/samsungbadger/Preferences;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public int getIsBadgingSupported()
    {
        return mSharedPreferences.getInt("isBadgingSupported", -1);
    }

    public void setIsBadgingSupported(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        editor.putInt("isBadgingSupported", i).apply();
    }
}
