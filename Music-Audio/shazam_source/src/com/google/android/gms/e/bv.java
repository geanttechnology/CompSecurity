// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;


// Referenced classes of package com.google.android.gms.e:
//            bh, aj

final class bv
    implements bh
{

    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;

    private bv()
    {
        e = new Object();
        b = 60;
        c = b;
        a = 2000L;
    }

    public bv(byte byte0)
    {
        this();
    }

    public final boolean a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        double d1;
        long l;
        l = System.currentTimeMillis();
        if (c >= (double)b)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        d1 = (double)(l - d) / (double)a;
        if (d1 <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        c = Math.min(b, d1 + c);
        d = l;
        if (c < 1.0D)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        c = c - 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return true;
        aj.a();
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
