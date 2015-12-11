// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

public class ExpandableStickyListAnimator
    implements se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView.IAnimationExecutor
{

    public static final int DURATION = 200;
    private final int defaultHeightPx;
    private final Map originalViewHeightPool = new WeakHashMap();

    public ExpandableStickyListAnimator(int i)
    {
        defaultHeightPx = i;
    }

    private boolean isCollapsing(int i)
    {
        return i == 1;
    }

    private boolean isExpanding(int i)
    {
        return i == 0;
    }

    public void executeAnim(final View target, final int animType)
    {
        while (isExpanding(animType) && target.getVisibility() == 0 || isCollapsing(animType) && target.getVisibility() != 0) 
        {
            return;
        }
        float f;
        float f1;
        final int viewHeight;
        if (originalViewHeightPool.get(target) == null)
        {
            viewHeight = target.getHeight();
            Object obj = originalViewHeightPool;
            if (viewHeight <= 0)
            {
                viewHeight = defaultHeightPx;
            }
            ((Map) (obj)).put(target, Integer.valueOf(viewHeight));
        }
        viewHeight = ((Integer)originalViewHeightPool.get(target)).intValue();
        if (isExpanding(animType))
        {
            f = 0.0F;
        } else
        {
            f = viewHeight;
        }
        if (isExpanding(animType))
        {
            f1 = viewHeight;
        } else
        {
            f1 = 0.0F;
        }
        obj = ValueAnimator.ofFloat(new float[] {
            f, f1
        });
        ((ValueAnimator) (obj)).setDuration(200L);
        target.setVisibility(0);
        ((ValueAnimator) (obj)).addListener(new AnimatorListenerAdapter() {

            final ExpandableStickyListAnimator this$0;
            final int val$animType;
            final View val$target;
            final int val$viewHeight;

            public void onAnimationEnd(Animator animator)
            {
                animator = target;
                int i;
                if (isExpanding(animType))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                animator.setVisibility(i);
                target.getLayoutParams().height = viewHeight;
            }

            
            {
                this$0 = ExpandableStickyListAnimator.this;
                target = view;
                animType = i;
                viewHeight = j;
                super();
            }
        });
        ((ValueAnimator) (obj)).addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final ExpandableStickyListAnimator this$0;
            final android.view.ViewGroup.LayoutParams val$lp;
            final View val$target;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                lp.height = ((Float)valueanimator.getAnimatedValue()).intValue();
                target.setLayoutParams(lp);
                target.requestLayout();
            }

            
            {
                this$0 = ExpandableStickyListAnimator.this;
                lp = layoutparams;
                target = view;
                super();
            }
        });
        ((ValueAnimator) (obj)).start();
    }

}
