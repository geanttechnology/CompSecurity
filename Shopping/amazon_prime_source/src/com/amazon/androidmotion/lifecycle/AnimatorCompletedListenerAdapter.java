// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.lifecycle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public abstract class AnimatorCompletedListenerAdapter extends AnimatorListenerAdapter
{

    private boolean mCanceled;

    public AnimatorCompletedListenerAdapter()
    {
        mCanceled = false;
    }

    public void onAnimationCancel(Animator animator)
    {
        mCanceled = true;
    }

    public void onAnimationComplete(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!mCanceled)
        {
            onAnimationComplete(animator);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        mCanceled = false;
    }
}
