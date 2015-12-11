// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.io.PrintStream;

// Referenced classes of package com.jirbo.adcolony:
//            q, aj, ac, as, 
//            r

final class an
    implements Runnable
{
    static final class a extends Handler
    {

        public final void handleMessage(Message message)
        {
            if (q.x == null || q.b().isFinishing())
            {
                q.b("Monitor pinger exiting.");
                return;
            }
            if (q.b().hasWindowFocus())
            {
                an.a();
            }
            sendMessageDelayed(obtainMessage(), 1000L);
        }

        a()
        {
            sendMessageDelayed(obtainMessage(), 1000L);
        }
    }


    static String a = "MONITOR_MUTEX";
    static volatile an b;
    static volatile long c;

    an()
    {
    }

    static void a()
    {
        synchronized (a)
        {
            c = System.currentTimeMillis();
            if (b == null)
            {
                q.b("Creating ADC Monitor singleton.");
                b = new an();
                (new Thread(b)).start();
            }
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void run()
    {
        boolean flag;
        q.a(q.e);
        aj.a.b("ADC Monitor Started.");
        q.c.a();
        flag = false;
_L2:
        if (q.x == null || q.b().isFinishing())
        {
            break MISSING_BLOCK_LABEL_249;
        }
        long l1 = System.currentTimeMillis();
        q.i = false;
        q.c.e();
        int i;
        int j;
        long l;
        if (q.i)
        {
            l = 50L;
        } else
        {
            if (flag)
            {
                i = 2000;
            } else
            {
                i = 250;
            }
            l = i;
        }
        j = (int)((System.currentTimeMillis() - c) / 1000L);
        q.c.e();
        if (flag)
        {
            if (j >= 10)
            {
                break MISSING_BLOCK_LABEL_249;
            }
            i = ((flag) ? 1 : 0);
            if (j < 5)
            {
                q.c.a();
                q.b("AdColony is active.");
                i = 0;
            }
        } else
        {
            i = ((flag) ? 1 : 0);
            if (j >= 5)
            {
                q.b("AdColony is idle.");
                q.c.b();
                i = 1;
            }
        }
        try
        {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedexception) { }
        l = System.currentTimeMillis();
        flag = i;
        if (l - l1 <= 3000L)
        {
            flag = i;
            if (l - l1 > 0L)
            {
                as as1 = q.c.e;
                double d = as1.h;
                as1.h = (double)(l - l1) / 1000D + d;
                flag = i;
            }
        }
        continue; /* Loop/switch isn't completed */
        synchronized (a)
        {
            b = null;
        }
        if (!flag)
        {
            q.c.b();
        }
        if (q.x != null && q.b().isFinishing())
        {
            q.x = null;
            q.j = true;
            try
            {
                Thread.sleep(5000L);
            }
            catch (InterruptedException interruptedexception1) { }
            if (q.j)
            {
                aj.c.b("ADC.finishing, controller on_stop");
                obj = q.c;
                new ac._cls3(((ac) (obj)), ((ac) (obj)));
                r.a();
            }
        }
        System.out.println("Exiting monitor");
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
