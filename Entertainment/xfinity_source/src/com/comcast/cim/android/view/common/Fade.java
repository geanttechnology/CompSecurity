// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Fade
{

    private long mDuration;
    private boolean mDurationSet;

    public Fade()
    {
        mDurationSet = false;
        mDuration = 300L;
    }

    public void hide(final View view, final int visibility)
    {
        if (view.getVisibility() == 0 && (visibility == 4 || visibility == 8))
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
                1.0F, 0.0F
            });
            if (mDurationSet)
            {
                objectanimator.setDuration(mDuration);
            }
            objectanimator.addListener(new AnimatorListenerAdapter() {

                final Fade this$0;
                final View val$view;
                final int val$visibility;

                public void onAnimationEnd(Animator animator)
                {
                    view.setAlpha(1.0F);
                    view.setVisibility(visibility);
                    view.animate().setListener(null);
                }

            
            {
                this$0 = Fade.this;
                view = view1;
                visibility = i;
                super();
            }
            });
            objectanimator.start();
        }
    }

    public void setDuration(long l)
    {
        if (l >= 0L)
        {
            mDurationSet = true;
            mDuration = l;
        }
    }

    public void show(View view)
    {
        if (view.getVisibility() != 0)
        {
            view.setAlpha(0.0F);
            view.setVisibility(0);
            view = ObjectAnimator.ofFloat(view, "alpha", new float[] {
                0.0F, 1.0F
            });
            if (mDurationSet)
            {
                view.setDuration(mDuration);
            }
            view.start();
        }
    }
}
