// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CleanupPreferenceManager
{

    private final SharedPreferences sharedPreferences;

    public CleanupPreferenceManager(Context context)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean getCleanupPreference()
    {
        return sharedPreferences.getBoolean("show_cleanup_content_key", false);
    }

    public void setCleanupPreference(boolean flag)
    {
        sharedPreferences.edit().putBoolean("show_cleanup_content_key", flag).apply();
    }
}
