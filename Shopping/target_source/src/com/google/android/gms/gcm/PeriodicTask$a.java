// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;


// Referenced classes of package com.google.android.gms.gcm:
//            PeriodicTask

public static class e extends e
{

    private long g;
    private long h;

    static long a(e e)
    {
        return e.g;
    }

    static long b(g g1)
    {
        return g1.h;
    }

    public h a(int i)
    {
        a = i;
        return this;
    }

    public a a(long l)
    {
        g = l;
        return this;
    }

    public g a(Class class1)
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

    protected void a()
    {
        super.f();
        if (g == -1L)
        {
            throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
        }
        if (h == -1L)
        {
            h = (long)((float)g * 0.1F);
        }
    }

    public g b(long l)
    {
        h = l;
        return this;
    }

    public h b(boolean flag)
    {
        e = flag;
        return this;
    }

    public PeriodicTask b()
    {
        a();
        return new PeriodicTask(this, null);
    }

    public nit> c(boolean flag)
    {
        d = flag;
        return this;
    }

    public ()
    {
        g = -1L;
        h = -1L;
        e = true;
    }
}
