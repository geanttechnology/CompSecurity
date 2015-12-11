// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.text.TextUtils;
import android.util.Log;
import com.amazon.now.platform.AndroidPlatform;

// Referenced classes of package com.amazon.now.util:
//            UiOOMHandler

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
        System.gc();
        if (TextUtils.isEmpty(((OutOfMemoryError) (obj)).getMessage()))
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
                AndroidPlatform.getInstance().invokeLater(this, 230L);
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
