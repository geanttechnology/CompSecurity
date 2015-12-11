// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.moodmedia.moodpresence:
//            f, b, d, g

class e
    implements Runnable
{

    private static final int b[];
    private static int f = com.moodmedia.moodpresence.f.b();
    private static long g;
    private static long h;
    private b a[];
    private BlockingQueue c;
    private BlockingQueue d;
    private boolean e;

    e(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, boolean flag)
    {
        a = new b[2];
        e = false;
        a(blockingqueue, blockingqueue1, flag);
    }

    void a(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, boolean flag)
    {
        c = blockingqueue;
        d = blockingqueue1;
        e = flag;
        int i = 0;
        do
        {
            if (i >= 2)
            {
                return;
            }
            a[i] = new b(b[i]);
            i++;
        } while (true);
    }

    public final void run()
    {
_L8:
        Object obj;
        b.a a1;
        int i;
        long l;
        long l1;
        long l2;
        try
        {
            if (Thread.currentThread().isInterrupted())
            {
                return;
            }
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
            return;
        }
        obj = (d)c.take();
        l = ((d) (obj)).a();
        obj = ((d) (obj)).b();
        a1 = a[((g.a) (obj)).a()].a(l);
        l1 = a1.a();
        l = l1;
        if (l1 == -1L)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        l = l1;
        if (obj == g.a.a)
        {
            l = l1;
            if ((0x7fff000000000000L & l1) != 0L)
            {
                l = -1L;
            }
        }
        l1 = l;
        if (l == -1L) goto _L2; else goto _L1
_L1:
        l1 = l;
        if (obj != g.a.b) goto _L2; else goto _L3
_L3:
        l2 = 0L;
        i = 0;
        l1 = l;
_L9:
        if (i < f) goto _L5; else goto _L4
_L4:
        l1 = l;
_L2:
        a1.a(l1);
        l = a1.c();
        if (l != -1L) goto _L7; else goto _L6
_L6:
        if (!e) goto _L8; else goto _L7
_L7:
        obj = new g(l, ((g.a) (obj)), a1.b());
        d.offer(obj, 1000L, TimeUnit.MILLISECONDS);
          goto _L8
_L5:
        long l3;
        l3 = l;
        if (l1 + l2 < l)
        {
            l3 = l1 + l2;
        }
        l2 = (l2 >>> (int)g) + ((h & l1) << (int)(g * (long)(f - 1)));
        l = g;
        l1 >>>= (int)l;
        i++;
        l = l3;
          goto _L9
    }

    static 
    {
        int ai[] = new int[2];
        b = ai;
        ai[g.a.b.a()] = 6;
        b[g.a.a.a()] = 4;
        g = com.moodmedia.moodpresence.f.a();
        h = 0L;
        int i = 0;
        do
        {
            if ((long)i >= g)
            {
                return;
            }
            h += 1L << i;
            i++;
        } while (true);
    }
}
