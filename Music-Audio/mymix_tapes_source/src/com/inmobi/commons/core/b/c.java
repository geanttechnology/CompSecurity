// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.inmobi.commons.a.a;
import java.util.HashMap;

public final class c
{

    private static HashMap a = new HashMap();
    private static final Object b = new Object();
    private SharedPreferences c;

    private c(Context context, String s)
    {
        c = context.getSharedPreferences(s, 0);
    }

    public static c a(Context context, String s)
    {
        String s1;
        s1 = a(s);
        if (a.containsKey(s1))
        {
            return (c)a.get(s1);
        }
        synchronized (b)
        {
            if (!a.containsKey(s1))
            {
                break MISSING_BLOCK_LABEL_62;
            }
            context = (c)a.get(s1);
        }
        return context;
        context;
        s;
        JVM INSTR monitorexit ;
        throw context;
        context = new c(context, s1);
        a.put(s1, context);
        s;
        JVM INSTR monitorexit ;
        return context;
    }

    public static String a(String s)
    {
        return (new StringBuilder()).append("com.im.keyValueStore.").append(s).toString();
    }

    public static c b(String s)
    {
        return a(com.inmobi.commons.a.a.b(), s);
    }

    public void a(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putInt(s, i);
        editor.apply();
    }

    public void a(String s, long l)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putLong(s, l);
        editor.apply();
    }

    public void a(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString(s, s1);
        editor.apply();
    }

    public void a(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putBoolean(s, flag);
        editor.apply();
    }

    public int b(String s, int i)
    {
        return c.getInt(s, i);
    }

    public long b(String s, long l)
    {
        return c.getLong(s, l);
    }

    public String b(String s, String s1)
    {
        return c.getString(s, s1);
    }

    public boolean b(String s, boolean flag)
    {
        return c.getBoolean(s, flag);
    }

}
