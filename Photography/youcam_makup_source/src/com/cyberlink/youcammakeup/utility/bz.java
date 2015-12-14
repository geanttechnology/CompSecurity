// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            by, bx, bw, bv

public class bz
    implements by, Runnable, Future
{

    final bv a;
    private bx b;
    private bw c;
    private Object d;
    private boolean e;
    private boolean f;

    public bz(bv bv, bx bx1)
    {
        a = bv;
        super();
        d = null;
        e = false;
        f = false;
        c = null;
        b = bx1;
    }

    public bz(bv bv, bx bx1, bw bw1)
    {
        a = bv;
        super();
        d = null;
        e = false;
        f = false;
        c = null;
        b = bx1;
        c = bw1;
    }

    public boolean cancel(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        f = true;
        this;
        JVM INSTR monitorexit ;
        return f;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object get()
    {
        while (!e) 
        {
            try
            {
                wait();
            }
            catch (Exception exception)
            {
                m.a("ThreadPool", "ingore exception", exception);
            }
        }
        return d;
    }

    public Object get(long l, TimeUnit timeunit)
    {
        return null;
    }

    public boolean isCancelled()
    {
        return f;
    }

    public boolean isDone()
    {
        return e;
    }

    public void run()
    {
        d = b.b(this);
        this;
        JVM INSTR monitorenter ;
        e = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (c != null)
        {
            c.a(this);
        }
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
