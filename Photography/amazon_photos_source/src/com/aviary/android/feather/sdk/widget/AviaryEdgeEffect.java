// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class AviaryEdgeEffect
{

    private static final float EPSILON = 0.001F;
    private static final float HELD_EDGE_SCALE_Y = 0.5F;
    private static final float MAX_ALPHA = 1F;
    private static final float MAX_GLOW_HEIGHT = 1F;
    private static final int MIN_VELOCITY = 100;
    private static final int PULL_DECAY_TIME = 1000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1F;
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    private static final float PULL_EDGE_BEGIN = 0.6F;
    private static final float PULL_GLOW_BEGIN = 0.1F;
    private static final int PULL_TIME = 167;
    private static final int RECEDE_TIME = 1000;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int VELOCITY_EDGE_FACTOR = 8;
    private static final int VELOCITY_GLOW_FACTOR = 16;
    private final Rect mBounds;
    private float mDuration;
    private Drawable mEdge;
    private float mEdgeAlpha;
    private float mEdgeAlphaFinish;
    private float mEdgeAlphaStart;
    private int mEdgeHeight;
    private int mEdgeMaxAlpha;
    private float mEdgeScaleY;
    private float mEdgeScaleYFinish;
    private float mEdgeScaleYStart;
    private Drawable mGlow;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private int mGlowHeight;
    private int mGlowMaxAlpha;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private final int mGlowWidth;
    private final Interpolator mInterpolator;
    private final int mMaxEffectHeight;
    private float mPullDistance;
    private long mStartTime;
    private int mState;
    private int mWidth;
    private int mX;
    private int mY;

    public AviaryEdgeEffect(Context context, int i)
    {
        Object obj;
        mState = 0;
        mBounds = new Rect();
        mEdgeMaxAlpha = 255;
        mGlowMaxAlpha = 255;
        TypedArray typedarray = context.obtainStyledAttributes(i, com.aviary.android.feather.sdk.R.styleable.AviaryEdgeEffect);
        mEdge = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryEdgeEffect_aviary_edgeDrawable);
        mGlow = typedarray.getDrawable(com.aviary.android.feather.sdk.R.styleable.AviaryEdgeEffect_aviary_glowDrawable);
        i = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryEdgeEffect_aviary_edgeColor, 0);
        obj = typedarray.getString(com.aviary.android.feather.sdk.R.styleable.AviaryEdgeEffect_aviary_blendMode);
        typedarray.recycle();
        if (mEdge == null)
        {
            mEdge = context.getResources().getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overscroll_edge);
        }
        if (mGlow == null)
        {
            mGlow = context.getResources().getDrawable(com.aviary.android.feather.sdk.R.drawable.aviary_overscroll_glow);
        }
        if (i == 0 || obj == null) goto _L2; else goto _L1
_L1:
        context = android.graphics.PorterDuff.Mode.MULTIPLY;
        obj = android.graphics.PorterDuff.Mode.valueOf(((String) (obj)));
        context = ((Context) (obj));
_L4:
        setColorFilter(i, context);
_L2:
        mEdgeHeight = mEdge.getIntrinsicHeight();
        mGlowHeight = mGlow.getIntrinsicHeight();
        mGlowWidth = mGlow.getIntrinsicWidth();
        mMaxEffectHeight = (int)(Math.min((((float)mGlowHeight * 1.0F * (float)mGlowHeight) / (float)mGlowWidth) * 0.6F, (float)mGlowHeight * 1.0F) + 0.5F);
        mInterpolator = new DecelerateInterpolator();
        return;
        Throwable throwable;
        throwable;
        if (true) goto _L4; else goto _L3
_L3:
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
        mGlow.setAlpha((int)(Math.max(0.0F, Math.min(mGlowAlpha, 1.0F)) * (float)mGlowMaxAlpha));
        int i = (int)((float)mGlowHeight * mGlowScaleY);
        mGlow.setBounds(0, 0, mWidth, i);
        mGlow.draw(canvas);
        mEdge.setAlpha((int)(Math.max(0.0F, Math.min(mEdgeAlpha, 1.0F)) * (float)mEdgeMaxAlpha));
        int j = (int)((float)mEdgeHeight * mEdgeScaleY);
        mEdge.setBounds(0, 0, mWidth, j);
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
        mEdgeScaleY = 0.0F;
        mEdgeScaleYStart = 0.0F;
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
            mGlowScaleY = 0.1F;
        }
        mState = 1;
        mStartTime = l;
        mDuration = 167F;
        mPullDistance = mPullDistance + f;
        float f1 = Math.abs(mPullDistance);
        mEdgeAlphaStart = Math.max(0.6F, Math.min(f1, 1.0F));
        mEdgeAlpha = mEdgeAlphaStart;
        mEdgeScaleYStart = Math.max(0.5F, Math.min(f1 * 7F, 1.0F));
        mEdgeScaleY = mEdgeScaleYStart;
        mGlowAlphaStart = Math.min(1.0F, mGlowAlpha + Math.abs(f) * 1.1F);
        mGlowAlpha = mGlowAlphaStart;
        float f2 = Math.abs(f);
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
        mGlowScaleYStart = Math.min(1.0F, Math.max(0.0F, mGlowScaleY + f1 * 7F));
        mGlowScaleY = mGlowScaleYStart;
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

    public void setColorFilter(int i, android.graphics.PorterDuff.Mode mode)
    {
        if (mEdge != null)
        {
            mEdge.setColorFilter(i, mode);
        }
        if (mGlow != null)
        {
            mGlow.setColorFilter(i, mode);
        }
    }

    public void setEdgeMaxAlpha(int i)
    {
        mEdgeMaxAlpha = i;
    }

    public void setGlowMaxAlpha(int i)
    {
        mGlowMaxAlpha = i;
    }

    void setPosition(int i, int j)
    {
        mX = i;
        mY = j;
    }

    public void setSize(int i, int j)
    {
        mWidth = i;
        mEdgeHeight = j;
        mGlowHeight = j;
    }
}
