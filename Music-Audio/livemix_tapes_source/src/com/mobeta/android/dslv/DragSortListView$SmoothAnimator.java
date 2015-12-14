// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class mAlpha
    implements Runnable
{

    private float mA;
    private float mAlpha;
    private float mB;
    private float mC;
    private boolean mCanceled;
    private float mD;
    private float mDurationF;
    protected long mStartTime;
    final DragSortListView this$0;

    public void cancel()
    {
        mCanceled = true;
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void onUpdate(float f, float f1)
    {
    }

    public void run()
    {
        if (mCanceled)
        {
            return;
        }
        float f = (float)(SystemClock.uptimeMillis() - mStartTime) / mDurationF;
        if (f >= 1.0F)
        {
            onUpdate(1.0F, 1.0F);
            onStop();
            return;
        } else
        {
            onUpdate(f, transform(f));
            post(this);
            return;
        }
    }

    public void start()
    {
        mStartTime = SystemClock.uptimeMillis();
        mCanceled = false;
        onStart();
        post(this);
    }

    public float transform(float f)
    {
        if (f < mAlpha)
        {
            return mA * f * f;
        }
        if (f < 1.0F - mAlpha)
        {
            return mB + mC * f;
        } else
        {
            return 1.0F - mD * (f - 1.0F) * (f - 1.0F);
        }
    }

    public (float f, int i)
    {
        this$0 = DragSortListView.this;
        super();
        mAlpha = f;
        mDurationF = i;
        f = 1.0F / (mAlpha * 2.0F * (1.0F - mAlpha));
        mD = f;
        mA = f;
        mB = mAlpha / ((mAlpha - 1.0F) * 2.0F);
        mC = 1.0F / (1.0F - mAlpha);
    }
}
