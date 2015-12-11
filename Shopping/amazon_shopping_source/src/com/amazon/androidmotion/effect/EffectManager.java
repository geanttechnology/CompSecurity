// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.effect;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

// Referenced classes of package com.amazon.androidmotion.effect:
//            Effect

public class EffectManager
{
    private class UpdateListener
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        final EffectManager this$0;

        public void onAnimationUpdate(ValueAnimator valueanimator)
        {
            float f = mEffect.getFraction(mAnimator);
            TimeInterpolator timeinterpolator = mEffect.getInterpolator();
            valueanimator = timeinterpolator;
            if (timeinterpolator == null)
            {
                valueanimator = EffectManager.DEFAULT_INTERPOLATOR;
            }
            f = valueanimator.getInterpolation(f);
            mEffect.update(f);
        }
    }


    public static final TimeInterpolator DEFAULT_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private ValueAnimator mAnimator;
    private final Effect mEffect;
    private final UpdateListener mListener;

    public void detachFromAnimator()
    {
        if (mAnimator != null)
        {
            mAnimator.removeUpdateListener(mListener);
            mAnimator = null;
        }
    }

    public ValueAnimator getAnimator()
    {
        return mAnimator;
    }

    public void setAnimator(ValueAnimator valueanimator)
    {
        detachFromAnimator();
        if (valueanimator != null)
        {
            valueanimator.addUpdateListener(mListener);
        }
        mAnimator = valueanimator;
    }



}
