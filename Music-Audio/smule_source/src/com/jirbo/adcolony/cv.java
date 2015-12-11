// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import java.io.PrintStream;

// Referenced classes of package com.jirbo.adcolony:
//            ak, bl, be, q, 
//            an, dd

class cv
    implements Runnable
{

    static String a = "MONITOR_MUTEX";
    static volatile cv b;
    static volatile long c;

    cv()
    {
    }

    static void a()
    {
        synchronized (a)
        {
            c = System.currentTimeMillis();
            if (b == null)
            {
                ak.b("Creating ADC Monitor singleton.");
                b = new cv();
                (new Thread(b)).start();
            }
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(long l)
    {
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    public void run()
    {
        boolean flag1;
        ak.a(ak.e);
        bl.a.b("ADC Monitor Started.");
        ak.c.b();
        flag1 = false;
_L9:
        if (q.d().isFinishing()) goto _L2; else goto _L1
_L1:
        int j;
        long l;
        long l1;
        l1 = System.currentTimeMillis();
        ak.i = false;
        ak.c.g();
        if (ak.i)
        {
            l = 50L;
        } else
        {
            int i;
            if (flag1)
            {
                i = 2000;
            } else
            {
                i = 250;
            }
            l = i;
        }
        j = (int)((System.currentTimeMillis() - c) / 1000L);
        ak.c.g();
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (j < 10) goto _L5; else goto _L2
_L2:
        synchronized (a)
        {
            b = null;
        }
        if (!flag1)
        {
            ak.c.c();
        }
        if (q.d().isFinishing())
        {
            ak.x = null;
            ak.j = true;
            a(5000L);
            if (ak.j)
            {
                bl.c.b("ADC.finishing, controller on_stop");
                ak.c.d();
                an.a();
            }
        }
        System.out.println("Exiting monitor");
        return;
_L5:
        boolean flag;
        flag = flag1;
        if (j < 5)
        {
            ak.c.b();
            ak.b("AdColony is active.");
            flag = false;
        }
_L7:
        a(l);
        l = System.currentTimeMillis();
        flag1 = flag;
        if (l - l1 <= 3000L)
        {
            flag1 = flag;
            if (l - l1 > 0L)
            {
                obj = ak.c.e;
                double d = ((dd) (obj)).h;
                obj.h = (double)(l - l1) / 1000D + d;
                flag1 = flag;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        if (j >= 5)
        {
            ak.b("AdColony is idle.");
            ak.c.c();
            flag = true;
        }
        if (true) goto _L7; else goto _L6
_L6:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
