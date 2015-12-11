// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.tapjoy.internal:
//            dk, cv, dj, dg

public abstract class dh
    implements dk
{
    final class a extends dg
    {

        final dh a;

        private dk.a a(long l, TimeUnit timeunit)
        {
            try
            {
                timeunit = (dk.a)super.get(l, timeunit);
            }
            // Misplaced declaration of an exception variable
            catch (TimeUnit timeunit)
            {
                throw new TimeoutException(a.toString());
            }
            return timeunit;
        }

        public final Object get(long l, TimeUnit timeunit)
        {
            return a(l, timeunit);
        }

        private a()
        {
            a = dh.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final ReentrantLock a = new ReentrantLock();
    private final a b = new a((byte)0);
    private final a c = new a((byte)0);
    private dk.a d;
    private boolean e;

    public dh()
    {
        d = dk.a.a;
        e = false;
    }

    private dj e()
    {
        a.lock();
        if (d != dk.a.a) goto _L2; else goto _L1
_L1:
        d = dk.a.e;
        b.a(dk.a.e);
        c.a(dk.a.e);
_L5:
        a.unlock();
_L6:
        return c;
_L2:
        if (d != dk.a.b) goto _L4; else goto _L3
_L3:
        e = true;
        b.a(dk.a.d);
          goto _L5
        Object obj;
        obj;
        a(((Throwable) (obj)));
        a.unlock();
          goto _L6
_L4:
        if (d != dk.a.c) goto _L5; else goto _L7
_L7:
        d = dk.a.d;
        b();
          goto _L5
        obj;
        a.unlock();
        throw obj;
    }

    protected abstract void a();

    protected final void a(Throwable throwable)
    {
        cv.a(throwable);
        a.lock();
        if (d != dk.a.b) goto _L2; else goto _L1
_L1:
        b.a(throwable);
        c.a(new Exception("Service failed to start.", throwable));
_L3:
        d = dk.a.f;
        a.unlock();
        return;
_L2:
        if (d != dk.a.d)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        c.a(throwable);
          goto _L3
        throwable;
        a.unlock();
        throw throwable;
        if (d != dk.a.c)
        {
            continue; /* Loop/switch isn't completed */
        }
        c.a(new Exception("Service failed while running", throwable));
          goto _L3
        if (d != dk.a.a && d != dk.a.e) goto _L3; else goto _L4
_L4:
        throw new IllegalStateException((new StringBuilder("Failed while in state:")).append(d).toString(), throwable);
    }

    protected abstract void b();

    protected final void c()
    {
        a.lock();
        if (d != dk.a.b)
        {
            IllegalStateException illegalstateexception = new IllegalStateException((new StringBuilder("Cannot notifyStarted() when the service is ")).append(d).toString());
            a(illegalstateexception);
            throw illegalstateexception;
        }
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
        d = dk.a.c;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        e();
_L1:
        a.unlock();
        return;
        b.a(dk.a.c);
          goto _L1
    }

    protected final void d()
    {
        a.lock();
        if (d != dk.a.d && d != dk.a.c)
        {
            IllegalStateException illegalstateexception = new IllegalStateException((new StringBuilder("Cannot notifyStopped() when the service is ")).append(d).toString());
            a(illegalstateexception);
            throw illegalstateexception;
        }
        break MISSING_BLOCK_LABEL_71;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
        d = dk.a.e;
        c.a(dk.a.e);
        a.unlock();
        return;
    }

    public final dj f()
    {
        a.lock();
        if (d == dk.a.a)
        {
            d = dk.a.b;
            a();
        }
        a.unlock();
_L2:
        return b;
        Object obj;
        obj;
        a(((Throwable) (obj)));
        a.unlock();
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        a.unlock();
        throw obj;
    }

    public final dk.a g()
    {
        a.lock();
        dk.a a1;
        if (!e || d != dk.a.b)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        a1 = dk.a.d;
        a.unlock();
        return a1;
        a1 = d;
        a.unlock();
        return a1;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" [").append(g()).append("]").toString();
    }
}
