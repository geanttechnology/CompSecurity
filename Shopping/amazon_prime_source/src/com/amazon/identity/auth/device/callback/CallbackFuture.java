// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.DefaultCallback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallbackFuture
    implements Callback, MAPFuture
{

    private static final String TAG = com/amazon/identity/auth/device/callback/CallbackFuture.getName();
    private Callback mCallback;
    private final CountDownLatch mLatch;
    private Bundle mResult;
    private int mState;

    public CallbackFuture()
    {
        this(null);
    }

    public CallbackFuture(Callback callback)
    {
        mCallback = DefaultCallback.nullToDefault(callback);
        mLatch = new CountDownLatch(1);
        mState = 0;
    }

    public static CallbackFuture create(Callback callback)
    {
        if (callback instanceof CallbackFuture)
        {
            return (CallbackFuture)callback;
        } else
        {
            return new CallbackFuture(callback);
        }
    }

    private Bundle getResultHelper()
        throws MAPCallbackErrorException
    {
        this;
        JVM INSTR monitorenter ;
        mState;
        JVM INSTR tableswitch 1 2: default 62
    //                   1 41
    //                   2 50;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalStateException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        Bundle bundle = mResult;
        this;
        JVM INSTR monitorexit ;
        return bundle;
_L3:
        throw new MAPCallbackErrorException(mResult);
    }

    private void throwOnMainThread()
    {
        if (ThreadUtils.isRunningOnMainThread())
        {
            throw new IllegalStateException("Cannot call get on the main thread, unless you want ANRs");
        } else
        {
            return;
        }
    }

    private void trySet(int i, Bundle bundle)
    {
        this;
        JVM INSTR monitorenter ;
        if (mState == 0)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        MAPLog.w(TAG, "Callback was called twice", new IllegalStateException());
        this;
        JVM INSTR monitorexit ;
        return;
        Callback callback;
        mResult = bundle;
        mState = i;
        callback = mCallback;
        mCallback = null;
        this;
        JVM INSTR monitorexit ;
        mLatch.countDown();
        if (callback != null)
        {
            switch (i)
            {
            default:
                throw new IllegalStateException();

            case 1: // '\001'
                callback.onSuccess(bundle);
                return;

            case 2: // '\002'
                callback.onError(bundle);
                break;
            }
        }
        break MISSING_BLOCK_LABEL_112;
        bundle;
        this;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    public Bundle get()
        throws MAPCallbackErrorException, InterruptedException, ExecutionException
    {
        throwOnMainThread();
        mLatch.await();
        return getResultHelper();
    }

    public Bundle get(long l, TimeUnit timeunit)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException
    {
        throwOnMainThread();
        if (!mLatch.await(l, timeunit))
        {
            MAPLog.e(TAG, "Timed out waiting for result!");
            throw new TimeoutException("Timed out waiting for result!");
        } else
        {
            return getResultHelper();
        }
    }

    public volatile Object get()
        throws MAPCallbackErrorException, InterruptedException, ExecutionException
    {
        return get();
    }

    public volatile Object get(long l, TimeUnit timeunit)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException
    {
        return get(l, timeunit);
    }

    public void onError(Bundle bundle)
    {
        trySet(2, bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        trySet(1, bundle);
    }

}
