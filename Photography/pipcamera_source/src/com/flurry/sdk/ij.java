// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kr, in, ik, iq

public class ij extends kr
{

    private static final String c = com/flurry/sdk/ij.getName();
    public ArrayList a;
    public in b;
    private final int d = 1000;
    private final int e = 30000;
    private final long f;
    private final int g;
    private final int h;
    private final iq i;
    private final Map j;
    private long k;
    private int l;
    private int m;
    private String n;
    private String o;
    private boolean p;

    public ij(String s, long l1, String s1, long l2, int i1, 
            int j1, iq iq, Map map, int k1, int i2, String s2)
    {
        a(s1);
        a(l2);
        a_();
        o = s;
        f = l1;
        c(i1);
        g = i1;
        h = j1;
        i = iq;
        j = map;
        l = k1;
        m = i2;
        n = s2;
        k = 30000L;
        a = new ArrayList();
    }

    static long a(ij ij1, long l1)
    {
        ij1.k = l1;
        return l1;
    }

    static String a(ij ij1)
    {
        return ij1.o;
    }

    static boolean a(ij ij1, boolean flag)
    {
        ij1.p = flag;
        return flag;
    }

    static long b(ij ij1)
    {
        return ij1.f;
    }

    static int c(ij ij1)
    {
        return ij1.g;
    }

    static int d(ij ij1)
    {
        return ij1.h;
    }

    static iq e(ij ij1)
    {
        return ij1.i;
    }

    static Map f(ij ij1)
    {
        return ij1.j;
    }

    static long g(ij ij1)
    {
        return ij1.k;
    }

    static int h(ij ij1)
    {
        return ij1.l;
    }

    static int i(ij ij1)
    {
        return ij1.m;
    }

    static String j(ij ij1)
    {
        return ij1.n;
    }

    static boolean k(ij ij1)
    {
        return ij1.p;
    }

    public void a(ik ik1)
    {
        a.add(ik1);
    }

    public void a(in in1)
    {
        b = in1;
    }

    public void a(boolean flag)
    {
        p = flag;
    }

    public boolean a(int i1)
    {
        return i1 > h;
    }

    public void a_()
    {
        super.a_();
        if (super.r() != 1)
        {
            k = k * 3L;
        }
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        b.g();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        return r() >= g;
    }

    public long e()
    {
        return f;
    }

    public iq f()
    {
        return i;
    }

    public long g()
    {
        return k;
    }

    public Map h()
    {
        return j;
    }

    public String i()
    {
        return o;
    }

    public int j()
    {
        return l;
    }

    public int k()
    {
        return m;
    }

    public String l()
    {
        return n;
    }

    public String m()
    {
        return b.c();
    }

    public boolean n()
    {
        return p;
    }

    public void o()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            ((ik)iterator.next()).l = this;
        }

    }

}
