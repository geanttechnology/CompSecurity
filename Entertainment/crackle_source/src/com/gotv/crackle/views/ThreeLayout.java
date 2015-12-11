// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.gotv.crackle.views:
//            SlideAnimation

public class ThreeLayout extends RelativeLayout
{

    private Interpolator interpolator;
    long mAnimationDuration;
    private RelativeLayout mContainer;
    private LinearLayout mLeftPane;
    private FrameLayout mMiddlePane;
    private FrameLayout mRightPane;
    private int panel;
    private int width;

    public ThreeLayout(Context context)
    {
        super(context);
        mAnimationDuration = 800L;
        interpolator = new LinearInterpolator();
    }

    public ThreeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAnimationDuration = 800L;
        interpolator = new LinearInterpolator();
    }

    public ThreeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mAnimationDuration = 800L;
        interpolator = new LinearInterpolator();
    }

    private void hideAnimation()
    {
        showView1();
    }

    private void hideView1()
    {
        SlideAnimation slideanimation = new SlideAnimation(mLeftPane, 0.0F, -mLeftPane.getWidth(), 0.0F, 0.0F);
        slideanimation.setInterpolator(interpolator);
        slideanimation.setDuration(mAnimationDuration);
        mLeftPane.startAnimation(slideanimation);
    }

    private void initWithDimentions()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.setMargins(0, 0, -width - panel, 0);
        mContainer.setLayoutParams(layoutparams);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(panel, -1);
        mLeftPane.setLayoutParams(layoutparams);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(width - panel, -1);
        layoutparams.addRule(1, 0x7f0a0178);
        mMiddlePane.setLayoutParams(layoutparams);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(panel, -1);
        layoutparams.addRule(1, 0x7f0a017b);
        mRightPane.setLayoutParams(layoutparams);
        mRightPane.setVisibility(4);
    }

    private void showAnimation()
    {
        hideView1();
    }

    private void showView1()
    {
        SlideAnimation slideanimation = new SlideAnimation(mLeftPane, -mLeftPane.getWidth(), 0.0F, 0.0F, 0.0F);
        slideanimation.setInterpolator(interpolator);
        slideanimation.setDuration(mAnimationDuration);
        mLeftPane.startAnimation(slideanimation);
        mMiddlePane.invalidate();
    }

    public LinearLayout getLeftLayout()
    {
        return mLeftPane;
    }

    public FrameLayout getMiddleLayout()
    {
        return mMiddlePane;
    }

    public FrameLayout getRightLayout()
    {
        return mRightPane;
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        mContainer = (RelativeLayout)findViewById(0x7f0a0177);
        mLeftPane = (LinearLayout)findViewById(0x7f0a0178);
        mMiddlePane = (FrameLayout)findViewById(0x7f0a017b);
        mRightPane = (FrameLayout)findViewById(0x7f0a017c);
        post(new Runnable() {

            final ThreeLayout this$0;

            public void run()
            {
                width = getWidth();
                panel = (width / 3) * 2;
                initWithDimentions();
            }

            
            {
                this$0 = ThreeLayout.this;
                super();
            }
        });
    }

    public void setAnimationDuration(long l)
    {
        mAnimationDuration = l;
    }

    public void setInterpolator(Interpolator interpolator1)
    {
        interpolator = interpolator1;
    }

    public void setRightLayoutVisibility(boolean flag)
    {
        if (flag)
        {
            mRightPane.setVisibility(0);
            return;
        } else
        {
            mRightPane.setVisibility(4);
            return;
        }
    }

    public void startLeftAnimation()
    {
        showAnimation();
    }

    public void startRightAnimation()
    {
        hideAnimation();
    }



/*
    static int access$002(ThreeLayout threelayout, int i)
    {
        threelayout.width = i;
        return i;
    }

*/


/*
    static int access$102(ThreeLayout threelayout, int i)
    {
        threelayout.panel = i;
        return i;
    }

*/

}
