// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.AcceptableTerminalException;
import com.amazon.gallery.framework.network.exceptions.InvalidAuthTokenException;
import com.amazon.gallery.framework.network.exceptions.RetryLimitExceededException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.throttle.NetworkThrottle;
import com.amazon.gallery.framework.network.util.ExponentialBackoff;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

public static class backoff
    implements Callable
{

    private static ThreadLocal threadRetryAttempt = new ThreadLocal() {

        protected Integer initialValue()
        {
            return Integer.valueOf(0);
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };
    private final ExponentialBackoff backoff;
    private final _cls1.initialValue callable;
    private int localRetryAttempt;

    private Object retry(TransientException transientexception)
        throws TerminalException
    {
        GLogger.v(NetworkExecutor.access$000(), "Current attempt: %d - Current thread: %d", new Object[] {
            Integer.valueOf(localRetryAttempt), Long.valueOf(Thread.currentThread().getId())
        });
        if ((transientexception instanceof InvalidAuthTokenException) || transientexception.getStatusCode() >= 500 && transientexception.getStatusCode() < 600 || transientexception.getStatusCode() == 429)
        {
            long l = backoff.get(((Integer)threadRetryAttempt.get()).intValue());
            GLogger.d(NetworkExecutor.access$000(), "Backing off for %d ms", new Object[] {
                Long.valueOf(l)
            });
            SystemClock.sleep(l);
        }
        if (localRetryAttempt < backoff.getRetryLimit())
        {
            GLogger.i(NetworkExecutor.access$000(), "Retry limit not reached, retrying again.", new Object[0]);
            threadRetryAttempt.set(Integer.valueOf(((Integer)threadRetryAttempt.get()).intValue() + 1));
            localRetryAttempt = localRetryAttempt + 1;
            return call();
        } else
        {
            throw new RetryLimitExceededException(transientexception);
        }
    }

    public Object call()
        throws TerminalException
    {
        Object obj;
        long l;
        try
        {
            l = NetworkThrottle.getNetworkDelay();
        }
        catch (TransientException transientexception)
        {
            GLogger.w(NetworkExecutor.access$000(), "TransientException while executing operation, retrying: %s", new Object[] {
                transientexception.getMessage()
            });
            return retry(transientexception);
        }
        catch (AcceptableTerminalException acceptableterminalexception)
        {
            GLogger.w(NetworkExecutor.access$000(), "AcceptableTerminalException while executing operation: %s", new Object[] {
                acceptableterminalexception.getMessage()
            });
            throw acceptableterminalexception;
        }
        catch (TerminalException terminalexception)
        {
            GLogger.w(NetworkExecutor.access$000(), "TerminalException while executing operation: %s", new Object[] {
                terminalexception.getMessage()
            });
            throw terminalexception;
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        GLogger.v(NetworkExecutor.access$000(), "Applying network throttle to request %s, sleeping for %dms", new Object[] {
            callable.getClass().getName(), Long.valueOf(l)
        });
        SystemClock.sleep(l);
        obj = callable.callable();
        threadRetryAttempt.set(Integer.valueOf(0));
        return obj;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (threadRetryAttempt)obj;
            if (!callable.equals(((callable) (obj)).callable))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return callable.hashCode();
    }


    public _cls1(_cls1 _pcls1, ExponentialBackoff exponentialbackoff)
    {
        localRetryAttempt = 0;
        callable = _pcls1;
        backoff = exponentialbackoff;
    }
}
