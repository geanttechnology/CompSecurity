// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class HidePreferenceManager
{

    private final SharedPreferences sharedPreferences;

    public HidePreferenceManager(Context context)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean getHiddenPreference()
    {
        return sharedPreferences.getBoolean("show_hidden_content_key", false);
    }

    public void setHiddenPreference(boolean flag)
    {
        sharedPreferences.edit().putBoolean("show_hidden_content_key", flag).apply();
    }
}
