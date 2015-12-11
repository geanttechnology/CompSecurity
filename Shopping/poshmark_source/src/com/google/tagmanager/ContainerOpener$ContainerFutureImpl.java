// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.concurrent.Semaphore;

// Referenced classes of package com.google.tagmanager:
//            ContainerOpener, Container

private static class <init>
    implements <init>
{

    private volatile Container mContainer;
    private Semaphore mContainerIsReady;
    private volatile boolean mHaveGotten;

    public Container get()
    {
        if (mHaveGotten)
        {
            return mContainer;
        }
        try
        {
            mContainerIsReady.acquire();
        }
        catch (InterruptedException interruptedexception) { }
        mHaveGotten = true;
        return mContainer;
    }

    public boolean isDone()
    {
        return mHaveGotten || mContainerIsReady.availablePermits() > 0;
    }

    public void setContainer(Container container)
    {
        mContainer = container;
        mContainerIsReady.release();
    }

    private ()
    {
        mContainerIsReady = new Semaphore(0);
    }

    mContainerIsReady(mContainerIsReady mcontainerisready)
    {
        this();
    }
}
