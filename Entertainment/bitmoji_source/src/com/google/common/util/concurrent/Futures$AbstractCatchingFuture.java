// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture, Uninterruptibles, Platform

private static abstract class fallback extends fallback
    implements Runnable
{

    Class exceptionType;
    Object fallback;
    ListenableFuture inputFuture;

    abstract void doFallback(Object obj, Throwable throwable)
        throws Exception;

    final void done()
    {
        maybePropagateCancellation(inputFuture);
        inputFuture = null;
        exceptionType = null;
        fallback = null;
    }

    public final void run()
    {
        Object obj;
        boolean flag2 = true;
        obj = inputFuture;
        Class class1 = exceptionType;
        Object obj1 = fallback;
        boolean flag;
        boolean flag1;
        if (obj == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (class1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (obj1 != null)
        {
            flag2 = false;
        }
        if (flag2 | (flag1 | flag) | isCancelled())
        {
            return;
        }
        inputFuture = null;
        exceptionType = null;
        fallback = null;
        try
        {
            set(Uninterruptibles.getUninterruptibly(((java.util.concurrent.Future) (obj))));
            return;
        }
        catch (ExecutionException executionexception)
        {
            executionexception = executionexception.getCause();
        }
        // Misplaced declaration of an exception variable
        catch (ExecutionException executionexception) { }
        try
        {
            if (Platform.isInstanceOfThrowableClass(executionexception, class1))
            {
                doFallback(obj1, executionexception);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (ExecutionException executionexception)
        {
            setException(executionexception);
            return;
        }
        setException(executionexception);
        return;
    }

    (ListenableFuture listenablefuture, Class class1, Object obj)
    {
        inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
        exceptionType = (Class)Preconditions.checkNotNull(class1);
        fallback = Preconditions.checkNotNull(obj);
    }
}
