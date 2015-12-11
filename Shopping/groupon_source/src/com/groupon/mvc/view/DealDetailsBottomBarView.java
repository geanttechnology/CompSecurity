// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;
import com.groupon.callbacks.OnBuyButtonClickListener;
import com.groupon.goods.shoppingcart.view.ShoppingCartIconView;
import com.groupon.service.core.AbTestService;
import com.groupon.view.SpinnerButton;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class DealDetailsBottomBarView extends FrameLayout
{

    public static final int ANIMATION_DURATION_SHORT = 200;
    private AbTestService abTestService;
    protected boolean bottomBarAnimationShown;
    View bottomBarLeftContainer;
    SpinnerButton buyButton;
    private OnBuyButtonClickListener buyButtonClickListener;
    TextView buyButtonOverlayText;
    View freeShippingBand;
    public boolean isBuyButtonNormalTypeFace;
    ShoppingCartIconView shoppingCartButton;
    View timeLeftContainer;
    TextView timeLeftLabelView;
    TextView timeLeftUrgencyPricingLabelView;
    TextView timeLeftView;

    public DealDetailsBottomBarView(Context context)
    {
        this(context, null);
    }

    public DealDetailsBottomBarView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DealDetailsBottomBarView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        isBuyButtonNormalTypeFace = false;
        inflate(context, 0x7f0300c0, this);
        if (!isInEditMode())
        {
            ButterKnife.bind(this);
            RoboGuice.getInjector(context).injectMembers(this);
        }
    }

    public void animateShoppingCartButton()
    {
        shoppingCartButton.animateShoppingCartImage();
    }

    public void setOnBuyButtonClickListener(OnBuyButtonClickListener onbuybuttonclicklistener)
    {
        buyButtonClickListener = onbuybuttonclicklistener;
    }

    public void slideInBottomBar(final OnBottomBarAnimationFinishedListener animationFinishedCallback)
    {
        if (bottomBarAnimationShown)
        {
            setVisibility(0);
            return;
        } else
        {
            setVisibility(4);
            getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final DealDetailsBottomBarView this$0;
                final OnBottomBarAnimationFinishedListener val$animationFinishedCallback;

                public void onGlobalLayout()
                {
                    float f = getY();
                    setY(getBottom());
                    setVisibility(0);
                    animate().setListener(new AnimatorListenerAdapter() {

                        final _cls2 this$1;

                        public void onAnimationEnd(Animator animator)
                        {
                            if (animationFinishedCallback != null)
                            {
                                animationFinishedCallback.onBottomBarAnimationFinished(_fld0);
                            }
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).y(f).setDuration(200L).setInterpolator(new DecelerateInterpolator());
                    bottomBarAnimationShown = true;
                    ViewTreeObserver viewtreeobserver = getViewTreeObserver();
                    if (viewtreeobserver.isAlive())
                    {
                        viewtreeobserver.removeOnGlobalLayoutListener(this);
                    }
                }

            
            {
                this$0 = DealDetailsBottomBarView.this;
                animationFinishedCallback = onbottombaranimationfinishedlistener;
                super();
            }
            });
            return;
        }
    }

    public void slideOutBottomBar(final OnBottomBarAnimationFinishedListener animationFinishedCallback)
    {
        animate().yBy(getHeight()).setDuration(200L).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {

            final DealDetailsBottomBarView this$0;
            final OnBottomBarAnimationFinishedListener val$animationFinishedCallback;

            public void onAnimationEnd(Animator animator)
            {
                if (animationFinishedCallback != null)
                {
                    animationFinishedCallback.onBottomBarAnimationFinished(DealDetailsBottomBarView.this);
                }
            }

            
            {
                this$0 = DealDetailsBottomBarView.this;
                animationFinishedCallback = onbottombaranimationfinishedlistener;
                super();
            }
        });
    }

    public void startBuyButtonTextAnimation(String s, Animation animation)
    {
        buyButtonOverlayText.setText(s);
        buyButtonOverlayText.setOnClickListener(null);
        buyButtonOverlayText.setVisibility(0);
        buyButton.setText(Html.fromHtml(""));
        buyButtonOverlayText.startAnimation(animation);
    }

    public void updateBuyButton(String s, int i, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        buyButton.setEnabled(flag);
        if (isBuyButtonNormalTypeFace)
        {
            buyButton.setTypeface(null, 0);
        }
        buyButton.setText(Html.fromHtml(s));
        buyButton.setBackgroundResource(i);
        buyButton.setOnClickListener(new android.view.View.OnClickListener() {

            final DealDetailsBottomBarView this$0;

            public void onClick(View view)
            {
                if (buyButtonClickListener != null)
                {
                    abTestService.isVariantEnabled("AAforDealDetailsContinueClick1510", "On");
                    buyButtonClickListener.onBuyButtonClick(view);
                }
            }

            
            {
                this$0 = DealDetailsBottomBarView.this;
                super();
            }
        });
        s = freeShippingBand;
        if (flag1)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
    }

    public void updateBuyButtonText(String s)
    {
        buyButton.setText(Html.fromHtml(s));
        buyButtonOverlayText.clearAnimation();
        buyButtonOverlayText.setText("");
        buyButtonOverlayText.setVisibility(8);
    }

    public void updateShoppingCartCounter(int i)
    {
        shoppingCartButton.updateShoppingCartCounter(i);
    }

    public void updateShoppingCartVisibility(boolean flag)
    {
        shoppingCartButton.configureShoppingCartIcon(flag);
    }

    public void updateTimeLeft(String s, boolean flag, boolean flag1, boolean flag2)
    {
        boolean flag3 = false;
        int i;
        if (bottomBarLeftContainer != null)
        {
            Object obj = bottomBarLeftContainer;
            if (flag2)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            ((View) (obj)).setVisibility(i);
        }
        obj = timeLeftContainer;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = timeLeftLabelView;
        if (flag1)
        {
            i = ((flag3) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        if (flag)
        {
            timeLeftView.setText(s);
        }
    }

    public void updateTimeLeftUrgencyPricing(String s)
    {
        timeLeftUrgencyPricingLabelView.setText(s);
        TextView textview = timeLeftUrgencyPricingLabelView;
        int i;
        if (Strings.notEmpty(s))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }


}
