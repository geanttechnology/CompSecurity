// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

public class zv
    implements aag
{

    private int a;

    public zv()
    {
        a = 4;
    }

    public zv(int i)
    {
        a = i;
    }

    public void a(int i, String s, String s1)
    {
        a(i, s, s1, false);
    }

    public void a(int i, String s, String s1, boolean flag)
    {
        if (flag || a(s, i))
        {
            Log.println(i, s, s1);
        }
    }

    public void a(String s, String s1)
    {
        a(s, s1, ((Throwable) (null)));
    }

    public void a(String s, String s1, Throwable throwable)
    {
        if (a(s, 3))
        {
            Log.d(s, s1, throwable);
        }
    }

    public boolean a(String s, int i)
    {
        return a <= i;
    }

    public void b(String s, String s1)
    {
        b(s, s1, null);
    }

    public void b(String s, String s1, Throwable throwable)
    {
        if (a(s, 2))
        {
            Log.v(s, s1, throwable);
        }
    }

    public void c(String s, String s1)
    {
        c(s, s1, null);
    }

    public void c(String s, String s1, Throwable throwable)
    {
        if (a(s, 4))
        {
            Log.i(s, s1, throwable);
        }
    }

    public void d(String s, String s1)
    {
        d(s, s1, null);
    }

    public void d(String s, String s1, Throwable throwable)
    {
        if (a(s, 5))
        {
            Log.w(s, s1, throwable);
        }
    }

    public void e(String s, String s1)
    {
        e(s, s1, null);
    }

    public void e(String s, String s1, Throwable throwable)
    {
        if (a(s, 6))
        {
            Log.e(s, s1, throwable);
        }
    }
}
