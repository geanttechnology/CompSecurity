// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountManagerWrapper, MAPLog

private static class mAccountAdded
    implements mAccountAdded
{

    private boolean mAccountAdded;
    private final CountDownLatch mLatch = new CountDownLatch(1);

    public void accountAdded$519a1c20()
    {
        mAccountAdded = true;
        mLatch.countDown();
    }

    public void accountAlreadyExists$519a1c20()
    {
        mAccountAdded = false;
        mLatch.countDown();
    }

    public boolean awaitForResult()
    {
        try
        {
            mLatch.await();
        }
        catch (InterruptedException interruptedexception)
        {
            MAPLog.e(AccountManagerWrapper.access$000(), "Interrupted waiting for defensive remove accout.");
        }
        return mAccountAdded;
    }

    public ()
    {
        mAccountAdded = false;
    }
}
