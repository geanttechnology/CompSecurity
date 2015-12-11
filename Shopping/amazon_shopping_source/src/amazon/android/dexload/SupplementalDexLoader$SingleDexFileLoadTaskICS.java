// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;

import amazon.android.dexload.compatibility.DexElementCompatibility;
import android.content.Context;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package amazon.android.dexload:
//            SupplementalDexLoader

private static class mLoadingLatch
    implements Runnable
{

    protected Object mClassLoaderArray;
    protected Context mContext;
    protected DexElementCompatibility mDexElementCompatibility;
    protected String mFileName;
    protected int mIdx;
    protected CountDownLatch mLoadingLatch;

    public void run()
    {
        try
        {
            SupplementalDexLoader.access$100(mContext, mDexElementCompatibility, mClassLoaderArray, mFileName, mIdx);
        }
        catch (Exception exception) { }
        mLoadingLatch.countDown();
    }

    public (Context context, DexElementCompatibility dexelementcompatibility, Object obj, String s, int i, CountDownLatch countdownlatch)
    {
        mContext = context;
        mDexElementCompatibility = dexelementcompatibility;
        mClassLoaderArray = obj;
        mFileName = s;
        mIdx = i;
        mLoadingLatch = countdownlatch;
    }
}
