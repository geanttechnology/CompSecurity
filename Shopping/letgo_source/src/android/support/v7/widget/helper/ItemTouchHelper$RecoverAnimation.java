// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget.helper;

import android.support.v4.view.ah;
import android.support.v7.b;
import android.support.v7.c;
import android.support.v7.e;
import android.support.v7.h;

// Referenced classes of package android.support.v7.widget.helper:
//            ItemTouchHelper

private class setFraction
    implements c
{

    final int mActionState;
    private final int mAnimationType;
    private boolean mEnded;
    private float mFraction;
    public boolean mIsPendingCleanup;
    boolean mOverridden;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    private final h mValueAnimator = b.a();
    final android.support.v7.widget.mation.mStartDy mViewHolder;
    float mX;
    float mY;
    final ItemTouchHelper this$0;

    public void cancel()
    {
        mValueAnimator.b();
    }

    public void onAnimationCancel(h h1)
    {
        setFraction(1.0F);
    }

    public void onAnimationEnd(h h1)
    {
        mEnded = true;
    }

    public void onAnimationRepeat(h h1)
    {
    }

    public void onAnimationStart(h h1)
    {
    }

    public void setDuration(long l)
    {
        mValueAnimator.a(l);
    }

    public void setFraction(float f)
    {
        mFraction = f;
    }

    public void start()
    {
        mViewHolder.clable(false);
        mValueAnimator.a();
    }

    public void update()
    {
        if (mStartDx == mTargetX)
        {
            mX = ah.m(mViewHolder.mViewHolder);
        } else
        {
            mX = mStartDx + mFraction * (mTargetX - mStartDx);
        }
        if (mStartDy == mTargetY)
        {
            mY = ah.n(mViewHolder.mViewHolder);
            return;
        } else
        {
            mY = mStartDy + mFraction * (mTargetY - mStartDy);
            return;
        }
    }



    public _cls1.val.this._cls0(android.support.v7.widget.mation mation, int i, int j, float f, float f1, float f2, 
            float f3)
    {
        this.this$0 = ItemTouchHelper.this;
        super();
        mOverridden = false;
        mEnded = false;
        mActionState = j;
        mAnimationType = i;
        mViewHolder = mation;
        mStartDx = f;
        mStartDy = f1;
        mTargetX = f2;
        mTargetY = f3;
        mValueAnimator.a(new e() {

            final ItemTouchHelper.RecoverAnimation this$1;
            final ItemTouchHelper val$this$0;

            public void onAnimationUpdate(h h1)
            {
                setFraction(h1.c());
            }

            
            {
                this$1 = ItemTouchHelper.RecoverAnimation.this;
                this$0 = itemtouchhelper;
                super();
            }
        });
        mValueAnimator.a(mation.mValueAnimator);
        mValueAnimator.a(this);
        setFraction(0.0F);
    }
}
