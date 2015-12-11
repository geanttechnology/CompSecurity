// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.common.cache:
//            LocalCache, CacheLoader

static class oldValue
    implements oldValue
{

    final SettableFuture futureValue;
    volatile futureValue oldValue;
    final Stopwatch stopwatch;

    private ListenableFuture fullyFailedFuture(Throwable throwable)
    {
        SettableFuture settablefuture = SettableFuture.create();
        setException(settablefuture, throwable);
        return settablefuture;
    }

    private static boolean setException(SettableFuture settablefuture, Throwable throwable)
    {
        boolean flag;
        try
        {
            flag = settablefuture.setException(throwable);
        }
        // Misplaced declaration of an exception variable
        catch (SettableFuture settablefuture)
        {
            return false;
        }
        return flag;
    }

    public tion copyFor(ReferenceQueue referencequeue, tion tion)
    {
        return this;
    }

    public long elapsedNanos()
    {
        return stopwatch.elapsedTime(TimeUnit.NANOSECONDS);
    }

    public Object get()
    {
        return oldValue.oldValue();
    }

    public oldValue getEntry()
    {
        return null;
    }

    public oldValue getOldValue()
    {
        return oldValue;
    }

    public int getWeight()
    {
        return oldValue.ht();
    }

    public boolean isActive()
    {
        return oldValue.e();
    }

    public boolean isLoading()
    {
        return true;
    }

    public ListenableFuture loadFuture(Object obj, CacheLoader cacheloader)
    {
        Object obj1;
        stopwatch.start();
        obj1 = oldValue.oldValue();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj = cacheloader.load(obj);
        if (set(obj))
        {
            return futureValue;
        } else
        {
            return Futures.immediateFuture(obj);
        }
        obj = cacheloader.reload(obj, obj1);
        if (obj == null)
        {
            try
            {
                obj = Futures.immediateFuture(null);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (setException(((Throwable) (obj))))
                {
                    return futureValue;
                } else
                {
                    return fullyFailedFuture(((Throwable) (obj)));
                }
            }
        }
        return ((ListenableFuture) (obj));
    }

    public void notifyNewValue(Object obj)
    {
        if (obj != null)
        {
            set(obj);
            return;
        } else
        {
            oldValue = LocalCache.unset();
            return;
        }
    }

    public boolean set(Object obj)
    {
        return futureValue.set(obj);
    }

    public boolean setException(Throwable throwable)
    {
        return setException(futureValue, throwable);
    }

    public Object waitForValue()
        throws ExecutionException
    {
        return Uninterruptibles.getUninterruptibly(futureValue);
    }

    public ()
    {
        this(LocalCache.unset());
    }

    public <init>(<init> <init>1)
    {
        futureValue = SettableFuture.create();
        stopwatch = new Stopwatch();
        oldValue = <init>1;
    }
}
