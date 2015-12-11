// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

public class ShoppingCartFlyout extends RelativeLayout
{
    private class OnAnimationEndListener extends AnimatorListenerAdapter
    {

        private final int initialVisibility;
        final ShoppingCartFlyout this$0;

        public void onAnimationEnd(Animator animator)
        {
            stopPositionAnimation();
            animator = ShoppingCartFlyout.this;
            byte byte0;
            if (initialVisibility == 0)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            animator.setVisibility(byte0);
        }

        public OnAnimationEndListener(int i)
        {
            this$0 = ShoppingCartFlyout.this;
            super();
            initialVisibility = i;
        }
    }

    private class OnShoppingCartMessageClick
        implements android.view.View.OnClickListener
    {

        final ShoppingCartFlyout this$0;

        public void onClick(View view)
        {
            hideShoppingCartInAppMessagesDrawer();
        }

        private OnShoppingCartMessageClick()
        {
            this$0 = ShoppingCartFlyout.this;
            super();
        }

    }


    private static final long IN_APP_MESSAGES_ANIMATION_DURATION = 400L;
    private boolean isVisible;
    private ObjectAnimator positionAnimator;

    public ShoppingCartFlyout(Context context)
    {
        this(context, null, 0);
    }

    public ShoppingCartFlyout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ShoppingCartFlyout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03005b, this);
        setOnClickListener(new OnShoppingCartMessageClick());
    }

    private void startShoppingCartInAppMessagesDrawerAnimation(int i, float f, float f1)
    {
        stopPositionAnimation();
        positionAnimator = ObjectAnimator.ofFloat(this, "y", new float[] {
            f, f1
        });
        positionAnimator.setInterpolator(new DecelerateInterpolator());
        positionAnimator.setDuration(400L);
        positionAnimator.addListener(new OnAnimationEndListener(i));
        positionAnimator.start();
    }

    public void hideShoppingCartInAppMessagesDrawer()
    {
        if (getVisibility() == 0 && isVisible)
        {
            isVisible = false;
            float f = getHeight();
            startShoppingCartInAppMessagesDrawerAnimation(getVisibility(), 0.0F, -f);
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(null);
        findViewById(0x7f100184).setOnClickListener(onclicklistener);
    }

    public void showShoppingCartInAppMessagesDrawer()
    {
        if (getVisibility() != 0 && !isVisible)
        {
            isVisible = true;
            float f1 = getHeight();
            int i = getVisibility();
            float f = getResources().getDimension(0x7f0b0084);
            f1 = f - f1;
            setY(f1);
            setVisibility(0);
            startShoppingCartInAppMessagesDrawerAnimation(i, f1, f);
        }
    }

    public void stopPositionAnimation()
    {
        if (positionAnimator != null)
        {
            positionAnimator.removeAllListeners();
            positionAnimator.cancel();
            positionAnimator = null;
        }
    }
}
