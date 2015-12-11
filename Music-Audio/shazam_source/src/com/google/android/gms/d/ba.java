// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.google.android.gms.d:
//            lf, z, hx, gs, 
//            iu, is

public final class ba extends Thread
{

    private static final boolean b;
    volatile boolean a;
    private final BlockingQueue c;
    private final BlockingQueue d;
    private final z e;
    private final iu f;

    public ba(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, z z1, iu iu1)
    {
        a = false;
        c = blockingqueue;
        d = blockingqueue1;
        e = z1;
        f = iu1;
    }

    static BlockingQueue a(ba ba1)
    {
        return ba1.d;
    }

    public final void run()
    {
        if (b)
        {
            lf.a("start new dispatcher", new Object[0]);
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
                        obj = (hx)c.take();
                        ((hx) (obj)).a("cache-queue-take");
                        if (!((hx) (obj)).j)
                        {
                            break label0;
                        }
                        ((hx) (obj)).b("cache-discard-canceled");
                    } while (true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } while (!a);
            return;
        }
        z.a a1 = e.a(((hx) (obj)).d);
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((hx) (obj)).a("cache-miss");
        d.put(obj);
          goto _L1
        boolean flag;
        is is1;
        if (a1.e < System.currentTimeMillis())
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
        ((hx) (obj)).a("cache-hit-expired");
        obj.m = a1;
        d.put(obj);
          goto _L1
        ((hx) (obj)).a("cache-hit");
        is1 = ((hx) (obj)).a(new gs(a1.a, a1.g));
        ((hx) (obj)).a("cache-hit-parsed");
        if (a1.f < System.currentTimeMillis())
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
        f.a(((hx) (obj)), is1);
          goto _L1
        ((hx) (obj)).a("cache-hit-refresh-needed");
        obj.m = a1;
        is1.d = true;
        f.a(((hx) (obj)), is1, new Runnable(((hx) (obj))) {

            final hx a;
            final ba b;

            public final void run()
            {
                try
                {
                    ba.a(b).put(a);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
            }

            
            {
                b = ba.this;
                a = hx1;
                super();
            }
        });
          goto _L1
    }

    static 
    {
        b = lf.b;
    }
}
