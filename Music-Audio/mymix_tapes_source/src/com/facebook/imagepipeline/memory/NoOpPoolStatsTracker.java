// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;


// Referenced classes of package com.facebook.imagepipeline.memory:
//            PoolStatsTracker, BasePool

public class NoOpPoolStatsTracker
    implements PoolStatsTracker
{

    private static NoOpPoolStatsTracker sInstance = null;

    private NoOpPoolStatsTracker()
    {
    }

    public static NoOpPoolStatsTracker getInstance()
    {
        com/facebook/imagepipeline/memory/NoOpPoolStatsTracker;
        JVM INSTR monitorenter ;
        NoOpPoolStatsTracker nooppoolstatstracker;
        if (sInstance == null)
        {
            sInstance = new NoOpPoolStatsTracker();
        }
        nooppoolstatstracker = sInstance;
        com/facebook/imagepipeline/memory/NoOpPoolStatsTracker;
        JVM INSTR monitorexit ;
        return nooppoolstatstracker;
        Exception exception;
        exception;
        throw exception;
    }

    public void onAlloc(int i)
    {
    }

    public void onFree(int i)
    {
    }

    public void onHardCapReached()
    {
    }

    public void onSoftCapReached()
    {
    }

    public void onValueRelease(int i)
    {
    }

    public void onValueReuse(int i)
    {
    }

    public void setBasePool(BasePool basepool)
    {
    }

}
