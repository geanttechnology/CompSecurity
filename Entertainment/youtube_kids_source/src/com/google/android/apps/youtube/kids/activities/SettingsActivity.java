// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceActivity;
import java.util.List;

public class SettingsActivity extends PreferenceActivity
{

    public SettingsActivity()
    {
    }

    public static Intent a(Context context)
    {
        context = new Intent(context, com/google/android/apps/youtube/kids/activities/SettingsActivity);
        context.putExtra(":android:show_fragment", com/google/android/apps/youtube/kids/activities/SettingsActivity$SettingsPrefsFragment.getName());
        return context;
    }

    protected boolean isValidFragment(String s)
    {
        return com/google/android/apps/youtube/kids/activities/SettingsActivity$SettingsPrefsFragment.getName().equals(s);
    }

    public void onBuildHeaders(List list)
    {
        loadHeadersFromResource(0x7f070001, list);
    }
}
