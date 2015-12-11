// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.ui.model.account.OrderPaymentCardDetailsModel;
import com.target.ui.util.al;
import com.target.ui.util.e;
import java.util.List;

public class AccountOrderDetailsPaymentView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView orderTotal;
        LinearLayout paymentCardContainer;
        View summarySeparator;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public AccountOrderDetailsPaymentView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsPaymentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public AccountOrderDetailsPaymentView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void a(View view, a a1)
    {
        e.a(a1, (ImageView)view.findViewById(0x7f1002e5));
    }

    private void a(View view, String s)
    {
        ((TextView)view.findViewById(0x7f1002e6)).setText(s);
    }

    private void a(View view, String s, int i)
    {
        view = (TextView)view.findViewById(0x7f1002e7);
        view.setText(s);
        view.setTextColor(i);
    }

    private void a(AppliedPayPalDetails appliedpaypaldetails)
    {
        View view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300f5, this, false);
        a(view, a.PAYPAL);
        a(view, getContext().getString(0x7f0900a3));
        a(view, com.target.ui.util.d.a.a(appliedpaypaldetails.a()), getResources().getColor(0x7f0f00f3));
        mViews.paymentCardContainer.addView(view);
    }

    private void a(List list)
    {
        LayoutInflater layoutinflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        int i = 0;
        while (i < list.size()) 
        {
            OrderPaymentCardDetailsModel orderpaymentcarddetailsmodel = (OrderPaymentCardDetailsModel)list.get(i);
            View view = layoutinflater.inflate(0x7f0300f5, this, false);
            a a1 = orderpaymentcarddetailsmodel.a();
            a(view, a1);
            a(view, getContext().getString(0x7f09027e, new Object[] {
                orderpaymentcarddetailsmodel.b()
            }));
            int j;
            if (a1 == a.TARGET_GIFT_CARD)
            {
                j = getResources().getColor(0x7f0f00ec);
            } else
            {
                j = getResources().getColor(0x7f0f00f3);
            }
            a(view, com.target.ui.util.d.a.a(orderpaymentcarddetailsmodel.c()), j);
            mViews.paymentCardContainer.addView(view, i);
            i++;
        }
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300f4, this);
        mViews = new Views(this);
    }

    public void a(AppliedPayPalDetails appliedpaypaldetails, String s)
    {
        if (appliedpaypaldetails == null)
        {
            al.a(new View[] {
                mViews.paymentCardContainer, mViews.summarySeparator
            });
        } else
        {
            a(appliedpaypaldetails);
        }
        mViews.orderTotal.setText(s);
    }

    public void a(List list, String s)
    {
        if (list.isEmpty())
        {
            al.a(new View[] {
                mViews.paymentCardContainer, mViews.summarySeparator
            });
        } else
        {
            a(list);
        }
        mViews.orderTotal.setText(s);
    }
}
