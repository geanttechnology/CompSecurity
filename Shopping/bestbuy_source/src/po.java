// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

class po
    implements pl
{

    private int a;

    po()
    {
        a = 2;
    }

    private String c(String s)
    {
        return (new StringBuilder()).append(Thread.currentThread().toString()).append(": ").append(s).toString();
    }

    public void a(String s)
    {
        if (a <= 0)
        {
            Log.v("GAV4", c(s));
        }
    }

    public void b(String s)
    {
        if (a <= 3)
        {
            Log.e("GAV4", c(s));
        }
    }
}
