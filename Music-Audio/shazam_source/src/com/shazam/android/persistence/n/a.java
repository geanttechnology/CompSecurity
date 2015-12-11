// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.n;

import android.content.SharedPreferences;

// Referenced classes of package com.shazam.android.persistence.n:
//            b

public final class a
    implements b
{

    private final SharedPreferences a;
    private final android.content.SharedPreferences.Editor b;

    public a(SharedPreferences sharedpreferences, android.content.SharedPreferences.Editor editor)
    {
        a = sharedpreferences;
        b = editor;
    }

    public final String a(String s, String s1)
    {
        return a.getString(s, s1);
    }

    public final void a(String s, float f1)
    {
        b.putFloat(s, f1);
        b.apply();
    }

    public final void a(String s, int j)
    {
        b.putInt(s, j);
        b.apply();
    }

    public final void a(String s, long l)
    {
        b.putLong(s, l);
        b.apply();
    }

    public final boolean a(String s)
    {
        return a.contains(s);
    }

    public final boolean a(String s, boolean flag)
    {
        return a.getBoolean(s, flag);
    }

    public final void b(String s, String s1)
    {
        b.putString(s, s1);
        b.apply();
    }

    public final void b(String s, boolean flag)
    {
        b.putBoolean(s, flag);
        b.apply();
    }

    public final boolean b(String s)
    {
        return a.getBoolean(s, false);
    }

    public final float c(String s)
    {
        return a.getFloat(s, 0.0F);
    }

    public final int d(String s)
    {
        return a.getInt(s, 0);
    }

    public final Long e(String s)
    {
        if (a.contains(s))
        {
            return Long.valueOf(f(s));
        } else
        {
            return null;
        }
    }

    public final long f(String s)
    {
        return a.getLong(s, 0L);
    }

    public final long g(String s)
    {
        return a.getLong(s, 0L);
    }

    public final String h(String s)
    {
        return a(s, ((String) (null)));
    }

    public final void i(String s)
    {
        b.remove(s);
        b.apply();
    }
}
