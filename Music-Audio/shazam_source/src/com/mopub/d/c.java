// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.mopub.d:
//            t, b, l, i, 
//            o, n

public final class c extends Thread
{

    private static final boolean b;
    volatile boolean a;
    private final BlockingQueue c;
    private final BlockingQueue d;
    private final b e;
    private final o f;

    public c(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, b b1, o o1)
    {
        a = false;
        c = blockingqueue;
        d = blockingqueue1;
        e = b1;
        f = o1;
    }

    static BlockingQueue a(c c1)
    {
        return c1.d;
    }

    public final void run()
    {
        if (b)
        {
            t.a("start new dispatcher", new Object[0]);
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
                        obj = (l)c.take();
                        ((l) (obj)).a("cache-queue-take");
                        if (!((l) (obj)).h)
                        {
                            break label0;
                        }
                        ((l) (obj)).b("cache-discard-canceled");
                    } while (true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } while (!a);
            return;
        }
        b.a a1 = e.a(((l) (obj)).b);
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((l) (obj)).a("cache-miss");
        d.put(obj);
          goto _L1
        boolean flag;
        n n1;
        if (a1.d < System.currentTimeMillis())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        ((l) (obj)).a("cache-hit-expired");
        obj.k = a1;
        d.put(obj);
          goto _L1
        ((l) (obj)).a("cache-hit");
        n1 = ((l) (obj)).a(new i(a1.a, a1.f));
        ((l) (obj)).a("cache-hit-parsed");
        if (a1.e < System.currentTimeMillis())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        f.a(((l) (obj)), n1);
          goto _L1
        ((l) (obj)).a("cache-hit-refresh-needed");
        obj.k = a1;
        n1.d = true;
        f.a(((l) (obj)), n1, new Runnable(((l) (obj))) {

            final l a;
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
                a = l1;
                super();
            }
        });
          goto _L1
    }

    static 
    {
        b = t.b;
    }
}
