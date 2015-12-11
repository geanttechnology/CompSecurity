// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import android.os.Handler;
import android.os.SystemClock;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.a.c;
import com.immersion.hapticmediasdk.b.d;
import java.util.ArrayList;

public class a
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

    public a(c c1, long l, long l1, byte abyte0[], int j, 
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
            c = a();
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

    public static int a()
    {
        return 32;
    }

    public void run()
    {
        if (com.immersion.hapticmediasdk.a.c.l(a))
        {
            synchronized (com.immersion.hapticmediasdk.a.c.m(a))
            {
                com.immersion.hapticmediasdk.a.c.n(a).remove(this);
            }
            if (f >= g)
            {
                if (com.immersion.hapticmediasdk.a.c.o(a).b())
                {
                    obj = com.immersion.hapticmediasdk.a.c.p(a);
label0:
                    do
                    {
                        switch (1)
                        {
                        default:
                            while (true) 
                            {
                                switch (0)
                                {
                                default:
                                    break;

                                case 0: // '\0'
                                    break label0;

                                case 1: // '\001'
                                    continue label0;
                                }
                            }
                            break;

                        case 0: // '\0'
                            break;

                        case 1: // '\001'
                            break label0;
                        }
                    } while (true);
                    ((EndpointWarp) (obj)).a(e, e.length, i, h);
                }
                synchronized (com.immersion.hapticmediasdk.a.c.q(a))
                {
                    com.immersion.hapticmediasdk.a.c.e(a, com.immersion.hapticmediasdk.a.c.g(a));
                    com.immersion.hapticmediasdk.a.c.f(a, com.immersion.hapticmediasdk.a.c.r(a));
                    com.immersion.hapticmediasdk.a.c.a(a, SystemClock.uptimeMillis());
                }
            }
            com.immersion.hapticmediasdk.a.c.b(a).post(com.immersion.hapticmediasdk.a.c.s(a));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }
}
