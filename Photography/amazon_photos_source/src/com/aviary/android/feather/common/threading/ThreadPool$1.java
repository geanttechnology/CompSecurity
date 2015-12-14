// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.aviary.android.feather.common.threading:
//            ThreadPool, FutureListener

class r extends rker
{

    final ThreadPool this$0;
    final b val$job;
    final Object val$params[];

    public Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return null;
    }

    public void run()
    {
        Exception exception;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        exception = obj3;
        obj1 = obj2;
        if (mIsCancelled)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj1 = val$job.run(this, val$params);
        exception = obj3;
_L2:
        this;
        JVM INSTR monitorenter ;
        if (exception == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        setException(exception);
        setResult(obj1);
        setIsDone();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        fireOnDoneEvent();
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = new Exception(((Throwable) (obj)));
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    transient r(Object aobj[], b b1, Object aobj1[])
    {
        this$0 = final_threadpool;
        val$job = b1;
        val$params = aobj1;
        super(final_threadpool, final_b, FutureListener.this, aobj);
    }
}
