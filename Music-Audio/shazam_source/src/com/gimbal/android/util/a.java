// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.android.util;

import java.util.concurrent.atomic.AtomicBoolean;
import org.b.b;
import org.b.c;

public abstract class a
    implements Runnable
{

    private static final b a = org.b.c.a(com/gimbal/android/util/a);
    private Thread b;
    private AtomicBoolean c;

    public a()
    {
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        AtomicBoolean atomicboolean;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        atomicboolean = c;
        if (atomicboolean != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        c = new AtomicBoolean(false);
        b = new Thread(this, c());
        b.start();
        a.a("Started: {}", c());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a.b("Start failed", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    public abstract void a(AtomicBoolean atomicboolean);

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null && c != null && !c.get())
        {
            c.set(true);
            b.interrupt();
            b = null;
            c = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract String c();

    public void run()
    {
        Object obj;
        try
        {
            obj = c;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.b("Failed (to start)", ((Throwable) (obj)));
            return;
        }
        a(((AtomicBoolean) (obj)));
        this;
        JVM INSTR monitorenter ;
        if (c == obj)
        {
            b = null;
            c = null;
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        Object obj1;
        obj1;
        a.a("Stopping - Interrupted");
        this;
        JVM INSTR monitorenter ;
        if (c == obj)
        {
            b = null;
            c = null;
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        a.a("Stopping", ((Throwable) (obj1)));
        this;
        JVM INSTR monitorenter ;
        if (c == obj)
        {
            b = null;
            c = null;
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        this;
        JVM INSTR monitorenter ;
        if (c == obj)
        {
            b = null;
            c = null;
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
