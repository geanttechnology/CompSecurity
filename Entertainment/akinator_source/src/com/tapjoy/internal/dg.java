// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

// Referenced classes of package com.tapjoy.internal:
//            dj, di, cv

public abstract class dg
    implements dj
{
    static final class a extends AbstractQueuedSynchronizer
    {

        private Object a;
        private Throwable b;

        private boolean a(Object obj, Throwable throwable, int i)
        {
            boolean flag = compareAndSetState(0, 1);
            if (flag)
            {
                a = obj;
                b = throwable;
                releaseShared(i);
            } else
            if (getState() == 1)
            {
                acquireShared(-1);
                return flag;
            }
            return flag;
        }

        private Object e()
        {
            int i = getState();
            switch (i)
            {
            case 3: // '\003'
            default:
                throw new IllegalStateException((new StringBuilder("Error, synchronizer in invalid state: ")).append(i).toString());

            case 2: // '\002'
                if (b != null)
                {
                    throw new ExecutionException(b);
                } else
                {
                    return a;
                }

            case 4: // '\004'
                throw new CancellationException("Task was cancelled.");
            }
        }

        final Object a()
        {
            acquireSharedInterruptibly(-1);
            return e();
        }

        final Object a(long l)
        {
            if (!tryAcquireSharedNanos(-1, l))
            {
                throw new TimeoutException("Timeout waiting for task.");
            } else
            {
                return e();
            }
        }

        final boolean a(Object obj)
        {
            return a(obj, null, 2);
        }

        final boolean a(Throwable throwable)
        {
            return a(null, throwable, 2);
        }

        final boolean b()
        {
            return (getState() & 6) != 0;
        }

        final boolean c()
        {
            return getState() == 4;
        }

        final boolean d()
        {
            return a(null, null, 4);
        }

        protected final int tryAcquireShared(int i)
        {
            return !b() ? -1 : 1;
        }

        protected final boolean tryReleaseShared(int i)
        {
            setState(i);
            return true;
        }

        a()
        {
        }
    }


    private final a a = new a();
    private final di b = new di();

    public dg()
    {
    }

    protected final boolean a(Object obj)
    {
        boolean flag = a.a(obj);
        if (flag)
        {
            b.a();
        }
        return flag;
    }

    protected final boolean a(Throwable throwable)
    {
        boolean flag = a.a((Throwable)cv.a(throwable));
        if (flag)
        {
            b.a();
        }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        } else
        {
            return flag;
        }
    }

    public boolean cancel(boolean flag)
    {
        if (!a.d())
        {
            return false;
        } else
        {
            b.a();
            return true;
        }
    }

    public Object get()
    {
        return a.a();
    }

    public Object get(long l, TimeUnit timeunit)
    {
        return a.a(timeunit.toNanos(l));
    }

    public boolean isCancelled()
    {
        return a.c();
    }

    public boolean isDone()
    {
        return a.b();
    }
}
