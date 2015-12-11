// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            fs, hl, fq, ju, 
//            gq

public final class gd
{

    private int a;
    private int b;
    private ExecutorService c;
    private final Deque d = new ArrayDeque();
    private final Deque e = new ArrayDeque();
    private final Deque f = new ArrayDeque();

    public gd()
    {
        a = 64;
        b = 5;
    }

    private void b()
    {
_L2:
        return;
        if (e.size() < a && !d.isEmpty())
        {
            Iterator iterator = d.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                fs fs1 = (fs)iterator.next();
                if (c(fs1) < b)
                {
                    iterator.remove();
                    e.add(fs1);
                    a().execute(fs1);
                }
            } while (e.size() < a);
        }
          goto _L1
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int c(fs fs1)
    {
        Iterator iterator = e.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((fs)iterator.next()).a().equals(fs1.a()))
            {
                i++;
            }
        } while (true);
        return i;
    }

    public final ExecutorService a()
    {
        this;
        JVM INSTR monitorenter ;
        ExecutorService executorservice;
        if (c == null)
        {
            c = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), hl.a("OkHttp Dispatcher", false));
        }
        executorservice = c;
        this;
        JVM INSTR monitorexit ;
        return executorservice;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(fs fs1)
    {
        this;
        JVM INSTR monitorenter ;
        if (e.size() >= a || c(fs1) >= b) goto _L2; else goto _L1
_L1:
        e.add(fs1);
        a().execute(fs1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.add(fs1);
        if (true) goto _L4; else goto _L3
_L3:
        fs1;
        throw fs1;
    }

    public final void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            fs fs1 = (fs)iterator.next();
            if (hl.a(obj, fs1.b()))
            {
                fs1.a.a();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_57;
        obj;
        throw obj;
        Iterator iterator1 = e.iterator();
_L2:
        Object obj1;
        do
        {
            do
            {
                if (!iterator1.hasNext())
                {
                    break MISSING_BLOCK_LABEL_124;
                }
                obj1 = (fs)iterator1.next();
            } while (!hl.a(obj, ((fs) (obj1)).b()));
            ((fs) (obj1)).a.a = true;
            obj1 = ((fs) (obj1)).a.c;
        } while (obj1 == null);
        ((ju) (obj1)).h();
        if (true) goto _L2; else goto _L1
_L1:
        Iterator iterator2 = f.iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            fq fq1 = (fq)iterator2.next();
            if (hl.a(obj, fq1.b.g()))
            {
                fq1.a();
            }
        } while (true);
        this;
        JVM INSTR monitorexit ;
    }

    final void b(fs fs1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!e.remove(fs1))
        {
            throw new AssertionError("AsyncCall wasn't running!");
        }
        break MISSING_BLOCK_LABEL_30;
        fs1;
        this;
        JVM INSTR monitorexit ;
        throw fs1;
        b();
        this;
        JVM INSTR monitorexit ;
    }
}
