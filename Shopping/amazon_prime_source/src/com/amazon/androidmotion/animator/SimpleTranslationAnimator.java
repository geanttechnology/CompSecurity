// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.Collection;

// Referenced classes of package com.amazon.androidmotion.animator:
//            TranslationAnimator

public class SimpleTranslationAnimator
{

    final TranslationAnimator mAnimator;

    public SimpleTranslationAnimator(View view, int i, int j)
    {
        mAnimator = new TranslationAnimator(view, i, j);
    }

    public SimpleTranslationAnimator(View view, int i, int j, long l)
    {
        mAnimator = new TranslationAnimator(view, i, j, l);
    }

    public SimpleTranslationAnimator(Collection collection, int i, int j)
    {
        mAnimator = new TranslationAnimator(collection, i, j);
    }

    public SimpleTranslationAnimator(Collection collection, int i, int j, long l)
    {
        mAnimator = new TranslationAnimator(collection, i, j, l);
    }

    public void addListener(android.animation.Animator.AnimatorListener animatorlistener)
    {
        mAnimator.addListener(animatorlistener);
    }

    public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        mAnimator.addUpdateListener(animatorupdatelistener);
    }

    public ValueAnimator getAnimator()
    {
        return mAnimator.getSecondAnimator();
    }

    public long getDuration()
    {
        return mAnimator.getDuration();
    }

    public void removeListener(android.animation.Animator.AnimatorListener animatorlistener)
    {
        mAnimator.removeListener(animatorlistener);
    }

    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        mAnimator.removeUpdateListener(animatorupdatelistener);
    }

    public void runAnimator(ValueAnimator valueanimator)
    {
        mAnimator.runSecondAnimator(valueanimator);
    }

    public void setDuration(long l)
    {
        mAnimator.setDuration(l);
    }

    public void setInterpolator(TimeInterpolator timeinterpolator)
    {
        mAnimator.setInterpolator(timeinterpolator);
    }

    public void start()
    {
        mAnimator.animateToSecond();
    }
}
