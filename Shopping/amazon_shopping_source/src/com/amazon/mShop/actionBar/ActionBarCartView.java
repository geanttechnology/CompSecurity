// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.control.cart.CartSubscriber;
import com.amazon.mShop.web.MShopWebViewNotification;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.CartItems;

public class ActionBarCartView extends FrameLayout
    implements CartSubscriber, com.amazon.mShop.web.MShopWebViewNotification.WebCartSubscriber
{

    private static int mCurrentQuantity = CartController.getInstance().getCartTotalQuantity();
    private TextView mCartTextView;

    public ActionBarCartView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public static int getCurrentQuantity()
    {
        return mCurrentQuantity;
    }

    public static void setCurrentQuantity(int i)
    {
        mCurrentQuantity = i;
    }

    private void updateActionBarCart(int i)
    {
        mCurrentQuantity = i;
        updateCartCount();
    }

    private void updateCartCount()
    {
        int ai[];
        String s;
        TextView textview;
        if (mCurrentQuantity <= 9)
        {
            mCartTextView.setTextSize(0, getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.action_bar_cart_text_size));
        } else
        {
            mCartTextView.setTextSize(0, getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.action_bar_cart_smaller_text_size));
        }
        ai = getCartPadding();
        mCartTextView.setPadding(ai[0], ai[1], ai[2], ai[3]);
        textview = mCartTextView;
        if (mCurrentQuantity > 99)
        {
            s = getContext().getString(com.amazon.mShop.android.lib.R.string.max_cart_quantity);
        } else
        {
            s = String.valueOf(mCurrentQuantity);
        }
        textview.setText(s);
    }

    public int[] getCartPadding()
    {
        int i;
        int j;
        if (mCurrentQuantity <= 9)
        {
            j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_left_v2);
            i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_bottom_v2);
        } else
        if (mCurrentQuantity <= 99)
        {
            j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_left_v2);
            i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_bottom_two_digits);
        } else
        {
            j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_left_three_digits);
            i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.cart_number_padding_bottom_three_digits);
        }
        return (new int[] {
            j, 0, 0, i
        });
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        CartController.getInstance().addCartSubscriber(this);
        MShopWebViewNotification.addWebCartSubscriber(this);
        updateCartCount();
    }

    public void onCartCountChanged(int i)
    {
        updateActionBarCart(i);
    }

    public void onCartDidUpdateCheckOutTimerForItem(CartItem cartitem)
    {
    }

    public void onCartReceived(CartItems cartitems)
    {
        updateActionBarCart(CartController.getInstance().getCartTotalQuantity());
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        CartController.getInstance().removeCartSubscriber(this);
        MShopWebViewNotification.removeWebCartSubscriber(this);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
    }

    protected void onFinishInflate()
    {
        mCartTextView = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.action_bar_cart_count);
    }

}
