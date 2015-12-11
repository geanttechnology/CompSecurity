// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.a.a:
//            u, b, m, j, 
//            p, o

public class c extends Thread
{

    private static final boolean a;
    private final BlockingQueue b;
    private final BlockingQueue c;
    private final b d;
    private final p e;
    private volatile boolean f;

    public c(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, b b1, p p1)
    {
        f = false;
        b = blockingqueue;
        c = blockingqueue1;
        d = b1;
        e = p1;
    }

    static BlockingQueue a(c c1)
    {
        return c1.c;
    }

    public void a()
    {
        f = true;
        interrupt();
    }

    public void run()
    {
        if (a)
        {
            u.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        d.a();
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
                        obj = (m)b.take();
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
            } while (!f);
            return;
        }
        b.a a1 = d.a(((m) (obj)).getCacheKey());
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((m) (obj)).addMarker("cache-miss");
        c.put(obj);
          goto _L1
label1:
        {
            if (!a1.a())
            {
                break label1;
            }
            ((m) (obj)).addMarker("cache-hit-expired");
            ((m) (obj)).setCacheEntry(a1);
            c.put(obj);
        }
          goto _L1
        o o1;
label2:
        {
            ((m) (obj)).addMarker("cache-hit");
            o1 = ((m) (obj)).parseNetworkResponse(new j(a1.a, a1.g));
            ((m) (obj)).addMarker("cache-hit-parsed");
            if (a1.b())
            {
                break label2;
            }
            e.a(((m) (obj)), o1);
        }
          goto _L1
        ((m) (obj)).addMarker("cache-hit-refresh-needed");
        ((m) (obj)).setCacheEntry(a1);
        o1.d = true;
        e.a(((m) (obj)), o1, new Runnable(((m) (obj))) {

            final m a;
            final c b;

            public void run()
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
        a = u.b;
    }
}
