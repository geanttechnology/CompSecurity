// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

public class PulseView extends FrameLayout
{
    private class a
        implements android.view.animation.Animation.AnimationListener
    {

        protected boolean repeat;
        protected boolean stopGracefully;
        final PulseView this$0;

        public void a()
        {
            stopGracefully = true;
        }

        public void onAnimationEnd(Animation animation)
        {
            PulseView.a(PulseView.this, false);
        }

        public void onAnimationRepeat(Animation animation)
        {
            boolean flag = false;
            if (!stopGracefully || repeat) goto _L2; else goto _L1
_L1:
            mChildView.clearAnimation();
_L4:
            if (!repeat)
            {
                flag = true;
            }
            repeat = flag;
            return;
_L2:
            if (!stopGracefully && repeat)
            {
                mPulseBackground.setVisibility(0);
                mPulseBackground.startAnimation(PulseView.a(PulseView.this));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onAnimationStart(Animation animation)
        {
            mPulseBackground.setVisibility(0);
            mPulseBackground.startAnimation(PulseView.a(PulseView.this));
        }

        private a()
        {
            this$0 = PulseView.this;
            super();
            stopGracefully = false;
            repeat = false;
        }

    }


    View mChildView;
    private Animation mExpandFadeAnimation;
    private Animation mPulseAnimation;
    private a mPulseAnimationListener;
    View mPulseBackground;
    private boolean mPulsing;

    public PulseView(Context context)
    {
        super(context);
        a(context, ((AttributeSet) (null)));
    }

    public PulseView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public PulseView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    static Animation a(PulseView pulseview)
    {
        return pulseview.mExpandFadeAnimation;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        inflate(context, 0x7f0301c8, this);
        mPulseBackground = findViewById(0x7f100557);
        mExpandFadeAnimation = AnimationUtils.loadAnimation(getContext(), 0x7f04000a);
        mPulseAnimation = AnimationUtils.loadAnimation(getContext(), 0x7f040011);
    }

    static boolean a(PulseView pulseview, boolean flag)
    {
        pulseview.mPulsing = flag;
        return flag;
    }

    public void a()
    {
        if (mPulsing)
        {
            return;
        }
        if (getChildCount() != 2)
        {
            throw new IllegalStateException("PulseView must have exactly 1 child view");
        } else
        {
            mChildView = getChildAt(1);
            mPulseBackground.setLayoutParams(mChildView.getLayoutParams());
            mPulseAnimationListener = new a();
            mPulseAnimation.setAnimationListener(mPulseAnimationListener);
            mPulsing = true;
            mChildView.startAnimation(mPulseAnimation);
            return;
        }
    }

    public void b()
    {
        if (mPulseAnimationListener == null)
        {
            return;
        } else
        {
            mPulseAnimationListener.a();
            return;
        }
    }
}
