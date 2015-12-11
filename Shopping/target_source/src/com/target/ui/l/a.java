// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.ui.l.a
{
    public static interface a
    {

        public abstract void a(boolean flag);
    }


    private static final String VLC_SHARED_PREFS = "com.target.ui.vlc.vlcSharedPrefs";
    private static com.target.ui.l.a sInstance;
    private List mListeners;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences mVlcSharedPreference;

    private com.target.ui.l.a(Context context)
    {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mVlcSharedPreference = context.getSharedPreferences("com.target.ui.vlc.vlcSharedPrefs", 0);
        mListeners = new ArrayList();
    }

    public static com.target.ui.l.a a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("Initialize must be called before getInstance");
        } else
        {
            return sInstance;
        }
    }

    public static void a(Context context)
    {
        if (sInstance != null)
        {
            return;
        } else
        {
            sInstance = new com.target.ui.l.a(context);
            return;
        }
    }

    private void a(String s, boolean flag)
    {
        mSharedPreferences.edit().putBoolean(s, flag).apply();
    }

    public void a(a a1)
    {
        mListeners.add(a1);
    }

    public void a(Boolean boolean1)
    {
        mVlcSharedPreference.edit().putBoolean("inStoreLocationEnabled", boolean1.booleanValue()).apply();
    }

    public void a(boolean flag)
    {
        a("key_notification_enabled", flag);
        b(flag);
    }

    public void b(boolean flag)
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((a)iterator.next()).a(flag)) { }
    }

    public boolean b()
    {
        return mSharedPreferences.getBoolean("key_notification_enabled", true);
    }

    public boolean c()
    {
        return mVlcSharedPreference.getBoolean("inStoreLocationEnabled", true);
    }
}
