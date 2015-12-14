// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class q
{

    private SharedPreferences a;

    public q(Context context, String s, int i)
    {
        a = context.getSharedPreferences(s, i);
    }

    public int a(String s, int i)
    {
        return a.getInt(s, i);
    }

    public long a(String s, long l)
    {
        return a.getLong(s, l);
    }

    public String a(String s, String s1)
    {
        return a.getString(s, s1);
    }

    public boolean a()
    {
        Log.d("Pref", "clear()");
        return a.edit().clear().commit();
    }

    public boolean a(String s, boolean flag)
    {
        return a.getBoolean(s, flag);
    }

    public void b(String s, int i)
    {
        Log.d("Pref", (new StringBuilder()).append("putInt(").append(s).append(",").append(i).append(")").toString());
        a.edit().putInt(s, i).apply();
    }

    public void b(String s, long l)
    {
        Log.v("Pref", (new StringBuilder()).append("putLong(").append(s).append(",").append(l).append(")").toString());
        a.edit().putLong(s, l).apply();
    }

    public void b(String s, String s1)
    {
        Log.d("Pref", (new StringBuilder()).append("putString(").append(s).append(",").append(s1).append(")").toString());
        a.edit().putString(s, s1).apply();
    }

    public void b(String s, boolean flag)
    {
        Log.d("Pref", (new StringBuilder()).append("putBoolean(").append(s).append(",").append(flag).append(")").toString());
        a.edit().putBoolean(s, flag).apply();
    }
}
