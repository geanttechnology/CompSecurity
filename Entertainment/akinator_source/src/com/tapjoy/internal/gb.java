// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.tapjoy.internal:
//            go, ga, gq, aa, 
//            hd, ck, hf

public final class gb
    implements Runnable
{

    final go a;
    ck b;
    private final Object c;
    private final Thread d = new Thread(this, "5Rocks");
    private boolean e;

    public gb(File file)
    {
        a = new go(file);
        c = a;
        a.a();
        d.start();
    }

    private void a(boolean flag)
    {
        synchronized (c)
        {
            e = flag;
            c.notify();
        }
    }

    public final void a()
    {
        if (b != null && !a.b())
        {
            a(true);
        }
    }

    public final void a(ck ck1)
    {
        b = ck1;
        a();
    }

    public final void a(gt.c c1)
    {
        try
        {
            a.a(c1);
        }
        // Misplaced declaration of an exception variable
        catch (gt.c c1)
        {
            return;
        }
        if (b != null)
        {
            if (ga.a || c1.f() != gt.i.c)
            {
                a(true);
                return;
            } else
            {
                a(false);
                return;
            }
        } else
        {
            a.flush();
            return;
        }
    }

    public final void run()
    {
        int i = 1;
_L10:
        long l = 0L;
_L6:
        if (b == null || a.a() <= 0 || l > 0L) goto _L2; else goto _L1
_L1:
        gt.c c1;
        Exception exception;
        hd hd1;
        int j;
        long l1;
        try
        {
            if (a.a() > 10000)
            {
                a.a(a.a() - 10000);
            }
            c1 = a.b(0);
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return;
        }
        if (c1 == null) goto _L2; else goto _L3
_L3:
        if (c1.w() && !c1.x().G())
        {
            gq.c.await(3L, TimeUnit.SECONDS);
        }
        if (!aa.c())
        {
            gq.b.await(3L, TimeUnit.SECONDS);
        }
        if (e || c1.f() == gt.i.a || a.a() >= 100 || c1.j() > System.currentTimeMillis())
        {
            break MISSING_BLOCK_LABEL_445;
        }
          goto _L4
_L9:
        l = l1;
        if (l1 > 0L) goto _L6; else goto _L5
_L5:
        hd1 = new hd();
        hd1.a(c1);
        j = 1;
_L8:
        if (j >= 100)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j >= a.a())
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = a.b(j);
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!hd1.a(c1))
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
        if (true) goto _L8; else goto _L7
_L4:
        l1 = Math.min(Math.max((c1.j() + 60000L) - System.currentTimeMillis(), 0L), 60000L);
          goto _L9
_L7:
        i++;
        hd1.c.f();
        b.a(hd1);
        a.a(hd1.c.f());
        hd1.c.f();
        i = 0;
        l = l1;
          goto _L6
        exception;
_L11:
        hd1.c.f();
        l = 0x493e0L;
          goto _L6
_L2:
        a.flush();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        synchronized (c)
        {
            e = false;
            c.wait(l);
        }
          goto _L10
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        synchronized (c)
        {
            e = false;
            if (b == null || a.b())
            {
                ck ck1 = b;
                c.wait();
            }
        }
          goto _L10
        exception2;
        obj1;
        JVM INSTR monitorexit ;
        throw exception2;
        obj1;
        i = 0;
          goto _L11
        l1 = 0L;
          goto _L9
    }

    // Unreferenced inner class com/tapjoy/internal/gb$1

/* anonymous class */
    final class _cls1 extends hf
    {

        final gb a;

        protected final boolean a()
        {
            return !a.a.b();
        }

            
            {
                a = gb.this;
                super();
            }
    }

}
