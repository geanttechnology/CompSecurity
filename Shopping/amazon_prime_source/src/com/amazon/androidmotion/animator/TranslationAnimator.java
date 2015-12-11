// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.animator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.amazon.androidmotion.effect.EffectManager;
import com.amazon.androidmotion.lifecycle.AnimatorManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TranslationAnimator
{

    private static final TimeInterpolator DEFAULT_INTERPOLATOR = new AccelerateDecelerateInterpolator();
    private boolean mAtFirst;
    private long mDuration;
    private int mFirstX;
    private int mFirstY;
    private TimeInterpolator mInterpolator;
    private AnimatorManager mManager;
    private int mSecondX;
    private int mSecondY;
    private List mViews;

    public TranslationAnimator(View view, int i, int j)
    {
        this(view, i, j, 200L);
    }

    public TranslationAnimator(View view, int i, int j, int k, int l)
    {
        this(view, i, j, k, l, 200L);
    }

    public TranslationAnimator(View view, int i, int j, int k, int l, long l1)
    {
        mInterpolator = DEFAULT_INTERPOLATOR;
        init(i, j, k, l, l1);
        mViews.add(view);
    }

    public TranslationAnimator(View view, int i, int j, long l)
    {
        this(view, Math.round(view.getTranslationX()), Math.round(view.getTranslationY()), i, j, l);
    }

    public TranslationAnimator(Collection collection, int i, int j)
    {
        this(collection, i, j, 200L);
    }

    public TranslationAnimator(Collection collection, int i, int j, int k, int l)
    {
        this(collection, i, j, k, l, 200L);
    }

    public TranslationAnimator(Collection collection, int i, int j, int k, int l, long l1)
    {
        mInterpolator = DEFAULT_INTERPOLATOR;
        if (collection.size() == 0)
        {
            throw new IllegalArgumentException("Must provide at least one View.");
        } else
        {
            init(i, j, k, l, l1);
            mViews.addAll(collection);
            return;
        }
    }

    public TranslationAnimator(Collection collection, int i, int j, long l)
    {
        mInterpolator = DEFAULT_INTERPOLATOR;
        if (collection.size() == 0)
        {
            throw new IllegalArgumentException("Must provide at least one View.");
        } else
        {
            View view = (View)collection.iterator().next();
            init(Math.round(view.getTranslationX()), Math.round(view.getTranslationY()), i, j, l);
            mViews.addAll(collection);
            return;
        }
    }

    private ValueAnimator getTranslationAnimator(final int finishX, final int finishY)
    {
        final int startX = Math.round(((View)mViews.get(0)).getTranslationX());
        final int startY = Math.round(((View)mViews.get(0)).getTranslationY());
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.setDuration(mDuration);
        valueanimator.setInterpolator(mInterpolator);
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final TranslationAnimator this$0;
            final int val$finishX;
            final int val$finishY;
            final int val$startX;
            final int val$startY;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                float f = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                int i = Math.round((float)startX + (float)(finishX - startX) * f);
                int j = Math.round((float)startY + (float)(finishY - startY) * f);
                View view;
                for (valueanimator1 = mViews.iterator(); valueanimator1.hasNext(); view.setTranslationY(j))
                {
                    view = (View)valueanimator1.next();
                    view.setTranslationX(i);
                }

            }

            
            {
                this$0 = TranslationAnimator.this;
                startX = i;
                finishX = j;
                startY = k;
                finishY = l;
                super();
            }
        });
        return valueanimator;
    }

    private void init(int i, int j, int k, int l, long l1)
    {
        mViews = new ArrayList();
        mFirstX = i;
        mFirstY = j;
        mSecondX = k;
        mSecondY = l;
        mDuration = l1;
        mManager = new AnimatorManager();
        mManager.setElapsedFractionCalculator(new com.amazon.androidmotion.lifecycle.AnimatorManager.ElapsedFractionCalculator() {

            final TranslationAnimator this$0;

            public float getElapsedFraction(ValueAnimator valueanimator)
            {
                return getFraction();
            }

            
            {
                this$0 = TranslationAnimator.this;
                super();
            }
        });
        moveToFirst();
    }

    public void addEffect(EffectManager effectmanager)
    {
        mManager.addEffect(effectmanager);
    }

    public void addListener(android.animation.Animator.AnimatorListener animatorlistener)
    {
        mManager.addListener(animatorlistener);
    }

    public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        mManager.addUpdateListener(animatorupdatelistener);
    }

    public void animateToFirst()
    {
        animateToFirst(0L);
    }

    public void animateToFirst(long l)
    {
        if (!isAtFirst())
        {
            ValueAnimator valueanimator = getTranslationAnimator(mFirstX, mFirstY);
            valueanimator.setStartDelay(l);
            runFirstAnimator(valueanimator);
        }
    }

    public void animateToSecond()
    {
        animateToSecond(0L);
    }

    public void animateToSecond(long l)
    {
        if (!isAtSecond())
        {
            ValueAnimator valueanimator = getTranslationAnimator(mSecondX, mSecondY);
            valueanimator.setStartDelay(l);
            runSecondAnimator(valueanimator);
        }
    }

    public void animateToggle()
    {
        animateToggle(0L);
    }

    public void animateToggle(long l)
    {
        if (isAtFirst())
        {
            animateToSecond(l);
            return;
        } else
        {
            animateToFirst(l);
            return;
        }
    }

    public long getDuration()
    {
        return mDuration;
    }

    public ValueAnimator getFirstAnimator()
    {
        return getTranslationAnimator(mFirstX, mFirstY);
    }

    public int getFirstX()
    {
        return mFirstX;
    }

    public int getFirstY()
    {
        return mFirstY;
    }

    public float getFraction()
    {
        float f = ((View)mViews.get(0)).getTranslationX();
        float f1 = ((View)mViews.get(0)).getTranslationY();
        return (float)Math.hypot(f - (float)mFirstX, f1 - (float)mFirstY) / (float)Math.hypot(mSecondX - mFirstX, mSecondY - mFirstY);
    }

    public ValueAnimator getSecondAnimator()
    {
        return getTranslationAnimator(mSecondX, mSecondY);
    }

    public int getSecondX()
    {
        return mSecondX;
    }

    public int getSecondY()
    {
        return mSecondY;
    }

    public boolean isAtFirst()
    {
        return mAtFirst;
    }

    public boolean isAtSecond()
    {
        return !mAtFirst;
    }

    public void moveToFirst()
    {
        mAtFirst = true;
        mManager.cancelAnimator();
        View view;
        for (Iterator iterator = mViews.iterator(); iterator.hasNext(); view.setTranslationY(mFirstY))
        {
            view = (View)iterator.next();
            view.setTranslationX(mFirstX);
        }

    }

    public void moveToSecond()
    {
        mAtFirst = false;
        mManager.cancelAnimator();
        View view;
        for (Iterator iterator = mViews.iterator(); iterator.hasNext(); view.setTranslationY(mSecondY))
        {
            view = (View)iterator.next();
            view.setTranslationX(mSecondX);
        }

    }

    public void reduceDurationByElapsed(ValueAnimator valueanimator)
    {
        mManager.reduceDurationByElapsed(valueanimator);
    }

    public void reduceDurationByRemaining(ValueAnimator valueanimator)
    {
        mManager.reduceDurationByRemaining(valueanimator);
    }

    public void removeEffect(EffectManager effectmanager)
    {
        mManager.removeEffect(effectmanager);
    }

    public void removeListener(android.animation.Animator.AnimatorListener animatorlistener)
    {
        mManager.removeListener(animatorlistener);
    }

    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        mManager.removeUpdateListener(animatorupdatelistener);
    }

    public void runFirstAnimator(ValueAnimator valueanimator)
    {
        mAtFirst = true;
        mManager.runAnimatorForElapsed(valueanimator);
    }

    public void runSecondAnimator(ValueAnimator valueanimator)
    {
        mAtFirst = false;
        mManager.runAnimatorForRemaining(valueanimator);
    }

    public void setDuration(long l)
    {
        mDuration = l;
    }

    public void setFirst(int i, int j)
    {
        mFirstX = i;
        mFirstY = j;
    }

    public void setFirstAnimator(ValueAnimator valueanimator)
    {
        mAtFirst = true;
        mManager.setAnimator(valueanimator);
    }

    public void setInterpolator(TimeInterpolator timeinterpolator)
    {
        mInterpolator = timeinterpolator;
    }

    public void setSecond(int i, int j)
    {
        mSecondX = i;
        mSecondY = j;
    }

    public void setSecondAnimator(ValueAnimator valueanimator)
    {
        mAtFirst = false;
        mManager.setAnimator(valueanimator);
    }

    public void toggle()
    {
        if (isAtFirst())
        {
            moveToSecond();
            return;
        } else
        {
            moveToFirst();
            return;
        }
    }


}
