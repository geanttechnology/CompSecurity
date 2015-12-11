// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.creditcardreaderlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil
{

    public PreferenceUtil()
    {
    }

    public static String getPreference(Context context, String s)
    {
        return context.getSharedPreferences("creditcard.pref", 0).getString(s, null);
    }

    public static void savePreference(Context context, String s, String s1)
    {
        context = context.getSharedPreferences("creditcard.pref", 0).edit();
        context.putString(s, s1);
        context.commit();
    }
}
