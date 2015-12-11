// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.animation;

import android.os.SystemClock;
import android.view.View;

public class SmoothAnimator
    implements Runnable
{
    public static interface AnimationListener
    {

        public abstract void onAnimationFinish(int i, Object obj);
    }


    private float mA;
    private float mAlpha;
    private float mB;
    private float mC;
    private boolean mCanceled;
    private float mD;
    protected float mDurationF;
    private final View mPoster;
    protected long mStartTime;

    public SmoothAnimator(View view, float f, int i)
    {
        mPoster = view;
        mAlpha = f;
        mDurationF = i;
        f = 1.0F / (mAlpha * 2.0F * (1.0F - mAlpha));
        mD = f;
        mA = f;
        mB = mAlpha / ((mAlpha - 1.0F) * 2.0F);
        mC = 1.0F / (1.0F - mAlpha);
    }

    public void cancel()
    {
        mCanceled = true;
    }

    public void onCancel()
    {
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
            onCancel();
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
            mPoster.post(this);
            return;
        }
    }

    public void start()
    {
        mStartTime = SystemClock.uptimeMillis();
        mCanceled = false;
        onStart();
        mPoster.post(this);
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
}
