// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.lifecycle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.amazon.androidmotion.effect.EffectManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimatorManager
{
    public static interface ElapsedFractionCalculator
    {

        public abstract float getElapsedFraction(ValueAnimator valueanimator);
    }


    private ValueAnimator mAnimator;
    private final AnimatorListenerAdapter mClearOnEndListener = new AnimatorListenerAdapter() {

        final AnimatorManager this$0;

        public void onAnimationEnd(Animator animator)
        {
            clearAnimator();
        }

            
            {
                this$0 = AnimatorManager.this;
                super();
            }
    };
    private final List mEffects = new ArrayList();
    private ElapsedFractionCalculator mElapsedFractionCalculator;
    private final List mListeners = new ArrayList();
    private final List mUpdateListeners = new ArrayList();

    public AnimatorManager()
    {
    }

    public void cancelAnimator()
    {
        if (mAnimator != null)
        {
            mAnimator.cancel();
            clearAnimator();
        }
    }

    public void clearAnimator()
    {
        if (mAnimator != null)
        {
            mAnimator.removeListener(mClearOnEndListener);
            android.animation.Animator.AnimatorListener animatorlistener;
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); mAnimator.removeListener(animatorlistener))
            {
                animatorlistener = (android.animation.Animator.AnimatorListener)iterator.next();
            }

            android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener;
            for (Iterator iterator1 = mUpdateListeners.iterator(); iterator1.hasNext(); mAnimator.removeUpdateListener(animatorupdatelistener))
            {
                animatorupdatelistener = (android.animation.ValueAnimator.AnimatorUpdateListener)iterator1.next();
            }

            Iterator iterator2 = mEffects.iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                EffectManager effectmanager = (EffectManager)iterator2.next();
                if (effectmanager.getAnimator() == mAnimator)
                {
                    effectmanager.detachFromAnimator();
                }
            } while (true);
            mAnimator = null;
        }
    }

    public float getElapsedFraction()
    {
        if (mElapsedFractionCalculator != null)
        {
            return mElapsedFractionCalculator.getElapsedFraction(mAnimator);
        }
        if (mAnimator != null)
        {
            return mAnimator.getAnimatedFraction();
        } else
        {
            return 0.0F;
        }
    }

    public boolean hasAnimator()
    {
        return mAnimator != null;
    }

    public void reduceDurationByElapsed(Animator animator)
    {
        if (mAnimator != null)
        {
            animator.setDuration((long)((float)animator.getDuration() * getElapsedFraction()));
        }
    }

    public void reduceDurationByRemaining(Animator animator)
    {
        if (mAnimator != null)
        {
            animator.setDuration((long)((float)animator.getDuration() * (1.0F - getElapsedFraction())));
        }
    }

    public void runAnimator(ValueAnimator valueanimator)
    {
        cancelAnimator();
        setAnimator(valueanimator);
        valueanimator.start();
    }

    public void runAnimatorForElapsed(ValueAnimator valueanimator)
    {
        reduceDurationByElapsed(valueanimator);
        runAnimator(valueanimator);
    }

    public void runAnimatorForRemaining(ValueAnimator valueanimator)
    {
        reduceDurationByRemaining(valueanimator);
        runAnimator(valueanimator);
    }

    public void setAnimator(ValueAnimator valueanimator)
    {
        clearAnimator();
        if (valueanimator != null)
        {
            mAnimator = valueanimator;
            mAnimator.addListener(mClearOnEndListener);
            android.animation.Animator.AnimatorListener animatorlistener;
            for (valueanimator = mListeners.iterator(); valueanimator.hasNext(); mAnimator.addListener(animatorlistener))
            {
                animatorlistener = (android.animation.Animator.AnimatorListener)valueanimator.next();
            }

            android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener;
            for (valueanimator = mUpdateListeners.iterator(); valueanimator.hasNext(); mAnimator.addUpdateListener(animatorupdatelistener))
            {
                animatorupdatelistener = (android.animation.ValueAnimator.AnimatorUpdateListener)valueanimator.next();
            }

            for (valueanimator = mEffects.iterator(); valueanimator.hasNext(); ((EffectManager)valueanimator.next()).setAnimator(mAnimator)) { }
        }
    }

    public void setElapsedFractionCalculator(ElapsedFractionCalculator elapsedfractioncalculator)
    {
        mElapsedFractionCalculator = elapsedfractioncalculator;
    }
}
