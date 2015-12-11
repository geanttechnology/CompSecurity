// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class dai
{

    private final long a;

    public dai(long l)
    {
        a = SystemClock.elapsedRealtime() + l;
    }

    public final Object a(Future future)
    {
        try
        {
            future = ((Future) (future.get(Math.max(0L, a - SystemClock.elapsedRealtime()), TimeUnit.MILLISECONDS)));
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            Thread.currentThread().interrupt();
            throw new IOException(future);
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            throw new IOException(future);
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            throw new IOException("Timed out waiting for task :", future);
        }
        return future;
    }
}
