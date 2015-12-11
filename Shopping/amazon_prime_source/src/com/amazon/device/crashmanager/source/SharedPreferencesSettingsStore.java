// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import android.content.SharedPreferences;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            SettingsStore

public class SharedPreferencesSettingsStore
    implements SettingsStore
{

    SharedPreferences mSharedPreferences;

    public SharedPreferencesSettingsStore(SharedPreferences sharedpreferences)
    {
        if (sharedpreferences == null)
        {
            throw new IllegalArgumentException("SharedPreferences can not be null");
        } else
        {
            mSharedPreferences = sharedpreferences;
            return;
        }
    }

    public long getLong(SettingsStore.SettingsKey settingskey, long l)
    {
        return mSharedPreferences.getLong(settingskey.toString(), l);
    }

    public String getString(SettingsStore.SettingsKey settingskey, String s)
    {
        return mSharedPreferences.getString(settingskey.toString(), s);
    }

    public void saveLong(SettingsStore.SettingsKey settingskey, long l)
    {
        mSharedPreferences.edit().putLong(settingskey.toString(), l).apply();
    }

    public void saveString(SettingsStore.SettingsKey settingskey, String s)
    {
        mSharedPreferences.edit().putString(settingskey.toString(), s).apply();
    }
}
