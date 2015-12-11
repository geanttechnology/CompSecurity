// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.amazon.androidmotion.lifecycle.AnimatorManager;
import java.lang.reflect.Field;

public class ImageViewAlphaAnimator
{

    private static final String TAG = com/amazon/androidmotion/animator/ImageViewAlphaAnimator.getName();
    private boolean mAnimatingVisible;
    private long mFadeDuration;
    private ImageView mImageView;
    private TimeInterpolator mInterpolator;
    private AnimatorManager mManager;

    public ImageViewAlphaAnimator(ImageView imageview)
    {
        this(imageview, 175L);
    }

    public ImageViewAlphaAnimator(ImageView imageview, long l)
    {
        mInterpolator = new LinearInterpolator();
        mImageView = imageview;
        mFadeDuration = l;
        mManager = new AnimatorManager();
        mManager.setElapsedFractionCalculator(new com.amazon.androidmotion.lifecycle.AnimatorManager.ElapsedFractionCalculator() {

            final ImageViewAlphaAnimator this$0;

            public float getElapsedFraction(ValueAnimator valueanimator)
            {
                return getFraction();
            }

            
            {
                this$0 = ImageViewAlphaAnimator.this;
                super();
            }
        });
    }

    private ValueAnimator getAlphaAnimator(int i)
    {
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            getAlpha(), i
        });
        valueanimator.setDuration(mFadeDuration);
        valueanimator.setInterpolator(mInterpolator);
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewAlphaAnimator this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                int j = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                setAlpha(j);
                if (j == 0)
                {
                    mImageView.setVisibility(4);
                    return;
                } else
                {
                    mImageView.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = ImageViewAlphaAnimator.this;
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
            ValueAnimator valueanimator = getAlphaAnimator(0);
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
            ValueAnimator valueanimator = getAlphaAnimator(255);
            valueanimator.setStartDelay(l);
            runShowAnimator(valueanimator);
        }
    }

    public void animateToggle()
    {
        animateToggle(0L);
    }

    public void animateToggle(long l)
    {
        if (mManager.hasAnimator() && mAnimatingVisible || !mManager.hasAnimator() && isVisible())
        {
            animateHide(l);
            return;
        } else
        {
            animateShow(l);
            return;
        }
    }

    public int getAlpha()
    {
        int i;
        Field field = android/widget/ImageView.getDeclaredField("mAlpha");
        field.setAccessible(true);
        i = ((Integer)field.get(mImageView)).intValue();
        return i;
        Object obj;
        obj;
        Log.e(TAG, (new StringBuilder()).append("Could not access field mAlpha of ImageView: ").append(((IllegalArgumentException) (obj)).toString()).toString());
_L2:
        return 255;
        obj;
        Log.e(TAG, (new StringBuilder()).append("Could not access field mAlpha of ImageView: ").append(((IllegalAccessException) (obj)).toString()).toString());
        continue; /* Loop/switch isn't completed */
        obj;
        Log.e(TAG, (new StringBuilder()).append("Could not access field mAlpha of ImageView: ").append(((NoSuchFieldException) (obj)).toString()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public float getFraction()
    {
        return (float)getAlpha() / 255F;
    }

    public ValueAnimator getHideAnimator()
    {
        return getAlphaAnimator(0);
    }

    public ValueAnimator getShowAnimator()
    {
        return getAlphaAnimator(255);
    }

    public void hide()
    {
        mManager.cancelAnimator();
        setAlpha(0);
        mImageView.setVisibility(4);
    }

    public boolean isVisible()
    {
        return mImageView.getVisibility() == 0;
    }

    public void reduceDurationByElapsed(ValueAnimator valueanimator)
    {
        mManager.reduceDurationByElapsed(valueanimator);
    }

    public void reduceDurationByRemaining(ValueAnimator valueanimator)
    {
        mManager.reduceDurationByRemaining(valueanimator);
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

    public void setAlpha(int i)
    {
        mImageView.setAlpha(i);
    }

    public void setDefaultInterpolator(TimeInterpolator timeinterpolator)
    {
        mInterpolator = timeinterpolator;
    }

    public void setHideAnimator(ValueAnimator valueanimator)
    {
        mAnimatingVisible = false;
        mManager.setAnimator(valueanimator);
    }

    public void setShowAnimator(ValueAnimator valueanimator)
    {
        mAnimatingVisible = true;
        mManager.setAnimator(valueanimator);
    }

    public void show()
    {
        mManager.cancelAnimator();
        setAlpha(255);
        mImageView.setVisibility(0);
    }

    public void toggle()
    {
        if (isVisible())
        {
            hide();
            return;
        } else
        {
            show();
            return;
        }
    }


}
