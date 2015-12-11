// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import amazon.android.dexload.SupplementalDexLoader;
import android.content.Context;
import android.util.Log;
import java.util.List;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.mShop:
//            AmazonApplication

private static class mAppStoreLoadingLatch
    implements Runnable
{

    private CountDownLatch mAppStoreLoadingLatch;
    private Context mContext;
    private List mCriticalJars;

    public void run()
    {
        SupplementalDexLoader supplementaldexloader = SupplementalDexLoader.getInstance();
        supplementaldexloader.updateClassLoader(mContext, amazon.android.dexload.readed.YES, mCriticalJars);
        mAppStoreLoadingLatch.countDown();
_L1:
        Exception exception;
        Exception exception2;
        try
        {
            supplementaldexloader.updateClassLoader(mContext, amazon.android.dexload.readed.YES);
            return;
        }
        catch (Exception exception1)
        {
            Log.e("AmazonApplication", "Dex loading fails, restart app and skip loading ", exception1);
        }
        break MISSING_BLOCK_LABEL_78;
        exception2;
        Log.e("AmazonApplication", "Dex loading fails, restart app and skip loading ", exception2);
        mAppStoreLoadingLatch.countDown();
          goto _L1
        exception;
        mAppStoreLoadingLatch.countDown();
        throw exception;
    }

    public ultiThreaded(Context context, List list, CountDownLatch countdownlatch)
    {
        mContext = context;
        mCriticalJars = list;
        mAppStoreLoadingLatch = countdownlatch;
    }
}
