// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.HashSet;
import java.util.Iterator;

public final class AnimUtils
{

    static HashSet sAnimators = new HashSet();
    static com.nineoldandroids.animation.Animator.AnimatorListener sEndAnimListener = new com.nineoldandroids.animation.Animator.AnimatorListener() {

        public void onAnimationCancel(Animator animator)
        {
            AnimUtils.sAnimators.remove(animator);
        }

        public void onAnimationEnd(Animator animator)
        {
            AnimUtils.sAnimators.remove(animator);
        }

        public void onAnimationRepeat(Animator animator)
        {
        }

        public void onAnimationStart(Animator animator)
        {
        }

    };

    private AnimUtils()
    {
    }

    public static void cancelOnDestroyActivity(Animator animator)
    {
        sAnimators.add(animator);
        animator.addListener(sEndAnimListener);
    }

    public static AnimatorSet createAnimatorSet()
    {
        AnimatorSet animatorset = new AnimatorSet();
        cancelOnDestroyActivity(animatorset);
        return animatorset;
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.setTarget(obj);
        objectanimator.setPropertyName(s);
        objectanimator.setFloatValues(af);
        cancelOnDestroyActivity(objectanimator);
        return objectanimator;
    }

    public static transient ValueAnimator ofFloat(float af[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setFloatValues(af);
        cancelOnDestroyActivity(valueanimator);
        return valueanimator;
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.setTarget(obj);
        objectanimator.setValues(apropertyvaluesholder);
        cancelOnDestroyActivity(objectanimator);
        return objectanimator;
    }

    public static void onDestroyActivity()
    {
        for (Iterator iterator = (new HashSet(sAnimators)).iterator(); iterator.hasNext();)
        {
            Animator animator = (Animator)iterator.next();
            if (animator.isRunning())
            {
                animator.cancel();
            } else
            {
                sAnimators.remove(animator);
            }
        }

    }

}
