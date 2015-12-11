// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package android.support.v7:
//            yd, mo, ve, tv, 
//            vy, vw

public class np extends Thread
{

    private static final boolean a;
    private final BlockingQueue b;
    private final BlockingQueue c;
    private final mo d;
    private final vy e;
    private volatile boolean f;

    public np(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, mo mo1, vy vy1)
    {
        f = false;
        b = blockingqueue;
        c = blockingqueue1;
        d = mo1;
        e = vy1;
    }

    static BlockingQueue a(np np1)
    {
        return np1.c;
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
            yd.a("start new dispatcher", new Object[0]);
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
                        obj = (ve)b.take();
                        ((ve) (obj)).b("cache-queue-take");
                        if (!((ve) (obj)).g())
                        {
                            break label0;
                        }
                        ((ve) (obj)).c("cache-discard-canceled");
                    } while (true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } while (!f);
            return;
        }
        mo.a a1 = d.a(((ve) (obj)).e());
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((ve) (obj)).b("cache-miss");
        c.put(obj);
          goto _L1
label1:
        {
            if (!a1.a())
            {
                break label1;
            }
            ((ve) (obj)).b("cache-hit-expired");
            ((ve) (obj)).a(a1);
            c.put(obj);
        }
          goto _L1
        vw vw1;
label2:
        {
            ((ve) (obj)).b("cache-hit");
            vw1 = ((ve) (obj)).a(new tv(a1.a, a1.g));
            ((ve) (obj)).b("cache-hit-parsed");
            if (a1.b())
            {
                break label2;
            }
            e.a(((ve) (obj)), vw1);
        }
          goto _L1
        ((ve) (obj)).b("cache-hit-refresh-needed");
        ((ve) (obj)).a(a1);
        vw1.d = true;
        e.a(((ve) (obj)), vw1, new Runnable(((ve) (obj))) {

            final ve a;
            final np b;

            public void run()
            {
                try
                {
                    np.a(b).put(a);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
            }

            
            {
                b = np.this;
                a = ve1;
                super();
            }
        });
          goto _L1
    }

    static 
    {
        a = yd.b;
    }
}
