// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.OrderSummary;
import com.target.mothership.util.c;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.util.al;
import com.target.ui.view.a;
import java.math.BigDecimal;
import java.util.List;

public class SummaryView extends LinearLayout
{
    static class Views extends a
    {

        TextView handlingFeeText;
        View handlingFeesDivider;
        FrameLayout handlingFeesLayout;
        View savingsDivider;
        FrameLayout savingsLayout;
        TextView savingsText;
        TextView shippingChargeText;
        View shippingDivider;
        View shippingView;
        View stateFeesDivider;
        FrameLayout stateFeesLayout;
        TextView stateFeesText;
        TextView subtotalText;
        View taxErrorView;
        TextView taxText;
        TextView totalText;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public SummaryView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public SummaryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public SummaryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(OrderSummary ordersummary)
    {
        if (ordersummary.e().compareTo(c.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.handlingFeesLayout, mViews.handlingFeesDivider
            });
            return;
        }
        al.b(new View[] {
            mViews.handlingFeesLayout, mViews.handlingFeesDivider
        });
        if (ordersummary.f().compareTo(c.ZERO) == 0 || ordersummary.f().abs().compareTo(ordersummary.e()) != 0)
        {
            mViews.handlingFeeText.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
            mViews.handlingFeeText.setText((new StringBuilder()).append("$").append(ordersummary.e()).toString());
            return;
        } else
        {
            setTextViewCopyToFree(mViews.handlingFeeText);
            return;
        }
    }

    private void b(OrderSummary ordersummary, DeliveryDetailsModel deliverydetailsmodel)
    {
        if (deliverydetailsmodel != null && deliverydetailsmodel.a() != null && deliverydetailsmodel.a().a().isEmpty())
        {
            al.a(new View[] {
                mViews.shippingView, mViews.shippingDivider
            });
            return;
        }
        if (ordersummary.w() != null && !ordersummary.w().equals(c.ZERO)) goto _L2; else goto _L1
_L1:
        setTextViewCopyToFree(mViews.shippingChargeText);
_L4:
        al.b(new View[] {
            mViews.shippingView, mViews.shippingDivider
        });
        return;
_L2:
        if (ordersummary.x() == c.USD)
        {
            mViews.shippingChargeText.setTextColor(getContext().getResources().getColor(0x7f0f00f3));
            mViews.shippingChargeText.setTypeface(mViews.shippingChargeText.getTypeface(), 0);
            mViews.shippingChargeText.setText((new StringBuilder()).append("$").append(ordersummary.w()).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setTextViewCopyToFree(TextView textview)
    {
        textview.setText(getContext().getString(0x7f090208));
        textview.setTextColor(getContext().getResources().getColor(0x7f0f00e4));
        textview.setTypeface(textview.getTypeface(), 1);
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f030143, this);
        mViews = new Views(this);
    }

    public void a(OrderSummary ordersummary, DeliveryDetailsModel deliverydetailsmodel)
    {
        if (mViews == null)
        {
            return;
        }
        if (ordersummary.j() == c.USD)
        {
            mViews.subtotalText.setText((new StringBuilder()).append("$").append(ordersummary.i()).toString());
        }
        a(ordersummary);
        if (ordersummary.v().compareTo(c.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.stateFeesLayout, mViews.stateFeesDivider
            });
        } else
        {
            al.b(new View[] {
                mViews.stateFeesLayout, mViews.stateFeesDivider
            });
            mViews.stateFeesText.setText((new StringBuilder()).append("$").append(ordersummary.v()).toString());
        }
        if (ordersummary.g().compareTo(c.ZERO) == 0)
        {
            al.a(new View[] {
                mViews.savingsLayout, mViews.savingsDivider
            });
        } else
        {
            al.b(new View[] {
                mViews.savingsLayout, mViews.savingsDivider
            });
            mViews.savingsText.setText((new StringBuilder()).append("-$").append(ordersummary.h().abs()).toString());
        }
        if (ordersummary.u() == c.USD)
        {
            mViews.taxText.setText((new StringBuilder()).append("$").append(ordersummary.t()).toString());
        }
        b(ordersummary, deliverydetailsmodel);
        if (ordersummary.d() == c.USD)
        {
            mViews.totalText.setText((new StringBuilder()).append("$").append(ordersummary.c()).toString());
        }
        al.a(mViews.taxErrorView, ordersummary.q());
    }
}
