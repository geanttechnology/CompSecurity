// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ah, an

public class ae
{

    private String a;
    private an b;
    private long c;
    private long d;
    private ah e;
    private long f;
    private long g;

    private ae()
    {
    }


    public ae(String s, an an, long l)
    {
        a = s;
        b = an;
        c = System.currentTimeMillis();
        d = System.currentTimeMillis();
        e = ah.a;
        f = l;
        g = -1L;
    }

    static long a(ae ae1, long l)
    {
        ae1.c = l;
        return l;
    }

    static ah a(ae ae1, ah ah1)
    {
        ae1.e = ah1;
        return ah1;
    }

    static an a(ae ae1, an an)
    {
        ae1.b = an;
        return an;
    }

    static String a(ae ae1)
    {
        return ae1.a;
    }

    static String a(ae ae1, String s)
    {
        ae1.a = s;
        return s;
    }

    static long b(ae ae1, long l)
    {
        ae1.d = l;
        return l;
    }

    static an b(ae ae1)
    {
        return ae1.b;
    }

    static long c(ae ae1)
    {
        return ae1.c;
    }

    static long c(ae ae1, long l)
    {
        ae1.f = l;
        return l;
    }

    static long d(ae ae1)
    {
        return ae1.d;
    }

    static long d(ae ae1, long l)
    {
        ae1.g = l;
        return l;
    }

    static ah e(ae ae1)
    {
        return ae1.e;
    }

    static long f(ae ae1)
    {
        return ae1.f;
    }

    static long g(ae ae1)
    {
        return ae1.g;
    }

    public String a()
    {
        return a;
    }

    public void a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        g = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(ah ah1)
    {
        this;
        JVM INSTR monitorenter ;
        e = ah1;
        this;
        JVM INSTR monitorexit ;
        return;
        ah1;
        throw ah1;
    }

    public ah b()
    {
        this;
        JVM INSTR monitorenter ;
        ah ah1 = e;
        this;
        JVM INSTR monitorexit ;
        return ah1;
        Exception exception;
        exception;
        throw exception;
    }

    public long c()
    {
        return f;
    }

    public boolean d()
    {
        return f > 0L && System.currentTimeMillis() > f;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        d = System.currentTimeMillis();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long f()
    {
        return c;
    }

    public String toString()
    {
        return (new StringBuilder()).append("url: ").append(a).append(", type:").append(b).append(", creation:").append(c).append(", accessed:").append(d).append(", status: ").append(e).append(", expiration: ").append(f).append(", size: ").append(g).toString();
    }
}
