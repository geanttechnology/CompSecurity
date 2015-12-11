// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.engine;

import com.google.android.speech.callback.Callback;
import daj;
import dap;
import exf;

// Referenced classes of package com.google.android.speech.engine:
//            RetryPolicy

public class RetryCallback
    implements Callback
{

    private final Callback mCallback;
    private boolean mInvalid;
    private final Retrier mResender;
    private final RetryPolicy mRetryPolicy;

    RetryCallback(Callback callback, RetryPolicy retrypolicy, Retrier retrier)
    {
        mCallback = callback;
        mRetryPolicy = retrypolicy;
        mResender = retrier;
        mInvalid = false;
    }

    void invalidate()
    {
        mInvalid = true;
    }

    public void onError(dap dap1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInvalid;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!mRetryPolicy.canRetry(dap1))
        {
            break MISSING_BLOCK_LABEL_49;
        }
        invalidate();
        mResender.scheduleRetry(dap1);
          goto _L1
        dap1;
        throw dap1;
        mCallback.onError(dap1);
          goto _L1
    }

    public volatile void onError(Object obj)
    {
        onError((dap)obj);
    }

    public void onResult(exf exf1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInvalid;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        dap dap1 = mRetryPolicy.equivalentToError(exf1);
        if (dap1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        onError(dap1);
          goto _L1
        exf1;
        throw exf1;
        mCallback.onResult(daj.a(2, exf1));
          goto _L1
    }

    public volatile void onResult(Object obj)
    {
        onResult((exf)obj);
    }

    private class Retrier
    {

        public abstract void scheduleRetry(dap dap1);
    }

}
