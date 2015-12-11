// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.common.a.a;
import com.target.mothership.common.a.e;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import java.math.BigDecimal;
import java.util.List;

public class CartHeaderView extends LinearLayout
    implements android.view.View.OnClickListener
{
    private class a
    {

        ImageButton cartFullBannerCloseButton;
        View cartFullBannerView;
        ImageButton cartMergeBannerCloseButton;
        View cartMergeBannerView;
        View freeShippingView;
        ImageButton shippingBannerCloseButton;
        TextView shippingThresholdText;
        final CartHeaderView this$0;

        public a(View view)
        {
            this$0 = CartHeaderView.this;
            super();
            freeShippingView = view.findViewById(0x7f10034c);
            shippingThresholdText = (TextView)freeShippingView.findViewById(0x7f10034f);
            shippingBannerCloseButton = (ImageButton)freeShippingView.findViewById(0x7f100351);
            cartMergeBannerView = view.findViewById(0x7f10031b);
            cartMergeBannerCloseButton = (ImageButton)cartMergeBannerView.findViewById(0x7f10031c);
            cartFullBannerView = view.findViewById(0x7f100313);
            cartFullBannerCloseButton = (ImageButton)cartFullBannerView.findViewById(0x7f100314);
        }
    }


    private boolean mIsCartFullBannerDismissed;
    private boolean mIsCartMergeBannerDismissed;
    private boolean mIsShippingBannerDismissed;
    private a mViews;

    public CartHeaderView(Context context)
    {
        super(context);
        mIsShippingBannerDismissed = false;
        mIsCartMergeBannerDismissed = false;
        mIsCartFullBannerDismissed = false;
        a(context);
    }

    public CartHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsShippingBannerDismissed = false;
        mIsCartMergeBannerDismissed = false;
        mIsCartFullBannerDismissed = false;
        a(context);
    }

    public CartHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsShippingBannerDismissed = false;
        mIsCartMergeBannerDismissed = false;
        mIsCartFullBannerDismissed = false;
        a(context);
    }

    private void a(Context context)
    {
        setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -1));
        mViews = new a(LayoutInflater.from(context).inflate(0x7f03010e, this, true));
    }

    private void a(View view)
    {
        aj.a(view, new AnimatorListenerAdapter() {

            final CartHeaderView this$0;

            public void onAnimationEnd(Animator animator)
            {
                if (!com.target.ui.view.cart.CartHeaderView.a(CartHeaderView.this))
                {
                    CartHeaderView.b(CartHeaderView.this);
                }
            }

            
            {
                this$0 = CartHeaderView.this;
                super();
            }
        });
    }

    private void a(CartDetails cartdetails)
    {
        if (mIsCartMergeBannerDismissed)
        {
            return;
        }
        if (cartdetails.e() != null && !cartdetails.e().isEmpty())
        {
            cartdetails = cartdetails.e();
            if (cartdetails.contains(com.target.mothership.common.a.a.CART_MERGE) || cartdetails.contains(com.target.mothership.common.a.a.CART_MERGE_OVERFLOW))
            {
                mViews.cartMergeBannerCloseButton.setOnClickListener(this);
                al.b(mViews.cartMergeBannerView);
                return;
            }
        }
        al.c(mViews.cartMergeBannerView);
    }

    private boolean a()
    {
        return al.a(mViews.cartFullBannerView) || al.a(mViews.cartMergeBannerView) || al.a(mViews.freeShippingView);
    }

    static boolean a(CartHeaderView cartheaderview)
    {
        return cartheaderview.a();
    }

    private void b()
    {
        setPadding(0, getResources().getDimensionPixelSize(0x7f0a00dd), 0, getResources().getDimensionPixelSize(0x7f0a00dd));
    }

    private void b(CartDetails cartdetails)
    {
        if (mIsCartFullBannerDismissed)
        {
            return;
        }
        if (cartdetails.a().size() >= 20)
        {
            mViews.cartFullBannerCloseButton.setOnClickListener(this);
            al.b(mViews.cartFullBannerView);
            return;
        } else
        {
            al.c(mViews.cartFullBannerView);
            return;
        }
    }

    private void b(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        if (mIsShippingBannerDismissed)
        {
            return;
        }
        if (!c(cartdetails, freeshippingpromotion))
        {
            al.c(mViews.freeShippingView);
            return;
        }
        cartdetails = new StringBuilder(" ");
        cartdetails.append("$");
        if (freeshippingpromotion != null)
        {
            cartdetails.append(freeshippingpromotion.a());
        } else
        {
            cartdetails.append(com.target.ui.fragment.a.FREE_SHIPPING_THRESHOLD);
        }
        cartdetails.append(" ");
        mViews.shippingThresholdText.setText(cartdetails);
        mViews.shippingBannerCloseButton.setOnClickListener(this);
        al.b(mViews.freeShippingView);
    }

    static void b(CartHeaderView cartheaderview)
    {
        cartheaderview.c();
    }

    private void c()
    {
        setPadding(0, 0, 0, 0);
    }

    private boolean c(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        if (freeshippingpromotion != null) goto _L2; else goto _L1
_L1:
        if (cartdetails.c().compareTo(com.target.ui.fragment.a.FREE_SHIPPING_THRESHOLD) < 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        return true;
_L2:
        if (freeshippingpromotion.b() != e.Inactive && cartdetails.c().compareTo(freeshippingpromotion.a()) < 0)
        {
            return true;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void a(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        a(cartdetails);
        b(cartdetails);
        b(cartdetails, freeshippingpromotion);
        if (a())
        {
            b();
            return;
        } else
        {
            c();
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755857: 
            mIsShippingBannerDismissed = true;
            a(mViews.freeShippingView);
            // fall through

        case 2131755804: 
            mIsCartMergeBannerDismissed = true;
            a(mViews.cartMergeBannerView);
            return;

        case 2131755796: 
            mIsCartFullBannerDismissed = true;
            a(mViews.cartFullBannerView);
            return;
        }
    }
}
