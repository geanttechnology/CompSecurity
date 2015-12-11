// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.preference.Preference;
import android.text.TextUtils;

public final class PreferenceUtil
{

    private PreferenceUtil()
    {
    }

    public static Preference setup(Preference preference, String s, int i, int j, boolean flag)
    {
        if (!TextUtils.isEmpty(s))
        {
            preference.setKey(s);
        }
        if (i > 0)
        {
            preference.setTitle(i);
        }
        if (j > 0)
        {
            preference.setSummary(j);
        }
        preference.setPersistent(flag);
        return preference;
    }

    public static Preference setup(Preference preference, String s, CharSequence charsequence, CharSequence charsequence1, boolean flag)
    {
        if (!TextUtils.isEmpty(s))
        {
            preference.setKey(s);
        }
        if (!TextUtils.isEmpty(charsequence))
        {
            preference.setTitle(charsequence);
        }
        if (!TextUtils.isEmpty(charsequence1))
        {
            preference.setSummary(charsequence1);
        }
        preference.setPersistent(flag);
        return preference;
    }
}
