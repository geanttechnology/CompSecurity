// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.a.a:
//            u, b, m, j, 
//            p, o

public final class c extends Thread
{

    private static final boolean b;
    volatile boolean a;
    private final BlockingQueue c;
    private final BlockingQueue d;
    private final b e;
    private final p f;

    public c(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, b b1, p p1)
    {
        a = false;
        c = blockingqueue;
        d = blockingqueue1;
        e = b1;
        f = p1;
    }

    static BlockingQueue a(c c1)
    {
        return c1.d;
    }

    public final void run()
    {
        if (b)
        {
            u.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        e.a();
_L1:
        Object obj;
label0:
        {
            do
            {
                try
                {
                    do
                    {
                        obj = (m)c.take();
                        ((m) (obj)).addMarker("cache-queue-take");
                        if (!((m) (obj)).isCanceled())
                        {
                            break label0;
                        }
                        ((m) (obj)).finish("cache-discard-canceled");
                    } while (true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } while (!a);
            return;
        }
        b.a a1 = e.a(((m) (obj)).getCacheKey());
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((m) (obj)).addMarker("cache-miss");
        d.put(obj);
          goto _L1
        boolean flag;
        o o1;
        if (a1.e < System.currentTimeMillis())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        ((m) (obj)).addMarker("cache-hit-expired");
        ((m) (obj)).setCacheEntry(a1);
        d.put(obj);
          goto _L1
        ((m) (obj)).addMarker("cache-hit");
        o1 = ((m) (obj)).parseNetworkResponse(new j(a1.a, a1.g));
        ((m) (obj)).addMarker("cache-hit-parsed");
        if (a1.f < System.currentTimeMillis())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        f.a(((m) (obj)), o1);
          goto _L1
        ((m) (obj)).addMarker("cache-hit-refresh-needed");
        ((m) (obj)).setCacheEntry(a1);
        o1.d = true;
        f.a(((m) (obj)), o1, new Runnable(((m) (obj))) {

            final m a;
            final c b;

            public final void run()
            {
                try
                {
                    c.a(b).put(a);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
            }

            
            {
                b = c.this;
                a = m1;
                super();
            }
        });
          goto _L1
    }

    static 
    {
        b = u.b;
    }
}
