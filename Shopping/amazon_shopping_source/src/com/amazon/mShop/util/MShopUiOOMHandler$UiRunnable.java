// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.util.Log;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.util:
//            MShopUiOOMHandler, Util

public static class mNeedRetry
    implements Runnable
{

    private boolean mNeedRetry;
    private int mRetryCounter;
    private Runnable mRunnable;

    public void run()
    {
        mRunnable.run();
_L1:
        return;
        Object obj;
        obj;
        LRUCache.reduceByPercent(50);
        System.gc();
        if (Util.isEmpty(((OutOfMemoryError) (obj)).getMessage()))
        {
            obj = "OutOfMemory";
        } else
        {
            obj = ((OutOfMemoryError) (obj)).getMessage();
        }
        Log.e("OutOfMemory", ((String) (obj)));
        if (mNeedRetry)
        {
            int i = mRetryCounter;
            mRetryCounter = i + 1;
            if (i < 3)
            {
                com.amazon.mShop.platform.ryCounter().invokeLater(this, 230L);
                return;
            }
        }
          goto _L1
    }

    public (Runnable runnable, boolean flag)
    {
        mRetryCounter = 0;
        mRunnable = runnable;
        mNeedRetry = flag;
    }
}
