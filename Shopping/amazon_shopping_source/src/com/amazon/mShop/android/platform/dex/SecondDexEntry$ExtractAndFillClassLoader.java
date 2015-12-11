// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.dex;

import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.amazon.mShop.android.platform.dex:
//            SecondDexEntry

private static class mExecutor
    implements Runnable
{

    private final ThreadPoolExecutor mExecutor;

    public void run()
    {
        SecondDexEntry.getInstance().extractDexAndLoad(mExecutor);
    }

    public (ThreadPoolExecutor threadpoolexecutor)
    {
        mExecutor = threadpoolexecutor;
    }
}
