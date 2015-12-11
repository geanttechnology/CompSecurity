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
    private final Callback mCallback;
    private Bundle mError;
    private final CountDownLatch mLatch;
    private Bundle mSuccessResult;

    public CallbackFuture()
    {
        this(null);
    }

    public CallbackFuture(Callback callback)
    {
        Object obj = callback;
        if (callback == null)
        {
            obj = new DefaultCallback();
        }
        mCallback = ((Callback) (obj));
        mLatch = new CountDownLatch(1);
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
        if (mError != null)
        {
            throw new MAPCallbackErrorException(mError);
        } else
        {
            return mSuccessResult;
        }
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
        String s = TAG;
        mError = bundle;
        mLatch.countDown();
        mCallback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        String s = TAG;
        mSuccessResult = bundle;
        mLatch.countDown();
        mCallback.onSuccess(bundle);
    }

}
