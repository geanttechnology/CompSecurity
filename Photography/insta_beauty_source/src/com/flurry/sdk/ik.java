// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            il, ij

public class ik
{

    private static final String m = com/flurry/sdk/ik.getName();
    public int a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public il f;
    public String g;
    public int h;
    public long i;
    public boolean j;
    public long k;
    public ij l;

    public ik(ij ij1, long l1, long l2, int i1)
    {
        k = 0L;
        l = ij1;
        b = l1;
        c = l2;
        a = i1;
        e = 0;
        f = il.d;
    }

    public void a()
    {
        l.a(this);
        if (d)
        {
            l.a(true);
        }
    }

    public void a(int i1)
    {
        if (i1 < 0)
        {
            if (k <= 0L)
            {
                k = 0L;
            }
            return;
        } else
        {
            k = k + (long)i1;
            return;
        }
    }

    public void a(String s)
    {
        l.c(s);
    }

    public boolean b()
    {
        return l.c();
    }

    public boolean c()
    {
        return l.a(h);
    }

    public String d()
    {
        return l.m();
    }

    public String e()
    {
        return l.i();
    }

    public String f()
    {
        return l.t();
    }

    public void g()
    {
        l.b();
    }

}
