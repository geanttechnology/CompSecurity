// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.jirbo.adcolony:
//            ao

class an
{

    static String a = new String("mutex");
    static ArrayList b = new ArrayList();
    static ArrayList c = new ArrayList();
    static ArrayList d = new ArrayList();
    static ArrayList e = new ArrayList();
    static volatile boolean f;

    static void a()
    {
        c();
        synchronized (a)
        {
            d.clear();
        }
        b();
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
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
        obj = (ao)b.remove(i - 1);
_L1:
        obj1;
        JVM INSTR monitorexit ;
        if (obj == null)
        {
            obj1 = new ao();
            synchronized (a)
            {
                c.add(obj1);
            }
            obj1.a = runnable;
            ((ao) (obj1)).start();
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

    static void b()
    {
        synchronized (a)
        {
            f = false;
            e.clear();
            e.addAll(d);
            d.clear();
            c.clear();
        }
        for (obj = e.iterator(); ((Iterator) (obj)).hasNext(); a((Runnable)((Iterator) (obj)).next())) { }
        break MISSING_BLOCK_LABEL_76;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void c()
    {
        String s = a;
        s;
        JVM INSTR monitorenter ;
        f = true;
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            synchronized ((ao)iterator.next())
            {
                ao1.notify();
            }
        }

        break MISSING_BLOCK_LABEL_57;
        exception1;
        ao1;
        JVM INSTR monitorexit ;
        throw exception1;
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
        return;
        exception2;
        s1;
        JVM INSTR monitorexit ;
        throw exception2;
    }

}
