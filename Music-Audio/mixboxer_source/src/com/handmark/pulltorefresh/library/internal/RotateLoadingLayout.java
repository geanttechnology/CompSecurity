// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

// Referenced classes of package com.handmark.pulltorefresh.library.internal:
//            LoadingLayout

public class RotateLoadingLayout extends LoadingLayout
{

    static final int ROTATION_ANIMATION_DURATION = 1200;
    private final Matrix mHeaderImageMatrix = new Matrix();
    private final Animation mRotateAnimation = new RotateAnimation(0.0F, 720F, 1, 0.5F, 1, 0.5F);
    private final boolean mRotateDrawableWhilePulling;
    private float mRotationPivotX;
    private float mRotationPivotY;

    public RotateLoadingLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation orientation, TypedArray typedarray)
    {
        super(context, mode, orientation, typedarray);
        mRotateDrawableWhilePulling = typedarray.getBoolean(15, true);
        mHeaderImage.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        mHeaderImage.setImageMatrix(mHeaderImageMatrix);
        mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
        mRotateAnimation.setDuration(1200L);
        mRotateAnimation.setRepeatCount(-1);
        mRotateAnimation.setRepeatMode(1);
    }

    private void resetImageRotation()
    {
        if (mHeaderImageMatrix != null)
        {
            mHeaderImageMatrix.reset();
            mHeaderImage.setImageMatrix(mHeaderImageMatrix);
        }
    }

    protected int getDefaultDrawableResId()
    {
        return com.handmark.pulltorefresh.library.R.drawable.default_ptr_rotate;
    }

    public void onLoadingDrawableSet(Drawable drawable)
    {
        if (drawable != null)
        {
            mRotationPivotX = (float)drawable.getIntrinsicWidth() / 2.0F;
            mRotationPivotY = (float)drawable.getIntrinsicHeight() / 2.0F;
        }
    }

    protected void onPullImpl(float f)
    {
        if (mRotateDrawableWhilePulling)
        {
            f = 90F * f;
        } else
        {
            f = Math.max(0.0F, Math.min(180F, 360F * f - 180F));
        }
        mHeaderImageMatrix.setRotate(f, mRotationPivotX, mRotationPivotY);
        mHeaderImage.setImageMatrix(mHeaderImageMatrix);
    }

    protected void pullToRefreshImpl()
    {
    }

    protected void refreshingImpl()
    {
        mHeaderImage.startAnimation(mRotateAnimation);
    }

    protected void releaseToRefreshImpl()
    {
    }

    protected void resetImpl()
    {
        mHeaderImage.clearAnimation();
        resetImageRotation();
    }
}
