// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class dt
{

    private int a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;

    public dt()
    {
        k = 0;
    }

    public int a()
    {
        return a;
    }

    public void a(int l)
    {
        a = l;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public void b(int l)
    {
        k = l;
    }

    public void b(boolean flag)
    {
        b = flag;
    }

    public boolean b()
    {
        return c;
    }

    public void c(boolean flag)
    {
        d = flag;
    }

    public boolean c()
    {
        return b;
    }

    public void d(boolean flag)
    {
        e = flag;
    }

    public boolean d()
    {
        return d;
    }

    public void e(boolean flag)
    {
        f = flag;
    }

    public boolean e()
    {
        return e;
    }

    public void f(boolean flag)
    {
        i = flag;
    }

    public boolean f()
    {
        return f;
    }

    public void g(boolean flag)
    {
        g = flag;
    }

    public boolean g()
    {
        return i;
    }

    public void h(boolean flag)
    {
        h = flag;
    }

    public boolean h()
    {
        return g;
    }

    public int i()
    {
        return k;
    }

    public String toString()
    {
        return (new StringBuilder()).append("videoPosition:").append(a).append(", videoStartHit:").append(c).append(", videoFirstQuartileHit:").append(d).append(", videoMidpointHit:").append(e).append(", videoThirdQuartileHit:").append(f).append(", moreInfoClicked:").append(g).append(", videoRendered:").append(h).append(", moreInfoInProgress:").append(j).toString();
    }
}
