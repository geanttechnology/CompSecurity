// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;


// Referenced classes of package com.amazon.mixtape.service:
//            MetadataFetcherProgressObserver, AccountSync

private class <init>
    implements MetadataFetcherProgressObserver
{

    double currentProgress;
    private long mCurrentCount;
    private long mTotalCount;
    final AccountSync this$0;

    private void calculateCurrentProgressAndNotify()
    {
        if (mCurrentCount > mTotalCount)
        {
            currentProgress = currentProgress + (100D - currentProgress) / 2D;
        } else
        {
            currentProgress = ((double)mCurrentCount / (double)mTotalCount) * 100D;
        }
        AccountSync.access$200(AccountSync.this, currentProgress, 100D);
    }

    public void notifyComplete()
    {
        AccountSync.access$200(AccountSync.this, 100D, 100D);
    }

    public void setCurrentCount(long l)
    {
        mCurrentCount = l;
        calculateCurrentProgressAndNotify();
    }

    public void setTotalCount(long l)
    {
        mTotalCount = l;
    }

    public void updateCurrentCount(long l)
    {
        mCurrentCount = mCurrentCount + l;
        calculateCurrentProgressAndNotify();
    }

    private ()
    {
        this$0 = AccountSync.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
