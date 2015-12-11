// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.goods.shoppingcart.model.CartIconClickExtraInfo;
import com.groupon.service.ShoppingCartService;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class ShoppingCartIconView extends FrameLayout
{
    private class OnShoppingCartButtonClickListener
        implements android.view.View.OnClickListener
    {

        final ShoppingCartIconView this$0;

        public void onClick(View view)
        {
            view = new CartIconClickExtraInfo();
            view.cartSize = shoppingCartService.getCartItemsCount();
            logger.logClick("", "cart", context.getClass().getSimpleName(), Logger.NULL_NST_FIELD, view);
            context.startActivity(shoppingCartService.getOpenCartIntent());
        }

        private OnShoppingCartButtonClickListener()
        {
            this$0 = ShoppingCartIconView.this;
            super();
        }

    }

    private class ShoppingCartAnimationListener
        implements android.view.animation.Animation.AnimationListener
    {

        final ShoppingCartIconView this$0;

        public void onAnimationEnd(Animation animation)
        {
            byte byte0 = 8;
            if (animation == newBadgeAnimation)
            {
                newBadge.setVisibility(8);
                counter.setText(String.valueOf(count));
                animation = counter;
                if (count > 0)
                {
                    byte0 = 0;
                }
                animation.setVisibility(byte0);
                counter.startAnimation(counterAnimation);
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        private ShoppingCartAnimationListener()
        {
            this$0 = ShoppingCartIconView.this;
            super();
        }

    }


    private final Context context;
    private int count;
    TextView counter;
    private final Animation counterAnimation;
    ImageView image;
    private final Animation imageAnimation;
    private Logger logger;
    TextView newBadge;
    private final Animation newBadgeAnimation;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartIconView(Context context1)
    {
        this(context1, null, 0);
    }

    public ShoppingCartIconView(Context context1, AttributeSet attributeset)
    {
        this(context1, attributeset, 0);
    }

    public ShoppingCartIconView(Context context1, AttributeSet attributeset, int i)
    {
        super(context1, attributeset, i);
        context = context1;
        imageAnimation = AnimationUtils.loadAnimation(context1, 0x7f04000f);
        counterAnimation = AnimationUtils.loadAnimation(context1, 0x7f04000d);
        newBadgeAnimation = AnimationUtils.loadAnimation(context1, 0x7f04000e);
        RoboGuice.getInjector(context1).injectMembers(this);
        inflate(context1, 0x7f0301fb, this);
        ButterKnife.bind(this);
    }

    public void animateShoppingCartImage()
    {
        image.startAnimation(imageAnimation);
    }

    public void configureShoppingCartIcon(boolean flag)
    {
        if (flag)
        {
            setVisibility(0);
            setOnClickListener(new OnShoppingCartButtonClickListener());
            updateShoppingCartCounter(shoppingCartService.getCartItemsCount());
            return;
        } else
        {
            setVisibility(8);
            setOnClickListener(null);
            return;
        }
    }

    public void updateShoppingCartCounter(int i)
    {
        byte byte0;
        boolean flag;
        byte0 = 8;
        flag = false;
        if (!shoppingCartService.getCartInAppMessageViewed())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        if (newBadge.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        count = i;
        newBadgeAnimation.setAnimationListener(new ShoppingCartAnimationListener());
        newBadge.startAnimation(newBadgeAnimation);
_L4:
        return;
_L2:
        String s;
        s = counter.getText().toString();
        counter.setText(String.valueOf(i));
        TextView textview1 = counter;
        if (i > 0)
        {
            byte0 = 0;
        }
        textview1.setVisibility(byte0);
        if (s != null && !s.equals(String.valueOf(0))) goto _L4; else goto _L3
_L3:
        counter.startAnimation(counterAnimation);
        return;
        newBadge.setVisibility(0);
        TextView textview = counter;
        if (i > 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
        return;
    }






}
