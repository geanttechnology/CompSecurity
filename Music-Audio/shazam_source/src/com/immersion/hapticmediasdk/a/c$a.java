// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Handler;
import android.os.SystemClock;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.b.d;
import java.util.ArrayList;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            c

private final class i
    implements Runnable
{

    public static int b = 45;
    public static int c = 1;
    public static int d = 2;
    public final c a;
    private final byte e[];
    private final long f;
    private final long g;
    private final int h;
    private final long i;

    public final void run()
    {
        if (com.immersion.hapticmediasdk.a.c.l(a))
        {
            synchronized (com.immersion.hapticmediasdk.a.c.m(a))
            {
                com.immersion.hapticmediasdk.a.c.n(a).remove(this);
            }
            if (f >= g)
            {
                if (com.immersion.hapticmediasdk.a.c.o(a).a())
                {
                    obj = com.immersion.hapticmediasdk.a.c.g();
                    byte abyte0[] = e;
                    int j = e.length;
                    long l = i;
                    long l1 = h;
                    try
                    {
                        ((EndpointWarp) (obj)).updateWarp(((EndpointWarp) (obj)).a, abyte0, j, l, l1);
                    }
                    catch (Exception exception)
                    {
                        throw exception;
                    }
                    if (((EndpointWarp.b + EndpointWarp.e) * EndpointWarp.b) % EndpointWarp.d != EndpointWarp.c)
                    {
                        EndpointWarp.b = 29;
                        EndpointWarp.c = 29;
                    }
                }
                synchronized (com.immersion.hapticmediasdk.a.c.p(a))
                {
                    com.immersion.hapticmediasdk.a.c.d(a, com.immersion.hapticmediasdk.a.c.g(a));
                    com.immersion.hapticmediasdk.a.c.q(a);
                    com.immersion.hapticmediasdk.a.c.a(a, SystemClock.uptimeMillis());
                }
            }
            com.immersion.hapticmediasdk.a.c.b(a).post(com.immersion.hapticmediasdk.a.c.r(a));
        }
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public (c c1, long l, long l1, byte abyte0[], int j, 
            long l2)
    {
        int k;
        try
        {
            a = c1;
            super();
            e = abyte0;
            f = l;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
        k = b;
        switch ((k * (c + k)) % d)
        {
        default:
            b = 15;
            c = 32;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            g = l1;
            h = j;
            i = l2;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            throw c1;
        }
    }
}
