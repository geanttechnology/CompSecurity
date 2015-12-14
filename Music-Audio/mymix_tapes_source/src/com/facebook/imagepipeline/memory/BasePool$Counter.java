// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.logging.FLog;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            BasePool

static class 
{

    private static final String TAG = "com.facebook.imagepipeline.common.BasePool.Counter";
    int mCount;
    int mNumBytes;

    public void decrement(int i)
    {
        if (mNumBytes >= i && mCount > 0)
        {
            mCount = mCount - 1;
            mNumBytes = mNumBytes - i;
            return;
        } else
        {
            FLog.wtf("com.facebook.imagepipeline.common.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(mNumBytes), Integer.valueOf(mCount)
            });
            return;
        }
    }

    public void increment(int i)
    {
        mCount = mCount + 1;
        mNumBytes = mNumBytes + i;
    }

    public void reset()
    {
        mCount = 0;
        mNumBytes = 0;
    }

    ()
    {
    }
}
