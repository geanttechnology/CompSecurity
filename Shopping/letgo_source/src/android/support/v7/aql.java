// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class aql
{

    public static final aql NONE = new aql() {

        public aql deadlineNanoTime(long l)
        {
            return this;
        }

        public void throwIfReached()
            throws IOException
        {
        }

        public aql timeout(long l, TimeUnit timeunit)
        {
            return this;
        }

    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public aql()
    {
    }

    public aql clearDeadline()
    {
        hasDeadline = false;
        return this;
    }

    public aql clearTimeout()
    {
        timeoutNanos = 0L;
        return this;
    }

    public final aql deadline(long l, TimeUnit timeunit)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("duration <= 0: ").append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            return deadlineNanoTime(System.nanoTime() + timeunit.toNanos(l));
        }
    }

    public long deadlineNanoTime()
    {
        if (!hasDeadline)
        {
            throw new IllegalStateException("No deadline");
        } else
        {
            return deadlineNanoTime;
        }
    }

    public aql deadlineNanoTime(long l)
    {
        hasDeadline = true;
        deadlineNanoTime = l;
        return this;
    }

    public boolean hasDeadline()
    {
        return hasDeadline;
    }

    public void throwIfReached()
        throws IOException
    {
        if (Thread.interrupted())
        {
            throw new InterruptedIOException();
        }
        if (hasDeadline && System.nanoTime() > deadlineNanoTime)
        {
            throw new IOException("deadline reached");
        } else
        {
            return;
        }
    }

    public aql timeout(long l, TimeUnit timeunit)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("timeout < 0: ").append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            timeoutNanos = timeunit.toNanos(l);
            return this;
        }
    }

    public long timeoutNanos()
    {
        return timeoutNanos;
    }

}
