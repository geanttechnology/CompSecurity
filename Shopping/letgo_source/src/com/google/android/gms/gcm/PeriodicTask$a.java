// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;


// Referenced classes of package com.google.android.gms.gcm:
//            PeriodicTask

public static class e extends e
{

    private long h;
    private long i;

    static long a(e e)
    {
        return e.h;
    }

    static long b(h h1)
    {
        return h1.i;
    }

    public i a(int j)
    {
        a = j;
        return this;
    }

    public a a(long l)
    {
        h = l;
        return this;
    }

    public h a(Class class1)
    {
        b = class1.getName();
        return this;
    }

    public b a(String s)
    {
        c = s;
        return this;
    }

    public c a(boolean flag)
    {
        f = flag;
        return this;
    }

    public PeriodicTask a()
    {
        b();
        return new PeriodicTask(this, null);
    }

    public nit> b(long l)
    {
        i = l;
        return this;
    }

    public i b(boolean flag)
    {
        e = flag;
        return this;
    }

    protected void b()
    {
        super.e();
        if (h == -1L)
        {
            throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
        }
        if (i == -1L)
        {
            i = (long)((float)h * 0.1F);
        }
    }

    public h c(boolean flag)
    {
        d = flag;
        return this;
    }

    public ()
    {
        h = -1L;
        i = -1L;
        e = true;
    }
}
