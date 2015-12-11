// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture, Uninterruptibles

private static abstract class function extends function
    implements Runnable
{

    Object function;
    ListenableFuture inputFuture;

    abstract void doTransform(Object obj, Object obj1)
        throws Exception;

    final void done()
    {
        maybePropagateCancellation(inputFuture);
        inputFuture = null;
        function = null;
    }

    public final void run()
    {
        boolean flag1 = true;
        Object obj;
        Object obj1;
        boolean flag2;
        obj1 = inputFuture;
        obj = function;
        flag2 = isCancelled();
        boolean flag;
        if (obj1 == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj != null)
        {
            flag1 = false;
        }
        if (flag1 | (flag | flag2))
        {
            return;
        }
          goto _L1
_L3:
        inputFuture = null;
        function = null;
        obj1 = Uninterruptibles.getUninterruptibly(((java.util.concurrent.Future) (obj1)));
        doTransform(obj, obj1);
        return;
        obj;
        try
        {
            cancel(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            setException(((UndeclaredThrowableException) (obj)).getCause());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            setException(((Throwable) (obj)));
        }
        return;
        obj;
        setException(((ExecutionException) (obj)).getCause());
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    (ListenableFuture listenablefuture, Object obj)
    {
        inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
        function = Preconditions.checkNotNull(obj);
    }
}
