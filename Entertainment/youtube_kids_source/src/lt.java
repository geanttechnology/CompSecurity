// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class lt extends Thread
{

    private static final boolean b;
    volatile boolean a;
    private final BlockingQueue c;
    private final BlockingQueue d;
    private final lr e;
    private final ml f;

    public lt(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, lr lr1, ml ml1)
    {
        a = false;
        c = blockingqueue;
        d = blockingqueue1;
        e = lr1;
        f = ml1;
    }

    static BlockingQueue a(lt lt1)
    {
        return lt1.d;
    }

    public final void run()
    {
        if (b)
        {
            mq.a("start new dispatcher", new Object[0]);
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
                        obj = (me)c.take();
                        ((me) (obj)).a("cache-queue-take");
                        if (!((me) (obj)).f)
                        {
                            break label0;
                        }
                        ((me) (obj)).b("cache-discard-canceled");
                    } while (true);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } while (!a);
            return;
        }
        ls ls1 = e.a(((me) (obj)).b());
        if (ls1 != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        ((me) (obj)).a("cache-miss");
        d.put(obj);
          goto _L1
        boolean flag;
        mi mi1;
        if (ls1.d < System.currentTimeMillis())
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
        ((me) (obj)).a("cache-hit-expired");
        obj.i = ls1;
        d.put(obj);
          goto _L1
        ((me) (obj)).a("cache-hit");
        mi1 = ((me) (obj)).a(new mb(ls1.a, ls1.f));
        ((me) (obj)).a("cache-hit-parsed");
        if (ls1.e < System.currentTimeMillis())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        f.a(((me) (obj)), mi1);
          goto _L1
        ((me) (obj)).a("cache-hit-refresh-needed");
        obj.i = ls1;
        mi1.d = true;
        f.a(((me) (obj)), mi1, new lu(this, ((me) (obj))));
          goto _L1
    }

    static 
    {
        b = mq.a;
    }
}
