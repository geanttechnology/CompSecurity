// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.lifecycle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnimatorTracker
{

    private List mAnimators;

    public AnimatorTracker()
    {
        mAnimators = new ArrayList();
    }

    public void add(final Animator animator)
    {
        animator.addListener(new AnimatorListenerAdapter() {

            final AnimatorTracker this$0;
            final Animator val$animator;

            public void onAnimationEnd(Animator animator1)
            {
                remove(animator);
            }

            
            {
                this$0 = AnimatorTracker.this;
                animator = animator1;
                super();
            }
        });
        mAnimators.add(animator);
    }

    public void cancelAll()
    {
        for (Iterator iterator = (new ArrayList(mAnimators)).iterator(); iterator.hasNext(); ((Animator)iterator.next()).cancel()) { }
        mAnimators.clear();
    }

    public void endAll()
    {
        for (Iterator iterator = (new ArrayList(mAnimators)).iterator(); iterator.hasNext(); ((Animator)iterator.next()).end()) { }
        mAnimators.clear();
    }

    public void remove(Animator animator)
    {
        mAnimators.remove(animator);
    }
}
