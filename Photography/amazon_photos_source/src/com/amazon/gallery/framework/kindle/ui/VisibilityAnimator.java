// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;

public abstract class VisibilityAnimator
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State APPEARING;
        public static final State DISAPPEARING;
        public static final State INVISIBLE;
        public static final State VISIBLE;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/amazon/gallery/framework/kindle/ui/VisibilityAnimator$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            DISAPPEARING = new State("DISAPPEARING", 0);
            INVISIBLE = new State("INVISIBLE", 1);
            APPEARING = new State("APPEARING", 2);
            VISIBLE = new State("VISIBLE", 3);
            $VALUES = (new State[] {
                DISAPPEARING, INVISIBLE, APPEARING, VISIBLE
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private ValueAnimator activeAnimator;
    private final android.animation.Animator.AnimatorListener hideAnimatorListener = new AnimatorListenerAdapter() {

        final VisibilityAnimator this$0;

        public void onAnimationEnd(Animator animator)
        {
            view.setVisibility(4);
            state = State.INVISIBLE;
            activeAnimator = null;
            onHidden();
        }

            
            {
                this$0 = VisibilityAnimator.this;
                super();
            }
    };
    private final android.animation.Animator.AnimatorListener showAnimatorListener = new AnimatorListenerAdapter() {

        final VisibilityAnimator this$0;

        public void onAnimationEnd(Animator animator)
        {
            state = State.VISIBLE;
            activeAnimator = null;
            onShown();
        }

        public void onAnimationStart(Animator animator)
        {
            view.setVisibility(0);
        }

            
            {
                this$0 = VisibilityAnimator.this;
                super();
            }
    };
    private State state;
    private View view;

    public VisibilityAnimator()
    {
    }

    private void startNewAnimation(ValueAnimator valueanimator, android.animation.Animator.AnimatorListener animatorlistener)
    {
        valueanimator.setDuration(getDuration());
        valueanimator.addListener(animatorlistener);
        activeAnimator = valueanimator;
        valueanimator.start();
    }

    public void cancel()
    {
        ValueAnimator valueanimator = activeAnimator;
        if (valueanimator != null)
        {
            valueanimator.cancel();
        }
    }

    protected abstract long getDuration();

    protected abstract ValueAnimator getHideAnimator();

    protected abstract ValueAnimator getShowAnimator();

    public void hide()
    {
        if (state == State.DISAPPEARING)
        {
            return;
        } else
        {
            cancel();
            state = State.DISAPPEARING;
            startNewAnimation(getHideAnimator(), hideAnimatorListener);
            return;
        }
    }

    protected void onHidden()
    {
    }

    protected void onShown()
    {
    }

    public void setView(View view1)
    {
        view = view1;
        if (view1.getVisibility() == 8 || view1.getVisibility() == 4)
        {
            view1 = State.INVISIBLE;
        } else
        {
            view1 = State.VISIBLE;
        }
        state = view1;
    }

    public void show()
    {
        if (state == State.APPEARING)
        {
            return;
        } else
        {
            cancel();
            state = State.APPEARING;
            startNewAnimation(getShowAnimator(), showAnimatorListener);
            return;
        }
    }



/*
    static State access$102(VisibilityAnimator visibilityanimator, State state1)
    {
        visibilityanimator.state = state1;
        return state1;
    }

*/


/*
    static ValueAnimator access$202(VisibilityAnimator visibilityanimator, ValueAnimator valueanimator)
    {
        visibilityanimator.activeAnimator = valueanimator;
        return valueanimator;
    }

*/
}
