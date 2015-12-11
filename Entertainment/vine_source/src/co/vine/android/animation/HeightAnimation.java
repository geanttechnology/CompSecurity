// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.animation;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class HeightAnimation extends Animation
{

    private final View mAnimatedView;
    private final int mFinalHeight;
    private final boolean mIsExpansion;

    public HeightAnimation(Activity activity, View view, boolean flag, long l)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mAnimatedView = view;
        mIsExpansion = flag;
        setDuration(l);
        int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int j = android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.widthPixels, 0x40000000);
        mAnimatedView.measure(j, i);
        mFinalHeight = mAnimatedView.getMeasuredHeight();
        if (mIsExpansion)
        {
            mAnimatedView.getLayoutParams().height = 0;
            mAnimatedView.setVisibility(0);
        }
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
label0:
        {
            super.applyTransformation(f, transformation);
            transformation = mAnimatedView.getLayoutParams();
            if (transformation != null)
            {
                if (f >= 1.0F)
                {
                    break label0;
                }
                if (mIsExpansion)
                {
                    transformation.height = (int)((float)mFinalHeight * f);
                } else
                {
                    transformation.height = mFinalHeight - (int)((float)mFinalHeight * f);
                }
                mAnimatedView.requestLayout();
            }
            return;
        }
        if (mIsExpansion)
        {
            transformation.height = mFinalHeight;
            mAnimatedView.requestLayout();
            return;
        } else
        {
            transformation.height = 0;
            mAnimatedView.setVisibility(8);
            transformation.height = mFinalHeight;
            return;
        }
    }
}
