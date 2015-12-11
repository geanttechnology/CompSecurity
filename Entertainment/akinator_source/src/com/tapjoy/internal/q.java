// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class q
{

    public static boolean a(SharedPreferences sharedpreferences, String s, int i)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putInt(s, i);
        return sharedpreferences.commit();
    }

    public static boolean a(SharedPreferences sharedpreferences, String s, String s1)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString(s, s1);
        return sharedpreferences.commit();
    }

    public static boolean a(SharedPreferences sharedpreferences, String s, boolean flag)
    {
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putBoolean(s, flag);
        return sharedpreferences.commit();
    }
}
