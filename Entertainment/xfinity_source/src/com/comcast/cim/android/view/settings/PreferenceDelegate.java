// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public abstract class PreferenceDelegate
{

    private Context context;

    public PreferenceDelegate(Context context1)
    {
        context = context1;
    }

    protected Preference findPreference(int i)
    {
        return findPreference(context.getResources().getString(i));
    }

    protected Preference findPreference(String s)
    {
        return getPrefFragment().findPreference(s);
    }

    protected Context getContext()
    {
        return context;
    }

    protected abstract PreferenceFragment getPrefFragment();
}
