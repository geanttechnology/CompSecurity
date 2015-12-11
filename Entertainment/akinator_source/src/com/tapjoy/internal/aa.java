// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;

// Referenced classes of package com.tapjoy.internal:
//            fq

public final class aa
{

    private static String a = "pool.ntp.org";
    private static long b = 20000L;
    private static volatile boolean c = false;
    private static volatile String d;
    private static volatile long e;
    private static volatile long f;
    private static volatile long g;
    private static volatile long h;
    private static volatile long i;

    public static long a(long l)
    {
        return h + l;
    }

    private static void a(boolean flag, String s, long l, long l1, long l2)
    {
        com/tapjoy/internal/aa;
        JVM INSTR monitorenter ;
        c = flag;
        d = s;
        e = l;
        f = l1;
        g = l2;
        h = e - f;
        i = (SystemClock.elapsedRealtime() + h) - System.currentTimeMillis();
        com/tapjoy/internal/aa;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static boolean a()
    {
        String s = a;
        long l = b;
        fq fq1 = new fq();
        if (fq1.a(s, (int)l))
        {
            a(true, "SNTP", fq1.a, fq1.b, fq1.c / 2L);
            return true;
        } else
        {
            return false;
        }
    }

    public static long b()
    {
        return SystemClock.elapsedRealtime() + h;
    }

    public static boolean c()
    {
        return c;
    }

    static 
    {
        long l = SystemClock.elapsedRealtime();
        a(false, "System", System.currentTimeMillis(), l, 0x7fffffffffffffffL);
    }
}
