// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwAsyncTask

private static class mPriority extends FutureTask
    implements Comparable
{

    private final int mPriority;

    public int compareTo(mPriority mpriority)
    {
        if (mPriority == mpriority.mPriority)
        {
            return 0;
        }
        return mPriority >= mpriority.mPriority ? 1 : -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public (Runnable runnable, Object obj, int i)
    {
        super(runnable, obj);
        mPriority = i;
    }

    public mPriority(Callable callable, int i)
    {
        super(callable);
        mPriority = i;
    }
}
