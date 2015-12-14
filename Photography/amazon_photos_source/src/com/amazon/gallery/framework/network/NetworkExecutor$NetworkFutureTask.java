// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.AcceptableTerminalException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.util.ExponentialBackoff;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

public static class callback extends FutureTask
    implements callback
{

    private final operation callback;
    private final operation operation;
    private final long startTime = SystemClock.uptimeMillis();

    protected void done()
    {
        if (isCancelled())
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (callback != null)
        {
            callback.ccess(get());
        }
_L2:
        return;
        Object obj;
        obj;
        callback.ilure(new TerminalException(((Throwable) (obj))));
        return;
        obj;
        Throwable throwable = ((ExecutionException) (obj)).getCause();
        if (throwable instanceof AcceptableTerminalException)
        {
            GLogger.i(NetworkExecutor.access$000(), "Unable to complete network operation: %s", new Object[] {
                throwable.getMessage()
            });
        } else
        {
            GLogger.w(NetworkExecutor.access$000(), throwable.getMessage(), new Object[0]);
        }
        if (throwable instanceof TerminalException)
        {
            callback.ilure((TerminalException)throwable);
            return;
        } else
        {
            callback.ilure(new TerminalException(throwable));
            return;
        }
        throwable;
        GLogger.exf(NetworkExecutor.access$000(), throwable, throwable.getMessage(), new Object[0]);
        if (callback == null) goto _L2; else goto _L1
_L1:
        callback.ilure(new TerminalException(throwable));
        return;
        GLogger.d(NetworkExecutor.access$000(), "Network operation cancelled before completing", new Object[0]);
        if (callback != null)
        {
            callback.ilure(new TerminalException("request cancelled"));
            return;
        }
          goto _L2
    }

    public > getOperation()
    {
        return operation;
    }

    public void run()
    {
        GLogger.t(NetworkExecutor.access$000(), startTime, "Started network task %s after waiting: ", new Object[] {
            operation.toString()
        });
        super.run();
    }

    public void setException(Throwable throwable)
    {
        super.setException(throwable);
    }

    public String toString()
    {
        return operation.toString();
    }

    public tion(tion tion, tion tion1, ExponentialBackoff exponentialbackoff)
    {
        super(new rationExecutor(tion, exponentialbackoff));
        operation = tion;
        callback = tion1;
    }
}
