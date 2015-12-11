// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.util:
//            BitmapUtil

private static class mRunnable
    implements Runnable
{

    private Runnable mRunnable;
    private int mTrySeq;

    public void run()
    {
        try
        {
            mRunnable.run();
            return;
        }
        catch (OutOfMemoryError outofmemoryerror) { }
        if (mTrySeq + 1 < 3)
        {
            BitmapUtil.access$000().schedule(new <init>(mTrySeq + 1, mRunnable), 230L, TimeUnit.MILLISECONDS);
        }
        System.gc();
    }

    public (int i, Runnable runnable)
    {
        mTrySeq = 0;
        mTrySeq = i;
        mRunnable = runnable;
    }
}
