// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package bolts:
//            BoltsExecutors, CancellationTokenRegistration, CancellationToken

public class CancellationTokenSource
    implements Closeable
{

    private boolean cancellationRequested;
    private boolean closed;
    private final ScheduledExecutorService executor = BoltsExecutors.scheduled();
    private final Object lock = new Object();
    private final List registrations = new ArrayList();
    private ScheduledFuture scheduledCancellation;

    public CancellationTokenSource()
    {
    }

    private void cancelAfter(long l, TimeUnit timeunit)
    {
        if (l < -1L)
        {
            throw new IllegalArgumentException("Delay must be >= -1");
        }
        if (l == 0L)
        {
            cancel();
            return;
        }
        synchronized (lock)
        {
            if (!cancellationRequested)
            {
                break MISSING_BLOCK_LABEL_55;
            }
        }
        return;
        timeunit;
        obj;
        JVM INSTR monitorexit ;
        throw timeunit;
        cancelScheduledCancellation();
        if (l == -1L)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        scheduledCancellation = executor.schedule(new Runnable() {

            final CancellationTokenSource this$0;

            public void run()
            {
                synchronized (lock)
                {
                    scheduledCancellation = null;
                }
                cancel();
                return;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = CancellationTokenSource.this;
                super();
            }
        }, l, timeunit);
        obj;
        JVM INSTR monitorexit ;
    }

    private void cancelScheduledCancellation()
    {
        if (scheduledCancellation != null)
        {
            scheduledCancellation.cancel(true);
            scheduledCancellation = null;
        }
    }

    private void notifyListeners(List list)
    {
        for (list = list.iterator(); list.hasNext(); ((CancellationTokenRegistration)list.next()).runAction()) { }
    }

    private void throwIfClosed()
    {
        if (closed)
        {
            throw new IllegalStateException("Object already closed");
        } else
        {
            return;
        }
    }

    public void cancel()
    {
label0:
        {
            synchronized (lock)
            {
                throwIfClosed();
                if (!cancellationRequested)
                {
                    break label0;
                }
            }
            return;
        }
        ArrayList arraylist;
        cancelScheduledCancellation();
        cancellationRequested = true;
        arraylist = new ArrayList(registrations);
        obj;
        JVM INSTR monitorexit ;
        notifyListeners(arraylist);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancelAfter(long l)
    {
        cancelAfter(l, TimeUnit.MILLISECONDS);
    }

    public void close()
    {
label0:
        {
            synchronized (lock)
            {
                if (!closed)
                {
                    break label0;
                }
            }
            return;
        }
        cancelScheduledCancellation();
        for (Iterator iterator = registrations.iterator(); iterator.hasNext(); ((CancellationTokenRegistration)iterator.next()).close()) { }
        break MISSING_BLOCK_LABEL_60;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        registrations.clear();
        closed = true;
        obj;
        JVM INSTR monitorexit ;
    }

    public CancellationToken getToken()
    {
        CancellationToken cancellationtoken;
        synchronized (lock)
        {
            throwIfClosed();
            cancellationtoken = new CancellationToken(this);
        }
        return cancellationtoken;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isCancellationRequested()
    {
        boolean flag;
        synchronized (lock)
        {
            throwIfClosed();
            flag = cancellationRequested;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    CancellationTokenRegistration register(Runnable runnable)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        throwIfClosed();
        runnable = new CancellationTokenRegistration(this, runnable);
        if (!cancellationRequested)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        runnable.runAction();
_L2:
        return runnable;
        registrations.add(runnable);
        if (true) goto _L2; else goto _L1
_L1:
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    void throwIfCancellationRequested()
        throws CancellationException
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        throwIfClosed();
        if (cancellationRequested)
        {
            throw new CancellationException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public String toString()
    {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] {
            getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())
        });
    }

    void unregister(CancellationTokenRegistration cancellationtokenregistration)
    {
        synchronized (lock)
        {
            throwIfClosed();
            registrations.remove(cancellationtokenregistration);
        }
        return;
        cancellationtokenregistration;
        obj;
        JVM INSTR monitorexit ;
        throw cancellationtokenregistration;
    }



/*
    static ScheduledFuture access$102(CancellationTokenSource cancellationtokensource, ScheduledFuture scheduledfuture)
    {
        cancellationtokensource.scheduledCancellation = scheduledfuture;
        return scheduledfuture;
    }

*/
}
