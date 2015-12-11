// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

class asl
    implements aqw
{

    private int a;

    asl()
    {
        a = 5;
    }

    public void a(String s)
    {
        if (a <= 6)
        {
            Log.e("GoogleTagManager", s);
        }
    }

    public void a(String s, Throwable throwable)
    {
        if (a <= 6)
        {
            Log.e("GoogleTagManager", s, throwable);
        }
    }

    public void b(String s)
    {
        if (a <= 5)
        {
            Log.w("GoogleTagManager", s);
        }
    }

    public void c(String s)
    {
        if (a <= 4)
        {
            Log.i("GoogleTagManager", s);
        }
    }

    public void d(String s)
    {
        if (a <= 2)
        {
            Log.v("GoogleTagManager", s);
        }
    }
}
