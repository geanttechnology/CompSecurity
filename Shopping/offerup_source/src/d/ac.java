// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package d:
//            ad

public class ac
{

    public static final ac NONE = new ad();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public ac()
    {
    }

    public ac clearDeadline()
    {
        hasDeadline = false;
        return this;
    }

    public ac clearTimeout()
    {
        timeoutNanos = 0L;
        return this;
    }

    public final ac deadline(long l, TimeUnit timeunit)
    {
        if (l <= 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("duration <= 0: ")).append(l).toString());
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

    public ac deadlineNanoTime(long l)
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

    public ac timeout(long l, TimeUnit timeunit)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("timeout < 0: ")).append(l).toString());
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
