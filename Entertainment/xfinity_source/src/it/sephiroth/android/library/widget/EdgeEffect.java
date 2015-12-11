// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class EdgeEffect
{

    private final Rect mBounds = new Rect();
    private final int mDirection;
    private float mDuration;
    private final Drawable mEdge;
    private float mEdgeAlpha;
    private float mEdgeAlphaFinish;
    private float mEdgeAlphaStart;
    private final int mEdgeHeight;
    private float mEdgeScaleY;
    private float mEdgeScaleYFinish;
    private float mEdgeScaleYStart;
    private final Drawable mGlow;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private final int mGlowHeight;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private final int mGlowWidth;
    private int mHeight;
    private final Interpolator mInterpolator = new DecelerateInterpolator();
    private final int mMaxEffectHeight;
    private final int mMinWidth;
    private float mPullDistance;
    private long mStartTime;
    private int mState;
    private int mWidth;
    private int mX;
    private int mY;

    public EdgeEffect(Context context, int i)
    {
        mState = 0;
        context = context.getResources();
        mEdge = context.getDrawable(it.sephiroth.android.library.R.drawable.hlv_overscroll_edge);
        mGlow = context.getDrawable(it.sephiroth.android.library.R.drawable.hlv_overscroll_glow);
        mDirection = i;
        mEdgeHeight = mEdge.getIntrinsicHeight();
        mGlowHeight = mGlow.getIntrinsicHeight();
        mGlowWidth = mGlow.getIntrinsicWidth();
        mMaxEffectHeight = (int)(Math.min((((float)mGlowHeight * 4F * (float)mGlowHeight) / (float)mGlowWidth) * 0.6F, (float)mGlowHeight * 4F) + 0.5F);
        mMinWidth = (int)(context.getDisplayMetrics().density * 300F + 0.5F);
    }

    private void update()
    {
        float f;
        float f2;
        f = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - mStartTime) / mDuration, 1.0F);
        f2 = mInterpolator.getInterpolation(f);
        mEdgeAlpha = mEdgeAlphaStart + (mEdgeAlphaFinish - mEdgeAlphaStart) * f2;
        mEdgeScaleY = mEdgeScaleYStart + (mEdgeScaleYFinish - mEdgeScaleYStart) * f2;
        mGlowAlpha = mGlowAlphaStart + (mGlowAlphaFinish - mGlowAlphaStart) * f2;
        mGlowScaleY = mGlowScaleYStart + (mGlowScaleYFinish - mGlowScaleYStart) * f2;
        if (f < 0.999F) goto _L2; else goto _L1
_L1:
        mState;
        JVM INSTR tableswitch 1 4: default 152
    //                   1 224
    //                   2 153
    //                   3 350
    //                   4 295;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L4:
        mState = 3;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 1000F;
        mEdgeAlphaStart = mEdgeAlpha;
        mEdgeScaleYStart = mEdgeScaleY;
        mGlowAlphaStart = mGlowAlpha;
        mGlowScaleYStart = mGlowScaleY;
        mEdgeAlphaFinish = 0.0F;
        mEdgeScaleYFinish = 0.0F;
        mGlowAlphaFinish = 0.0F;
        mGlowScaleYFinish = 0.0F;
        return;
_L3:
        mState = 4;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 1000F;
        mEdgeAlphaStart = mEdgeAlpha;
        mEdgeScaleYStart = mEdgeScaleY;
        mGlowAlphaStart = mGlowAlpha;
        mGlowScaleYStart = mGlowScaleY;
        mEdgeAlphaFinish = 0.0F;
        mEdgeScaleYFinish = 0.0F;
        mGlowAlphaFinish = 0.0F;
        mGlowScaleYFinish = 0.0F;
        return;
_L6:
        float f1;
        if (mGlowScaleYFinish != 0.0F)
        {
            f1 = 1.0F / (mGlowScaleYFinish * mGlowScaleYFinish);
        } else
        {
            f1 = 3.402823E+38F;
        }
        mEdgeScaleY = mEdgeScaleYStart + (mEdgeScaleYFinish - mEdgeScaleYStart) * f2 * f1;
        mState = 3;
        return;
_L5:
        mState = 0;
        return;
    }

    public boolean draw(Canvas canvas)
    {
        boolean flag = false;
        update();
        mGlow.setAlpha((int)(Math.max(0.0F, Math.min(mGlowAlpha, 1.0F)) * 255F));
        int i = (int)Math.min((((float)mGlowHeight * mGlowScaleY * (float)mGlowHeight) / (float)mGlowWidth) * 0.6F, (float)mGlowHeight * 4F);
        int j;
        if (mDirection == 0)
        {
            mGlow.setBounds(0, 0, mWidth, i);
        } else
        {
            mGlow.setBounds(0, 0, mWidth, i);
        }
        mGlow.draw(canvas);
        mEdge.setAlpha((int)(Math.max(0.0F, Math.min(mEdgeAlpha, 1.0F)) * 255F));
        j = (int)((float)mEdgeHeight * mEdgeScaleY);
        if (mDirection == 0)
        {
            mEdge.setBounds(0, 0, mWidth, j);
        } else
        {
            mEdge.setBounds(0, 0, mWidth, j);
        }
        mEdge.draw(canvas);
        if (mState == 3 && i == 0 && j == 0)
        {
            mState = 0;
        }
        if (mState != 0)
        {
            flag = true;
        }
        return flag;
    }

    public void finish()
    {
        mState = 0;
    }

    public Rect getBounds(boolean flag)
    {
        int i = 0;
        mBounds.set(0, 0, mWidth, mMaxEffectHeight);
        Rect rect = mBounds;
        int j = mX;
        int k = mY;
        if (flag)
        {
            i = mMaxEffectHeight;
        }
        rect.offset(j, k - i);
        return mBounds;
    }

    public boolean isFinished()
    {
        return mState == 0;
    }

    public void onAbsorb(int i)
    {
        mState = 2;
        i = Math.max(100, Math.abs(i));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 0.1F + (float)i * 0.03F;
        mEdgeAlphaStart = 0.0F;
        mEdgeScaleYStart = 0.0F;
        mEdgeScaleY = 0.0F;
        mGlowAlphaStart = 0.5F;
        mGlowScaleYStart = 0.0F;
        mEdgeAlphaFinish = Math.max(0, Math.min(i * 8, 1));
        mEdgeScaleYFinish = Math.max(0.5F, Math.min(i * 8, 1.0F));
        mGlowScaleYFinish = Math.min(0.025F + (float)((i / 100) * i) * 0.00015F, 1.75F);
        mGlowAlphaFinish = Math.max(mGlowAlphaStart, Math.min((float)(i * 16) * 1E-05F, 1.0F));
    }

    public void onPull(float f)
    {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (mState == 4 && (float)(l - mStartTime) < mDuration)
        {
            return;
        }
        if (mState != 1)
        {
            mGlowScaleY = 1.0F;
        }
        mState = 1;
        mStartTime = l;
        mDuration = 167F;
        mPullDistance = mPullDistance + f;
        float f1 = Math.abs(mPullDistance);
        float f2 = Math.max(0.6F, Math.min(f1, 1.0F));
        mEdgeAlphaStart = f2;
        mEdgeAlpha = f2;
        f1 = Math.max(0.5F, Math.min(f1 * 7F, 1.0F));
        mEdgeScaleYStart = f1;
        mEdgeScaleY = f1;
        f1 = Math.min(1.0F, mGlowAlpha + Math.abs(f) * 1.1F);
        mGlowAlphaStart = f1;
        mGlowAlpha = f1;
        f2 = Math.abs(f);
        f1 = f2;
        if (f > 0.0F)
        {
            f1 = f2;
            if (mPullDistance < 0.0F)
            {
                f1 = -f2;
            }
        }
        if (mPullDistance == 0.0F)
        {
            mGlowScaleY = 0.0F;
        }
        f = Math.min(4F, Math.max(0.0F, mGlowScaleY + f1 * 7F));
        mGlowScaleYStart = f;
        mGlowScaleY = f;
        mEdgeAlphaFinish = mEdgeAlpha;
        mEdgeScaleYFinish = mEdgeScaleY;
        mGlowAlphaFinish = mGlowAlpha;
        mGlowScaleYFinish = mGlowScaleY;
    }

    public void onRelease()
    {
        mPullDistance = 0.0F;
        if (mState != 1 && mState != 4)
        {
            return;
        } else
        {
            mState = 3;
            mEdgeAlphaStart = mEdgeAlpha;
            mEdgeScaleYStart = mEdgeScaleY;
            mGlowAlphaStart = mGlowAlpha;
            mGlowScaleYStart = mGlowScaleY;
            mEdgeAlphaFinish = 0.0F;
            mEdgeScaleYFinish = 0.0F;
            mGlowAlphaFinish = 0.0F;
            mGlowScaleYFinish = 0.0F;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 1000F;
            return;
        }
    }

    public void setPosition(int i, int j)
    {
        mX = i;
        mY = j;
    }

    public void setSize(int i, int j)
    {
        mWidth = i;
        mHeight = j;
    }
}
