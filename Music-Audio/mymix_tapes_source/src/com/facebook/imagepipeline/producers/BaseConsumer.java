// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Consumer

public abstract class BaseConsumer
    implements Consumer
{

    private boolean mIsFinished;

    public BaseConsumer()
    {
        mIsFinished = false;
    }

    public void onCancellation()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsFinished;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mIsFinished = true;
        onCancellationImpl();
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        onUnhandledException(((Exception) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    protected abstract void onCancellationImpl();

    public void onFailure(Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsFinished;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mIsFinished = true;
        try
        {
            onFailureImpl(throwable);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable) { }
        onUnhandledException(throwable);
        if (true) goto _L1; else goto _L3
_L3:
        throwable;
        throw throwable;
    }

    protected abstract void onFailureImpl(Throwable throwable);

    public void onNewResult(Object obj, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = mIsFinished;
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mIsFinished = flag;
        try
        {
            onNewResultImpl(obj, flag);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        onUnhandledException(((Exception) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    protected abstract void onNewResultImpl(Object obj, boolean flag);

    public void onProgressUpdate(float f)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsFinished;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        onProgressUpdateImpl(f);
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        onUnhandledException(((Exception) (obj)));
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    protected void onProgressUpdateImpl(float f)
    {
    }

    protected void onUnhandledException(Exception exception)
    {
        FLog.wtf(getClass(), "unhandled exception", exception);
    }
}
