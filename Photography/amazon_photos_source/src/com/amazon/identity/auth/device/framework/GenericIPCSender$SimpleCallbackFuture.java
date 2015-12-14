// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            GenericIPCSender

private static final class <init>
    implements Callback
{

    private final CountDownLatch mLatch;
    private Bundle mResult;

    private void setResult(Bundle bundle)
    {
        mResult = bundle;
        mLatch.countDown();
    }

    public Bundle get$17a408ed(TimeUnit timeunit)
        throws InterruptedException, TimeoutException
    {
        if (mLatch.await(500L, timeunit))
        {
            return mResult;
        } else
        {
            throw new TimeoutException();
        }
    }

    public void onError(Bundle bundle)
    {
        setResult(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        setResult(bundle);
    }

    private ()
    {
        mLatch = new CountDownLatch(1);
    }

    mLatch(byte byte0)
    {
        this();
    }
}
