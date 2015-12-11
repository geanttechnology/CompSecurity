// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.amazon.androidmotion.lifecycle.AnimatorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewAlphaAnimator
{

    private boolean mAnimatingVisible;
    private long mDuration;
    private TimeInterpolator mInterpolator;
    private AnimatorManager mManager;
    private float mMaxAlpha;
    private float mMinAlpha;
    private List mViews;

    public ViewAlphaAnimator(View view, float f, float f1, long l)
    {
        mInterpolator = new LinearInterpolator();
        init(f, f1, l);
        mViews.add(view);
    }

    public ViewAlphaAnimator(View view, long l)
    {
        this(view, 0.0F, 1.0F, l);
    }

    private ValueAnimator getAlphaAnimator(float f)
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            getAlpha(), f
        });
        valueanimator.setDuration(mDuration);
        valueanimator.setInterpolator(mInterpolator);
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ViewAlphaAnimator this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                float f1 = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                setAlpha(f1);
            }

            
            {
                this$0 = ViewAlphaAnimator.this;
                super();
            }
        });
        return valueanimator;
    }

    public void animateHide()
    {
        animateHide(0L);
    }

    public void animateHide(long l)
    {
        if (!mManager.hasAnimator() || mAnimatingVisible)
        {
            ValueAnimator valueanimator = getAlphaAnimator(mMinAlpha);
            valueanimator.setStartDelay(l);
            runHideAnimator(valueanimator);
        }
    }

    public void animateShow()
    {
        animateShow(0L);
    }

    public void animateShow(long l)
    {
        if (!mManager.hasAnimator() || !mAnimatingVisible)
        {
            ValueAnimator valueanimator = getAlphaAnimator(mMaxAlpha);
            valueanimator.setStartDelay(l);
            runShowAnimator(valueanimator);
        }
    }

    public float getAlpha()
    {
        return ((View)mViews.get(0)).getAlpha();
    }

    public float getFraction()
    {
        return ((View)mViews.get(0)).getAlpha();
    }

    public void hide()
    {
        mManager.cancelAnimator();
        setAlpha(mMinAlpha);
    }

    public void init(float f, float f1, long l)
    {
        mViews = new ArrayList();
        mMinAlpha = f;
        mMaxAlpha = f1;
        mDuration = l;
        mManager = new AnimatorManager();
        mManager.setElapsedFractionCalculator(new com.amazon.androidmotion.lifecycle.AnimatorManager.ElapsedFractionCalculator() {

            final ViewAlphaAnimator this$0;

            public float getElapsedFraction(ValueAnimator valueanimator)
            {
                return getFraction();
            }

            
            {
                this$0 = ViewAlphaAnimator.this;
                super();
            }
        });
    }

    public void runHideAnimator(ValueAnimator valueanimator)
    {
        mAnimatingVisible = false;
        mManager.runAnimatorForElapsed(valueanimator);
    }

    public void runShowAnimator(ValueAnimator valueanimator)
    {
        mAnimatingVisible = true;
        mManager.runAnimatorForRemaining(valueanimator);
    }

    public void setAlpha(float f)
    {
        for (Iterator iterator = mViews.iterator(); iterator.hasNext();)
        {
            View view = (View)iterator.next();
            view.setAlpha(f);
            if (f == 0.0F)
            {
                view.setVisibility(4);
            } else
            {
                view.setVisibility(0);
            }
        }

    }

    public void setDuration(long l)
    {
        mDuration = l;
    }

    public void setMaxAlpha(float f)
    {
        mMaxAlpha = f;
    }
}
