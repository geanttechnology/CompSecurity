// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.io.Closeable;

// Referenced classes of package bolts:
//            CancellationTokenSource

public class CancellationTokenRegistration
    implements Closeable
{

    private Runnable action;
    private boolean closed;
    private final Object lock = new Object();
    private CancellationTokenSource tokenSource;

    CancellationTokenRegistration(CancellationTokenSource cancellationtokensource, Runnable runnable)
    {
        tokenSource = cancellationtokensource;
        action = runnable;
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
        closed = true;
        tokenSource.unregister(this);
        tokenSource = null;
        action = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void runAction()
    {
        synchronized (lock)
        {
            throwIfClosed();
            action.run();
            close();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
