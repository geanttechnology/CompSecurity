// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.jirbo.adcolony:
//            q

final class r
{
    static final class a extends Thread
    {

        Runnable a;

        public final void run()
        {
_L2:
            if (a != null)
            {
                try
                {
                    a.run();
                }
                catch (RuntimeException runtimeexception)
                {
                    q.d("Exception caught in reusable thread.");
                    q.d(String.valueOf(runtimeexception));
                    runtimeexception.printStackTrace();
                }
                a = null;
            }
            if (r.f)
            {
                return;
            }
            this;
            JVM INSTR monitorenter ;
            synchronized (r.a)
            {
                r.b.add(this);
            }
            try
            {
                wait();
            }
            catch (InterruptedException interruptedexception) { }
            this;
            JVM INSTR monitorexit ;
            if (true) goto _L2; else goto _L1
_L1:
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        a()
        {
        }
    }


    static String a = new String("mutex");
    static ArrayList b = new ArrayList();
    static ArrayList c = new ArrayList();
    static ArrayList d = new ArrayList();
    static ArrayList e = new ArrayList();
    static volatile boolean f;

    static void a()
    {
        String s = a;
        s;
        JVM INSTR monitorenter ;
        f = true;
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            synchronized ((a)iterator.next())
            {
                a1.notify();
            }
        }

        break MISSING_BLOCK_LABEL_57;
        exception3;
        a1;
        JVM INSTR monitorexit ;
        throw exception3;
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
        synchronized (a)
        {
            b.clear();
        }
        s;
        JVM INSTR monitorexit ;
        synchronized (a)
        {
            d.clear();
        }
        synchronized (a)
        {
            f = false;
            e.clear();
            e.addAll(d);
            d.clear();
            c.clear();
        }
        for (obj = e.iterator(); ((Iterator) (obj)).hasNext(); a((Runnable)((Iterator) (obj)).next())) { }
        break MISSING_BLOCK_LABEL_173;
        exception4;
        s1;
        JVM INSTR monitorexit ;
        throw exception4;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    static void a(Runnable runnable)
    {
label0:
        {
            synchronized (a)
            {
                if (!f)
                {
                    break label0;
                }
                d.add(runnable);
            }
            return;
        }
        int i = b.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = (a)b.remove(i - 1);
_L1:
        obj1;
        JVM INSTR monitorexit ;
        if (obj == null)
        {
            obj1 = new a();
            synchronized (a)
            {
                c.add(obj1);
            }
            obj1.a = runnable;
            ((a) (obj1)).start();
            return;
        }
        break MISSING_BLOCK_LABEL_97;
        runnable;
        obj1;
        JVM INSTR monitorexit ;
        throw runnable;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
        obj;
        JVM INSTR monitorenter ;
        obj.a = runnable;
        obj.notify();
        obj;
        JVM INSTR monitorexit ;
        return;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
        obj = null;
          goto _L1
    }

}
